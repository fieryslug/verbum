package com.fieryslug.verbum.object.block.ore;

import com.fieryslug.verbum.VerbumMod;
import com.fieryslug.verbum.init.BlockInit;
import com.fieryslug.verbum.init.ItemInit;
import com.fieryslug.verbum.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import java.util.Random;

public class OrePrecantate extends Block implements IHasModel {

    public OrePrecantate(String name) {

        super(Material.ROCK);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(4.5F);
        setResistance(11F);
        setCreativeTab(VerbumMod.TAB_VERBUM);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(name).setUnlocalizedName(name));

    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {

        return ItemInit.PRECANTATE_CRYSTAL;

    }

    @Override
    public int quantityDropped(Random random) {
        return 1;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {

        if(fortune > 0) {

            int i = random.nextInt(fortune + 2) - 1;
            if(i < 0) i = 0;

            return quantityDropped(random) * (i+1);

        }

        return quantityDropped(random);

    }

    @Override
    public void registerModels() {

        VerbumMod.proxy.registerModel(Item.getItemFromBlock(this), 0, "inventory");

    }
}
