package com.fieryslug.verbum.init;

import com.fieryslug.verbum.object.block.*;
import com.fieryslug.verbum.object.block.ore.OrePrecantate;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {

    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final Block BLOCK_MAGIC_STEEL = new BlockBase("block_magic_steel", Material.ROCK, 8.0F, 24.0F);
    public static final Block ORE_PRECANTATE = new OrePrecantate("ore_precantate");
    public static final Block GRASS_CHARRED = new BlockDirtBase("grass_charred", 0.5F, 1.5F);
    public static final Block BASALT = new BlockBase("basalt", Material.ROCK, 4.2F, 4.5F);
    public static final Block BRICKS_BASALT = new BlockBricks("bricks_basalt", Material.ROCK, 4.2F, 4.5F, new String[] {"bricks_basalt", "", "bricks_basalt_cracked", "bricks_basalt_carved", "bricks_basalt_polished"});

    public static final Block LOG_CECROPIA = new BlockWood("log_cecropia", 2.5F, 2.0F);
    public static final Block LEAVES_CECROPIA = new BlockVerbumLeaves("leaves_cecropia");
    public static final Block PLANK_CECROPIA = new BlockBase("plank_cecropia", Material.WOOD, 2.5F, 2.0F);

    public static final Block CRYSTAL_PRECANTATE = new BlockCrystal("crystal_cluster_precantate", 3.5F, 6.8F);

    public static final Block BLOCK_ALCHEMIC_SOLUTION = new BlockFluid("solution_alchemic", FluidInit.ALCHEMIC_SOlUTION, Material.WATER);


}
