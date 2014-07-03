package net.BradTech.mod.handler;

import net.BradTech.mod.KeyBindings;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyInputHandler {

	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		
		if(KeyBindings.ping.isPressed())
			System.out.println("PING Key Pressed...");
		
		if(KeyBindings.pong.isPressed())
			System.out.println("PONG Key Pressed...");
	}

}
