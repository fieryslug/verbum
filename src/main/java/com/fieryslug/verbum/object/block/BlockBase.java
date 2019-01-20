package com.fieryslug.verbum.object.block;


import com.fieryslug.verbum.VerbumMod;
import com.fieryslug.verbum.init.BlockInit;
import com.fieryslug.verbum.init.ItemInit;
import com.fieryslug.verbum.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
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

        setSoundType(selectSound(material));

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        //Item item = new ItemBlock(this).setRegistryName(this.getRegistryName());

    }

    private SoundType selectSound(Material material) {

        if(material == Material.ROCK)
            return SoundType.STONE;
        if(material == Material.GROUND)
            return SoundType.GROUND;
        if(material == Material.PLANTS)
            return SoundType.PLANT;
        if(material == Material.WOOD)
            return SoundType.WOOD;
        if(material == Material.SAND)
            return SoundType.SAND;

        return SoundType.STONE;

    }

    @Override
    public void registerModels() {
        VerbumMod.proxy.registerModel(Item.getItemFromBlock(this), 0, "inventory");
    }

}
