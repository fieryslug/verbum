package com.fieryslug.verbum.object.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockCrystal extends BlockBase {

    public BlockCrystal(String name, float hardness, float resistance) {

        super(name, Material.GLASS, hardness, resistance);

    }

    @Override
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public void registerModels() {
        //super.registerModels();
    }
}
