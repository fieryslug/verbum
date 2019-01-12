package com.fieryslug.verbum.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerItemRendrer(Item item, int meta, String id) {
        System.out.println("12345678CLIENTPROXYREGISTRY");
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
    }
}
