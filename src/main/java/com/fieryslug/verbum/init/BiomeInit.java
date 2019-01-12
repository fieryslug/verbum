package com.fieryslug.verbum.init;

import com.fieryslug.verbum.world.biome.BiomeVolcanicRavines;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeInit {

    public static final Biome BIOME_PRECANTATE = null;
    public static final Biome FROZEN_PEAKS = null;
    public static final Biome VOLCANIC_RAVINES = new BiomeVolcanicRavines();
    public static final Biome OVERGROWTH_JUNGLE = null;
    public static final Biome BIOME_ = null;

    public static void registerBiomes() {

        initBiome(VOLCANIC_RAVINES, "ravines_volcanic", 50, BiomeManager.BiomeType.WARM, BiomeDictionary.Type.DEAD, BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.MESA);


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
