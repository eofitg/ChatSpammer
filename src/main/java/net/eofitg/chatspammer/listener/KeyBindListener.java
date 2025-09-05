package net.eofitg.chatspammer.listener;

import net.eofitg.chatspammer.ChatSpammer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class KeyBindListener {
    private final KeyBinding spam = new KeyBinding("Spam", Keyboard.KEY_UP, "ChatSpammer");
    private final Minecraft mc = Minecraft.getMinecraft();

    public static boolean wasCommandKeyPressed = false;

    public KeyBindListener() {
        ClientRegistry.registerKeyBinding(spam);
    }

    @SubscribeEvent
    public void onKeyPress(InputEvent.KeyInputEvent event) {
        if (mc == null || mc.gameSettings == null) return;
        if (!Keyboard.getEventKeyState()) return;

        GameSettings settings = mc.gameSettings;
        int keyCode = Keyboard.getEventKey();

        if (keyCode == settings.keyBindChat.getKeyCode()) {
            wasCommandKeyPressed = false;
        }
        else if (keyCode == settings.keyBindCommand.getKeyCode()) {
            wasCommandKeyPressed = true;
        }
        else if (keyCode == spam.getKeyCode()) {
            ChatSpammer.spam.execute();
        }
    }
}
