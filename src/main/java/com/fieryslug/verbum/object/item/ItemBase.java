package com.fieryslug.verbum.object.item;

import com.fieryslug.verbum.VerbumMod;
import com.fieryslug.verbum.init.ItemInit;
import com.fieryslug.verbum.util.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemBase extends Item implements IHasModel {

    public ItemBase(String name) {

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(VerbumMod.TAB_VERBUM);
        ItemInit.ITEMS.add(this);

    }

    @Override
    public void registerModels() {

        VerbumMod.proxy.registerItemRendrer(this, 0, "inventory");

    }
}
