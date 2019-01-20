package com.fieryslug.verbum.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeOvergrowthTimberland extends Biome {

    public BiomeOvergrowthTimberland() {

        super(new BiomeProperties("Overgrowth Timberland").setTemperature(2.5F).setWaterColor(4960422).setRainfall(3.5F).setBaseHeight(-0.3F).setHeightVariation(0.1F));

        this.topBlock = Blocks.GRASS.getDefaultState();
        this.fillerBlock = Blocks.COAL_BLOCK.getDefaultState();

    }
}
