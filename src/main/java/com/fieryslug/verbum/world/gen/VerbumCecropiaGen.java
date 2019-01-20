package com.fieryslug.verbum.world.gen;

import com.fieryslug.verbum.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VerbumCecropiaGen extends WorldGenAbstractTree {

    public static final IBlockState LOG = BlockInit.LOG_CECROPIA.getDefaultState();
    public static final IBlockState LEAVES = BlockInit.LEAVES_CECROPIA.getDefaultState().withProperty(BlockLeaves.DECAYABLE, true).withProperty(BlockLeaves.CHECK_DECAY, true);
    public static final IBlockState LEAVES_OUTER = BlockInit.LEAVES_CECROPIA.getDefaultState().withProperty(BlockLeaves.DECAYABLE, true).withProperty(BlockLeaves.CHECK_DECAY, false);
    private int minHeight;

    public VerbumCecropiaGen() {

        super(false);
        this.minHeight = 7;

    }

    private boolean isPosLegal(World world, BlockPos pos) {

        int y = pos.getY();
        if(y < 0 || y >= world.getHeight())
            return false;
        return this.isReplaceable(world, pos);

    }

    @Override
    protected boolean canGrowInto(Block blockType) {
        return super.canGrowInto(blockType);
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {

        int height = this.minHeight + rand.nextInt(4);

        int x = position.getX();
        int y = position.getY();
        int z = position.getZ();

        List<BlockPos> leafPos = new ArrayList<>();
        List<BlockPos> logPos = new ArrayList<>();
        List<BlockPos> leafPosOuter = new ArrayList<>();

        //add pos's to treePpos
        for (int yPos = y; yPos <= y + 1 + height; ++yPos) {

            System.out.println("POS " + x + " " + yPos + " " + z);
            logPos.add(new BlockPos(x, yPos, z));
            if(yPos >= 5 && rand.nextInt(2) == 0) {
                int facing = rand.nextInt(4);
                int lim;
                switch(facing) {

                    case 0:
                        logPos.add(new BlockPos(x+1, yPos, z));
                        lim = x+2+rand.nextInt(3);
                        for(int x0 = x+2; x0 <= lim; ++x0) {

                            leafPos.add(new BlockPos(x0, yPos, z));
                            if(rand.nextInt(5) > 0) {
                                leafPosOuter.add(new BlockPos(x0, yPos, z+1));
                                leafPosOuter.add(new BlockPos(x0, yPos, z-1));
                            }

                        }
                        break;
                    case 1:
                        logPos.add(new BlockPos(x-1, yPos, z));
                        lim = x-2-rand.nextInt(3);
                        for(int x0 = x-2; x0 >= lim; --x0) {

                            leafPos.add(new BlockPos(x0, yPos, z));
                            if(rand.nextInt(5) > 0) {
                                leafPosOuter.add(new BlockPos(x0, yPos, z+1));
                                leafPosOuter.add(new BlockPos(x0, yPos, z-1));
                            }

                        }
                        break;
                    case 2:
                        logPos.add(new BlockPos(x, yPos, z+1));
                        lim = z+2+rand.nextInt(3);
                        for(int z0 = z+2; z0 <= lim; ++z0) {

                            leafPos.add(new BlockPos(x, yPos, z0));
                            if(rand.nextInt(5) > 0) {
                                leafPosOuter.add(new BlockPos(x+1, yPos, z0));
                                leafPosOuter.add(new BlockPos(x-1, yPos, z0));
                            }

                        }
                        break;
                    case 3:
                        logPos.add(new BlockPos(x, yPos, z-1));
                        lim = z-2-rand.nextInt(3);
                        for(int z0 = z-2; z0 >= z-2-rand.nextInt(3); --z0) {

                            leafPos.add(new BlockPos(x, yPos, z0));
                            if(rand.nextInt(5) > 0) {
                                leafPosOuter.add(new BlockPos(x+1, yPos, z0));
                                leafPosOuter.add(new BlockPos(x-1, yPos, z0));
                            }

                        }
                        break;

                }
            }


        }

        boolean flag = true;

        for(BlockPos pos : leafPos) {
            if(!this.isPosLegal(worldIn, pos)) {
                flag = false;
                System.out.println(pos.getX() + ", " + pos.getY() + ", " + pos.getZ() + " illegal");
            }
        }
        for(BlockPos pos : logPos) {
            if(!this.isPosLegal(worldIn, pos)) {
                flag = false;
                System.out.println(pos.getX() + ", " + pos.getY() + ", " + pos.getZ() + " illegal");
            }
        }
        for(BlockPos pos : leafPosOuter) {
            if(!this.isPosLegal(worldIn, pos)) {
                flag = false;
            }
        }

        if(!flag) {
            return false;
        }
        else {

            BlockPos down = position.down();
            IBlockState state = worldIn.getBlockState(down);
            boolean isSoil = state.getBlock().canSustainPlant(state, worldIn, down, EnumFacing.UP, (IPlantable) Blocks.SAPLING);

            if(isSoil && y < worldIn.getHeight() - height - 1) {

                state.getBlock().onPlantGrow(state, worldIn, down, position);

                for(BlockPos pos : leafPos) {

                    IBlockState leafState = worldIn.getBlockState(pos);
                    if(leafState.getBlock().isAir(leafState, worldIn, pos)) {
                        this.setBlockAndNotifyAdequately(worldIn, pos, LEAVES);
                    }
                    System.out.println("1");

                }
                for(BlockPos pos : logPos) {

                    IBlockState logState = worldIn.getBlockState(pos);
                    if(logState.getBlock().isAir(logState, worldIn, pos)) {
                        this.setBlockAndNotifyAdequately(worldIn, pos, LOG);
                    }
                    System.out.println("2");

                }
                for(BlockPos pos : leafPosOuter) {

                    IBlockState leafState = worldIn.getBlockState(pos);
                    if (leafState.getBlock().isAir(leafState, worldIn, pos)) {
                        this.setBlockAndNotifyAdequately(worldIn, pos, LEAVES_OUTER);
                    }

                }




            }

            return true;
        }
    }
}
