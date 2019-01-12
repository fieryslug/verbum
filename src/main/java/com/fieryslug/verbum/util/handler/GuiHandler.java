package com.fieryslug.verbum.util.handler;

import com.fieryslug.verbum.gui.GuiAncientTablet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {

    public static final int GUI_ANCIENT_TABLET = 0;

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        if(ID == GUI_ANCIENT_TABLET)
            return null;


        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        if(ID == GUI_ANCIENT_TABLET) {
            return new GuiAncientTablet(player);
        }


        return null;
    }
}
