package com.fieryslug.verbum.object.fluid;

import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;

public class FluidLiquid extends Fluid {
    public FluidLiquid(String name, ResourceLocation still, ResourceLocation flow) {
        super(name, still, flow);
        setDensity(1500);

    }

    @Override
    public SoundEvent getFillSound(World world, BlockPos pos) {
        return SoundEvents.BLOCK_CHEST_OPEN;
    }
}
