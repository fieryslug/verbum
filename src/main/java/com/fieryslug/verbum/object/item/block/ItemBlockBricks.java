package com.fieryslug.verbum.object.item.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class ItemBlockBricks extends ItemMultiTexture {

    //private static String[] names = new String[]{"bricks_basalt", "", "bricks_basalt_cracked", "bricks_basalt_carved"};
    private String[] names;

    public ItemBlockBricks(Block block, String name, String[] names) {

        super(block, block, names);
        this.names = names;
        setRegistryName(name);

    }

    @Nonnull
    @Override
    public String getUnlocalizedName(ItemStack stack) {

        int meta = stack.getMetadata();
        return meta < this.names.length ? this.names[meta] : "";

    }




}
