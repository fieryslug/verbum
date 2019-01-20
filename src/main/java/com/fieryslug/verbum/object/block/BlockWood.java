package com.fieryslug.verbum.object.block;

import com.fieryslug.verbum.util.enumer.EnumAxis;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockWood extends BlockBase {

    public static final PropertyEnum<EnumAxis> LOG_AXIS = PropertyEnum.create("axis", EnumAxis.class);

    public BlockWood(String name, float hardness, float resistance) {

        super(name, Material.WOOD, hardness, resistance);
        setSoundType(SoundType.WOOD);
        setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, EnumAxis.Y));
    }

    @Override
    protected BlockStateContainer createBlockState() {

        return new BlockStateContainer(this, LOG_AXIS);

    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {

        EnumAxis axis = EnumAxis.Y;

        switch(facing.getAxis()) {
            case X:
                axis = EnumAxis.X;
                break;
            case Y:
                axis = EnumAxis.Y;
                break;
            case Z:
                axis = EnumAxis.Z;
                break;
        }

        return getStateFromMeta(meta).withProperty(LOG_AXIS, axis);

    }

    @Override
    public int getMetaFromState(IBlockState state) {

        int meta = 0;
        switch(state.getValue(LOG_AXIS)) {

            case X:
                meta = 2;
                break;
            case Y:
                meta = 4;
                break;
            case Z:
                meta = 6;
                break;
        }
        return meta;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {

        IBlockState state = getDefaultState();
        switch(meta) {

            case 2:
                state = state.withProperty(LOG_AXIS, EnumAxis.X);
                break;
            case 4:
                state = state.withProperty(LOG_AXIS, EnumAxis.Y);
                break;
            case 6:
                state = state.withProperty(LOG_AXIS, EnumAxis.Z);
                break;
            default:
                ;
        }

        return state;

    }
}
