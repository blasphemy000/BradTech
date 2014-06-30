package net.BradTech.mod;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;

public class ChatHelper {

	//Couple of helpers because the mcp names are stupid and long...
    private static ChatComponentTranslation formatText(EnumChatFormatting color, String str, Object... args)
    {
        ChatComponentTranslation ret = new ChatComponentTranslation(str, args);
        ret.getChatStyle().setColor(color);
        return ret;
    }

    
    public static void ExecPlayerCmd(String cmd) {
		// sendChatMessage is used to force the player to execute a command.
		//Minecraft.getMinecraft().thePlayer.sendChatMessage(msg);

   		Minecraft.getMinecraft().thePlayer.sendChatMessage(cmd);
    }
    

	public static void ErrorToChat(String errMsg) {
		// These are examples of displaying info to the player in the chat...
		//sender.addChatMessage(new ChatComponentTranslation("commands.forge.tracking.te.enabled", duration));
		//sender.addChatMessage(format(RED, "commands.generic.usage", format(RED, wue.getMessage(), wue.getErrorOjbects())));

   		Minecraft.getMinecraft().thePlayer.addChatMessage(formatText(EnumChatFormatting.RED, errMsg));
	}

    
	public static void WriteToChat(String msg) {
		// These are examples of displaying info to the player in the chat...
		//sender.addChatMessage(new ChatComponentTranslation("commands.forge.tracking.te.enabled", duration));
		//sender.addChatMessage(format(RED, "commands.generic.usage", format(RED, wue.getMessage(), wue.getErrorOjbects())));
   		Minecraft.getMinecraft().thePlayer.addChatMessage(formatText(EnumChatFormatting.WHITE, msg));
	}

    
	public static void WriteToChat(String color, String msg) {
    	EnumChatFormatting c = EnumChatFormatting.ITALIC;
    	
    	if(color == "BLACK")
    		c = EnumChatFormatting.BLACK;
    	else if(color == "DARK_BLUE")
    		c = EnumChatFormatting.DARK_BLUE;
    	else if(color == "DARK_GREEN")
    		c = EnumChatFormatting.DARK_GREEN;
    	else if(color == "DARK_AQUA")
    		c = EnumChatFormatting.DARK_AQUA;
    	else if(color == "DARK_RED")
    		c = EnumChatFormatting.DARK_RED;
    	else if(color == "DARK_PURPLE")
    		c = EnumChatFormatting.DARK_PURPLE;
    	else if(color == "GOLD")
    		c = EnumChatFormatting.GOLD;
    	else if(color == "GRAY")
    		c = EnumChatFormatting.GRAY;
    	else if(color == "DARK_GRAY")
    		c = EnumChatFormatting.DARK_GRAY;
    	else if(color == "BLUE")
    		c = EnumChatFormatting.BLUE;
    	else if(color == "GREEN")
    		c = EnumChatFormatting.GREEN;
    	else if(color == "AQUA")
    		c = EnumChatFormatting.AQUA;
    	else if(color == "RED")
    		c = EnumChatFormatting.RED;
    	else if(color == "LIGHT_PURPLE")
    		c = EnumChatFormatting.LIGHT_PURPLE;
    	else if(color == "YELLOW")
    		c = EnumChatFormatting.YELLOW;
    	else if(color == "WHITE")
    		c = EnumChatFormatting.WHITE;
    	else if(color == "RESET")
    		c = EnumChatFormatting.RESET;
    	
    	Minecraft.getMinecraft().thePlayer.addChatMessage(formatText(c, msg));
	}
    
    
}












