package net.eofitg.chatspammer.hook;

import net.eofitg.chatspammer.ChatSpammer;
import net.minecraft.client.gui.GuiChat;

public class GuiChatHook extends GuiChat {
    public GuiChatHook(String defaultText) {
        super(defaultText);
    }

    @Override
    public void sendChatMessage(String msg, boolean addToChat) {
        ChatSpammer.spam.lastMessage = msg;
        super.sendChatMessage(msg, addToChat);
    }
}
