package com.fieryslug.verbum.object.tool;

import com.fieryslug.verbum.VerbumMod;
import com.fieryslug.verbum.init.ItemInit;
import com.fieryslug.verbum.util.IHasModel;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

import java.util.Set;

public class ToolAxe extends VerbumTool {

    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE);

    public ToolAxe(ToolMaterial toolMaterial, String name) {

        super(toolMaterial, name, EFFECTIVE_ON, "axe", toolMaterial.getHarvestLevel());

    }

    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state) {

        Material material = state.getMaterial();
        return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? super.getDestroySpeed(stack, state) : this.efficiency;

    }
}
