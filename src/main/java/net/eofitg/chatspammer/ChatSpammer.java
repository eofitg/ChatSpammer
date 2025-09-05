package net.eofitg.chatspammer;

import net.eofitg.chatspammer.feat.Spam;
import net.eofitg.chatspammer.listener.GuiOpenListener;
import net.eofitg.chatspammer.listener.KeyBindListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(
        modid = "chatspammer",
        name = "Chat Spammer",
        version = "1.0",
        acceptedMinecraftVersions = "[1.8.9]"
)
public class ChatSpammer {
    public static final Spam spam = new Spam();

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(new GuiOpenListener());
        MinecraftForge.EVENT_BUS.register(new KeyBindListener());
    }
}
