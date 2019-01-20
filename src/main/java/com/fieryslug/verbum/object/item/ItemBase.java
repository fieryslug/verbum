package com.fieryslug.verbum.object.item;

import com.fieryslug.verbum.VerbumMod;
import com.fieryslug.verbum.init.ItemInit;
import com.fieryslug.verbum.util.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

    public ItemBase(String name) {

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(VerbumMod.TAB_VERBUM);
        ItemInit.ITEMS.add(this);

    }

    @Override
    public void registerModels() {

        VerbumMod.proxy.registerModel(this, 0, "inventory");

    }
}
