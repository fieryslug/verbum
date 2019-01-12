package com.fieryslug.verbum.object.creativetab;

import com.fieryslug.verbum.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabVerbum extends CreativeTabs {

    public TabVerbum() {
        super("verbum");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemInit.INGOT_MAGIC_STEEL);
    }
}
