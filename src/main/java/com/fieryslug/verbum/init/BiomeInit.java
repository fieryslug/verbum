package com.fieryslug.verbum.init;

import com.fieryslug.verbum.world.biome.BiomeFrozenPeaks;
import com.fieryslug.verbum.world.biome.BiomeOvergrowthTimberland;
import com.fieryslug.verbum.world.biome.BiomeVolcanicRavines;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeForest;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeInit {

    public static final Biome BIOME_PRECANTATE = null;
    public static final Biome FROZEN_PEAKS = new BiomeFrozenPeaks();
    public static final Biome VOLCANIC_RAVINES = new BiomeVolcanicRavines();
    public static final Biome OVERGROWTH_TIMBLERLAND = new BiomeOvergrowthTimberland();
    public static final Biome BIOME_ = null;

    public static void registerBiomes() {

        initBiome(VOLCANIC_RAVINES, "ravines_volcanic", 50, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.MESA);
        initBiome(FROZEN_PEAKS, "peaks_frozen", 50, BiomeManager.BiomeType.ICY, BiomeDictionary.Type.COLD);
        initBiome(OVERGROWTH_TIMBLERLAND, "timberland_overgrowth", 50, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.LUSH);


    }

    private static Biome initBiome(Biome biome, String name, int weight, BiomeManager.BiomeType biomeType, BiomeDictionary.Type... types) {

        System.out.println("biome" + name + "initialized!");

        biome.setRegistryName(name);
        ForgeRegistries.BIOMES.register(biome);
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addBiome(biomeType, new BiomeManager.BiomeEntry(biome, weight));
        BiomeManager.addSpawnBiome(biome);
        return biome;

    }

}
