package com.fieryslug.verbum.proxy;

import com.fieryslug.verbum.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerModel(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
        System.out.println("%%%%%%%%%%%");
        System.out.println(item.getRegistryName());
        System.out.println(item.getUnlocalizedName());
    }

    @Override
    public void registerModel(Item item, int meta, String id, String customResouce) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Reference.MODID + ":" + customResouce, id));
    }
}
