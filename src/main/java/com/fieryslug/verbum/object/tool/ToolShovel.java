package com.fieryslug.verbum.object.tool;

import com.fieryslug.verbum.VerbumMod;
import com.fieryslug.verbum.init.ItemInit;
import com.fieryslug.verbum.util.IHasModel;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Set;

public class ToolShovel extends VerbumTool {

    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.CLAY, Blocks.DIRT, Blocks.FARMLAND, Blocks.GRASS, Blocks.GRAVEL, Blocks.MYCELIUM, Blocks.SAND, Blocks.SNOW, Blocks.SNOW_LAYER, Blocks.SOUL_SAND, Blocks.GRASS_PATH, Blocks.CONCRETE_POWDER);


    public ToolShovel(ToolMaterial toolMaterial, String name) {

        super(toolMaterial, name, EFFECTIVE_ON, "shovel", toolMaterial.getHarvestLevel());

    }

    @Override
    public boolean canHarvestBlock(IBlockState blockIn) {

        Block block = blockIn.getBlock();
        return block == Blocks.SNOW_LAYER || block == Blocks.SNOW;

    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return Items.DIAMOND_SHOVEL.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }
}
