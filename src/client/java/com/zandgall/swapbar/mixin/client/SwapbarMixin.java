package com.zandgall.swapbar.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.screen.slot.SlotActionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;
import java.awt.event.KeyEvent;

@Mixin(TitleScreen.class)
public class SwapbarMixin {
	private static boolean initiated = false;

	private void switchSlot(int i) {
		ClientPlayerEntity player = MinecraftClient.getInstance().player;
		if(player != null && player.getInventory()!=null) {
			switchSlot(i, player);
		}
	}

	private void switchSlot(int i, ClientPlayerEntity player) {
		int top = i + 9;
		int mid = top + 9;
		int bot = mid + 9;
		MinecraftClient.getInstance().interactionManager.clickSlot(0, bot, i, SlotActionType.SWAP, player);
		MinecraftClient.getInstance().interactionManager.clickSlot(0, mid, i, SlotActionType.SWAP, player);
		MinecraftClient.getInstance().interactionManager.clickSlot(0, top, i, SlotActionType.SWAP, player);
	}

	@Inject(method = "tick", at = @At("TAIL"))
	public void tick(final CallbackInfo info) {
		if(initiated) {
			KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(e -> {
				System.out.println("Key pressed");
				if(e.getID()== KeyEvent.KEY_PRESSED)
					switch(e.getKeyCode()) {
						case KeyEvent.VK_1: switchSlot(0); break;
						case KeyEvent.VK_2: switchSlot(1); break;
						case KeyEvent.VK_3: switchSlot(2); break;
						case KeyEvent.VK_4: switchSlot(3); break;
						case KeyEvent.VK_5: switchSlot(4); break;
						case KeyEvent.VK_6: switchSlot(5); break;
						case KeyEvent.VK_7: switchSlot(6); break;
						case KeyEvent.VK_8: switchSlot(7); break;
						case KeyEvent.VK_9: switchSlot(8); break;
					}
				return false;
			});
			initiated = true;
		}

	}
}