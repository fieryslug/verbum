package com.fieryslug.verbum.world.gen;

import com.fieryslug.verbum.init.BlockInit;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class VerbumOreGen implements IWorldGenerator {

    private WorldGenerator orePrecantate;

    public VerbumOreGen() {

        orePrecantate = new WorldGenMinable(BlockInit.ORE_PRECANTATE.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.STONE));

    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

        switch (world.provider.getDimension()) {

            case 0:
                runGenerator(orePrecantate, world, random, chunkX, chunkZ, 7, 4, 12);
                break;
            case 1:
                break;
            case -1:
                break;

        }

    }

    private void runGenerator(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight) {

        if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256)
            throw new IllegalArgumentException("Oregen out of bounds");

        int diffHeight = maxHeight - minHeight;
        for(int i=0; i<chance; ++i) {

            int x = chunkX * 16 + random.nextInt(16);
            int z = chunkZ * 16 + random.nextInt(16);
            int y = minHeight + random.nextInt(diffHeight);

            generator.generate(world, random, new BlockPos(x, y, z));
        }


    }
}
