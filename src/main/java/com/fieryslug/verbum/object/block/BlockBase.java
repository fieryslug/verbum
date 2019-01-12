package com.fieryslug.verbum.object.block;


import com.fieryslug.verbum.VerbumMod;
import com.fieryslug.verbum.init.BlockInit;
import com.fieryslug.verbum.init.ItemInit;
import com.fieryslug.verbum.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {

    public BlockBase(String name, Material material, float hardness, float resistance) {

        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(VerbumMod.TAB_VERBUM);

        setHardness(hardness);
        setResistance(resistance);


        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));


    }

    @Override
    public void registerModels() {
        VerbumMod.proxy.registerItemRendrer(Item.getItemFromBlock(this), 0, "inventory");
    }

}
