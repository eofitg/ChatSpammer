package net.eofitg.chatspammer.feat;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class Spam {
    public String lastMessage = null;
    private final Minecraft mc = Minecraft.getMinecraft();

    public void execute() {
        if (mc == null || mc.thePlayer == null) return;

        if (lastMessage == null) {
            mc.thePlayer.addChatMessage(new ChatComponentText("§cYou haven't send any messages!"));
        } else {
            mc.thePlayer.sendChatMessage(lastMessage);
        }
    }
}
