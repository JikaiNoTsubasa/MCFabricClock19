package fr.triedge.mc.mod;

import java.awt.Color;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class Deep {
	
	private int color;
	
	private Identifier texDiam;
	private Identifier texIron;
	private Identifier texGold;
	private Identifier texEmerald;
	private Identifier texCopper;
	
	public Deep() {
		color = new Color(255, 255, 255).getRGB();
		texDiam = new Identifier(MCFabricClockPlugin.MODID, "textures/tex_diam.png");
		texIron = new Identifier(MCFabricClockPlugin.MODID, "textures/tex_iron.png");
		texGold = new Identifier(MCFabricClockPlugin.MODID, "textures/tex_gold.png");
		texEmerald = new Identifier(MCFabricClockPlugin.MODID, "textures/tex_emerald.png");
		texCopper = new Identifier(MCFabricClockPlugin.MODID, "textures/tex_copper.png");
	}

	@SuppressWarnings("resource")
	public void render(MatrixStack matrices) {
		int w = MinecraftClient.getInstance().getWindow().getScaledWidth();
		int h = MinecraftClient.getInstance().getWindow().getScaledHeight();
		int xLocation = w - 55;
		int yLocation = h - 25;
		int y = (int) MinecraftClient.getInstance().player.getPos().getY();
		DrawableHelper.drawStringWithShadow(matrices, MinecraftClient.getInstance().textRenderer, y+"", xLocation+12, yLocation, color);
		
		int hi = getBar(y, ORE.IRON);
		RenderSystem.setShaderTexture(0, texIron);
		DrawableHelper.drawTexture(matrices, xLocation, yLocation-hi+8, 0, 0, 0, 2, hi, 1, 1);
		
		hi = getBar(y, ORE.DIAM);
		RenderSystem.setShaderTexture(0, texDiam);
		DrawableHelper.drawTexture(matrices, xLocation+2, yLocation-hi+8, 0, 0, 0, 2, hi, 1, 1);
		
		hi = getBar(y, ORE.COPPER);
		RenderSystem.setShaderTexture(0, texCopper);
		DrawableHelper.drawTexture(matrices, xLocation+4, yLocation-hi+8, 0, 0, 0, 2, hi, 1, 1);
		
		hi = getBar(y, ORE.EMERALD);
		RenderSystem.setShaderTexture(0, texEmerald);
		DrawableHelper.drawTexture(matrices, xLocation+6, yLocation-hi+8, 0, 0, 0, 2, hi, 1, 1);
		
		hi = getBar(y, ORE.GOLD);
		RenderSystem.setShaderTexture(0, texGold);
		DrawableHelper.drawTexture(matrices, xLocation+8, yLocation-hi+8, 0, 0, 0, 2, hi, 1, 1);
	}
	
	/**
	 * 
	 * @param level
	 * @return min 1 and max 10
	 */
	private int getBar(int level, ORE ore) {
		float percent = Utils.getPercent(ore.min, ore.max, level);
		int height = (int) (percent * 0.1);
		
		if (height <= 0)
			return 1;
		
		return height;
	}
}
