package com.fieryslug.verbum.object.tool;

import com.fieryslug.verbum.VerbumMod;
import com.fieryslug.verbum.init.ItemInit;
import com.fieryslug.verbum.util.IHasModel;
import net.minecraft.item.ItemTool;
import scala.collection.immutable.Set;

import java.util.HashSet;

public class ToolSword extends ItemTool implements IHasModel {

    public ToolSword(ToolMaterial toolMaterial, String name) {

        super(toolMaterial, new HashSet<>());
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
