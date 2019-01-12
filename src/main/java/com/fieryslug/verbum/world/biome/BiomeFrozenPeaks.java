package com.fieryslug.verbum.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class BiomeFrozenPeaks extends Biome {

    public BiomeFrozenPeaks() {

        super(new BiomeProperties("Frozen Peaks").setWaterColor(122).setSnowEnabled().setTemperature(0.05F).setBaseHeight(0.8F).setHeightVariation(2.4F));
        this.topBlock = Blocks.PACKED_ICE.getDefaultState();
        this.fillerBlock = Blocks.ICE.getDefaultState();

    }

}
