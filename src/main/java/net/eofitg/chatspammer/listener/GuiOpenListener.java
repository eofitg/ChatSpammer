package net.eofitg.chatspammer.listener;

import net.eofitg.chatspammer.hook.GuiChatHook;
import net.minecraft.client.gui.GuiChat;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GuiOpenListener {
    @SubscribeEvent
    public void onGuiOpen(GuiOpenEvent event) {
        if (event.gui instanceof GuiChat && !(event.gui instanceof GuiChatHook)) {
            String defaultText = KeyBindListener.wasCommandKeyPressed ? "/" : "";
            event.gui = new GuiChatHook(defaultText);
        }
    }
}
