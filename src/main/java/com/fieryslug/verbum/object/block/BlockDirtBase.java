package com.fieryslug.verbum.object.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class BlockDirtBase extends BlockBase {

    public BlockDirtBase(String name, float hardness, float resistance) {

        super(name, Material.GROUND, hardness, resistance);
        setSoundType(SoundType.GROUND);

    }

    @Override
    public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) {
        return true;
    }

    @Override
    public boolean isToolEffective(String type, IBlockState state) {
        return type.equals("shovel");
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Blocks.DIRT.getItemDropped(state, rand, fortune);
    }
}
