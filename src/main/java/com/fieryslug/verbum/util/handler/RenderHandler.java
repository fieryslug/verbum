package com.fieryslug.verbum.util.handler;

import com.fieryslug.verbum.init.BlockInit;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;

public class RenderHandler {

    public static void registerCustomMeshesAndStates() {
        ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(BlockInit.BLOCK_ALCHEMIC_SOLUTION), new ItemMeshDefinition() {

            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {
                return new ModelResourceLocation("verbum:solution_alchemic", "fluid");
            }
        });

        ModelLoader.setCustomStateMapper(BlockInit.BLOCK_ALCHEMIC_SOLUTION, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                return new ModelResourceLocation("verbum:solution_alchemic", "fluid");
            }
        });
    }

}
