package net.BradTech.mod;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;

public class KeyBindings {

	public static KeyBinding ping;
	public static KeyBinding pong;
	
	public static void SetupKeyBindings() {
		
		ping = new KeyBinding("key.ping", Keyboard.KEY_Y, "key.categories.bradtech");
		pong = new KeyBinding("key.pong", Keyboard.KEY_U, "key.categories.bradtech");
		
		
		ClientRegistry.registerKeyBinding(ping);
		ClientRegistry.registerKeyBinding(pong);
		
	}
	
}
