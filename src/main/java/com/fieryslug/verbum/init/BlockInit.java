package com.fieryslug.verbum.init;

import com.fieryslug.verbum.object.block.BlockBase;
import com.fieryslug.verbum.object.block.BlockDirtBase;
import com.fieryslug.verbum.object.block.ore.OrePrecantate;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {

    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final Block BLOCK_MAGIC_STEEL = new BlockBase("block_magic_steel", Material.ROCK, 8.0F, 24.0F);
    public static final Block ORE_PRECANTATE = new OrePrecantate("ore_precantate");
    public static final Block GRASS_CHARRED = new BlockDirtBase("grass_charred", 0.5F, 1.5F);
    public static final Block BASALT = new BlockBase("basalt", Material.ROCK, 4.2F, 4.5F);

}
