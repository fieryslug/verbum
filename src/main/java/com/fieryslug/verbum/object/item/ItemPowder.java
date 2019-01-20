package com.fieryslug.verbum.object.item;

import com.fieryslug.verbum.init.BlockInit;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;

public class ItemPowder extends ItemBase {

    public ItemPowder(String name) {

        super(name);

    }

    @Override
    public boolean onEntityItemUpdate(EntityItem entityItem) {

        BlockPos pos = entityItem.getPosition();
        if(entityItem.isInWater() && entityItem.world.getBlockState(pos) == Blocks.WATER.getDefaultState()) {

            entityItem.world.setBlockState(entityItem.getPosition(), BlockInit.BLOCK_ALCHEMIC_SOLUTION.getDefaultState(), 3);
            NBTTagCompound compound = new NBTTagCompound();
            entityItem.writeToNBT(compound);
            NBTTagCompound compoundItem = compound.getCompoundTag("Item");
            int count = compoundItem.getInteger("Count");
            compoundItem.setInteger("Count", count-1);
            compound.setTag("Item", compoundItem);
            entityItem.readFromNBT(compound);

            //entityItem.readFromNBT(new NBTTagCompound());
        }
        return false;

    }
}
