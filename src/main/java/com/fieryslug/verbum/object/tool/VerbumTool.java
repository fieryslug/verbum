package com.fieryslug.verbum.object.tool;

import com.fieryslug.verbum.VerbumMod;
import com.fieryslug.verbum.init.ItemInit;
import com.fieryslug.verbum.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;

import java.util.Set;

public abstract class VerbumTool extends ItemTool implements IHasModel {

    public VerbumTool(Item.ToolMaterial material, String name, Set<Block> effectiveBlocks, String toolClass, int level) {

        super(material, effectiveBlocks);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(VerbumMod.TAB_VERBUM);
        setHarvestLevel(toolClass, level);

        ItemInit.ITEMS.add(this);


    }

    @Override
    public void registerModels() {

        VerbumMod.proxy.registerModel(this, 0, "inventory");

    }
}
