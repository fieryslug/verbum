package com.fieryslug.verbum.object.tool;

import baubles.api.cap.IBaublesItemHandler;
import com.fieryslug.verbum.VerbumMod;
import com.fieryslug.verbum.init.ItemInit;
import com.fieryslug.verbum.util.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemTool;

import java.util.HashSet;

public class ToolSword extends ItemTool implements IHasModel {

    public ToolSword(ToolMaterial toolMaterial, String name) {

        super(toolMaterial, new HashSet<>());
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(VerbumMod.TAB_VERBUM);
        ItemInit.ITEMS.add(this);
        EntityPlayer player;
    }

    @Override
    public void registerModels() {

        VerbumMod.proxy.registerModel(this, 0, "inventory");

    }

}
