package com.fieryslug.verbum.gui;

import com.fieryslug.verbum.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.client.gui.recipebook.GuiRecipeBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemWritableBook;
import net.minecraft.util.ResourceLocation;

public class GuiAncientTablet extends GuiScreen {


    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/gui/ancient_tablet.png");

    private EntityPlayer player;

    public GuiAncientTablet(EntityPlayer player) {

        this.player = player;
        this.width = 80;

    }

    @Override
    public void initGui() {

        System.out.println("INITGUI!!");

    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {

        GlStateManager.color(1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURE);

        int i = (this.width - 192) / 2;
        int j = 12;

        this.drawTexturedModalRect(i, j, 0, 0, 192, 192);

        super.drawScreen(mouseX, mouseY, partialTicks);

    }

    @Override
    public void drawBackground(int tint) {

        //super.drawBackground(tint);
        GlStateManager.color(1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURE);
        this.drawTexturedModalRect(20, 20, 40, 40, 80, 80);


    }


}
