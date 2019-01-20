package com.fieryslug.verbum.init;

import com.fieryslug.verbum.object.fluid.FluidLiquid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;


public class FluidInit {

    public static final Fluid ALCHEMIC_SOlUTION = new FluidLiquid("solution_alchemic", new ResourceLocation("verbum:blocks/solution_alchemic_still"), new ResourceLocation("verbum:blocks/solution_alchemic_flow"));

    public static void registerFluids() {

        registerFluid(ALCHEMIC_SOlUTION);

    }

    private static void registerFluid(Fluid fluid) {

        FluidRegistry.registerFluid(fluid);
        FluidRegistry.addBucketForFluid(fluid);

    }

}
