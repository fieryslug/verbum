package com.fieryslug.verbum.world.gen;

import com.fieryslug.verbum.world.biome.BiomeOvergrowthTimberland;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class VerbumTreeGen implements IWorldGenerator {

    private final WorldGenerator CECROPIA = new VerbumCecropiaGen();
    //private final WorldGenerator JUNGLE = new WorldGenMegaJungle(false, 12, 6);


    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

        switch(world.provider.getDimension()) {

            case 0:
                runGenerator(CECROPIA, world, random, chunkX, chunkZ, 1, Blocks.GRASS, BiomeOvergrowthTimberland.class);
                runGenerator(CECROPIA, world, random, chunkX, chunkZ, 1, Blocks.GRASS, BiomeOvergrowthTimberland.class);
                //runGenerator(JUNGLE, world, random, chunkX, chunkZ, 1, Blocks.GRASS, BiomeOvergrowthTimberland.class);
                break;
            case -1:
                break;
            case 1:
                break;
        }

    }

    private void runGenerator(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes) {

        ArrayList<Class<?>> classList = new ArrayList<>(Arrays.asList(classes));

        int x = chunkX * 16 + random.nextInt(15);
        int z = chunkZ * 16 + random.nextInt(15);
        int y = generationHeight(world, x, z, topBlock);
        BlockPos pos = new BlockPos(x, y, z);

        Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();

        if (world.getWorldType() != WorldType.FLAT) {

            if (classList.contains(biome)) {

                if (random.nextInt(chance) == 0) {

                    generator.generate(world, random, pos);

                }

            }

        }

    }

    private static int generationHeight(World world, int x, int z, Block topBlock) {

        int y;

        for(y = world.getHeight(); y >= 0; --y) {

            Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
            if(block == topBlock)
                return y+1;

        }

        return y;

    }
}
