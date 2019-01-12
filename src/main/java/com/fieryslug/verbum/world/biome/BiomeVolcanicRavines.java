package com.fieryslug.verbum.world.biome;

import com.fieryslug.verbum.init.BlockInit;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class BiomeVolcanicRavines extends Biome {

    public BiomeVolcanicRavines() {

        super(new BiomeProperties("Volcanic Ravines").setBaseHeight(0.5F).setHeightVariation(1.5F).setTemperature(3.5F).setRainDisabled().setWaterColor(10398685));
        this.topBlock = BlockInit.GRASS_CHARRED.getDefaultState();
        this.fillerBlock = BlockInit.BASALT.getDefaultState();

        this.decorator.generateFalls = true;
        this.decorator.andesiteGen = new WorldGenMinable(Blocks.LAVA.getDefaultState(), 35, BlockMatcher.forBlock(BlockInit.GRASS_CHARRED));
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        super.genTerrainBlocks(worldIn, rand, chunkPrimerIn, x, z, noiseVal);


    }
}
