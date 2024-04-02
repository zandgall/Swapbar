package com.zandgall.swapbar;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Identifier;

public class Swapbar implements ModInitializer {
	public static KeyBinding switchKey;
	private static KeyBinding createKeyBinding(Identifier id, InputUtil.Type type, int code, String category) {
		return KeyBindingHelper.registerKeyBinding(new KeyBinding("key." + id.getNamespace() + "." + id.getPath(), type, code, category));
	}

	private static PlayerInventory inventory;

	@Override
	public void onInitialize() {
		switchKey = createKeyBinding(
				new Identifier("hotbarswitcher", "swap"), InputUtil.Type.KEYSYM, 82, "key.hotbarswitcher.category");
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			ClientPlayerEntity player = MinecraftClient.getInstance().player;
			if (player != null) {
				inventory = player.getInventory();
				if (inventory != null && Swapbar.switchKey.wasPressed()) {
					for(int i = 0; i < 9; i++) {
						int top = i + 9;
						int mid = top + 9;
						int bot = mid + 9;
						if(Screen.hasAltDown()) {
							MinecraftClient.getInstance().interactionManager.clickSlot(0, bot, i, SlotActionType.SWAP, player);

							MinecraftClient.getInstance().interactionManager.clickSlot(0, mid, i, SlotActionType.SWAP, player);
							MinecraftClient.getInstance().interactionManager.clickSlot(0, top, i, SlotActionType.SWAP, player);
						} else {
							MinecraftClient.getInstance().interactionManager.clickSlot(0, top, i, SlotActionType.SWAP, player);
							MinecraftClient.getInstance().interactionManager.clickSlot(0, mid, i, SlotActionType.SWAP, player);
							MinecraftClient.getInstance().interactionManager.clickSlot(0, bot, i, SlotActionType.SWAP, player);
						}
					}
				}
			}
		});
	}
}