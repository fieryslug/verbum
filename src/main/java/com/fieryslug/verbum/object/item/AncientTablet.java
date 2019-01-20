package com.fieryslug.verbum.object.item;

import com.fieryslug.verbum.VerbumMod;
import com.fieryslug.verbum.init.BlockInit;
import com.fieryslug.verbum.init.ItemInit;
import com.fieryslug.verbum.util.enumer.EnumCondition;
import com.fieryslug.verbum.util.IHasModel;
import com.fieryslug.verbum.util.handler.GuiHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimeknights.mantle.Mantle;

import javax.annotation.Nullable;
import java.util.List;

public class AncientTablet extends Item implements IHasModel {

    private EnumCondition condition;

    public AncientTablet(String name, EnumCondition condition) {

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(VerbumMod.TAB_VERBUM);
        setMaxStackSize(1);

        this.condition = condition;

        ItemInit.ITEMS.add(this);

    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

        return super.onItemRightClick(worldIn, playerIn, handIn);
        /*
        BlockPos pos = playerIn.getPosition();
        playerIn.openGui(VerbumMod.instance, GuiHandler.GUI_ANCIENT_TABLET, worldIn, pos.getX(), pos.getY(), pos.getZ());


        return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
        */
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {

        String inscription = "";
        boolean revealed = false;
        if(stack.hasTagCompound()) {
            NBTTagCompound tagCompound = stack.getTagCompound();
            inscription = tagCompound.getString("inscription");
            revealed = tagCompound.getBoolean("revealed");

        }

        if(!inscription.equals("") && revealed)
            addStringToTooltip("&r&l&4"+inscription, tooltip);

    }

    private void addStringToTooltip(String s, List<String> tooltip) {
        tooltip.add(s.replaceAll("&", "\u00a7"));
    }

    @Override
    public boolean onEntityItemUpdate(EntityItem entityItem) {


        NBTTagCompound tagCompound = new NBTTagCompound();
        entityItem.writeToNBT(tagCompound);
        NBTTagCompound itemTag = tagCompound.getCompoundTag("Item");
        NBTTagCompound tagTag = itemTag.getCompoundTag("tag");
        System.out.println(tagTag.toString());

        if(!tagTag.getBoolean("revealed")) {

            BlockPos pos = entityItem.getPosition();
            if (entityItem.world.getBlockState(pos) == BlockInit.BLOCK_ALCHEMIC_SOLUTION.getDefaultState()) {
                entityItem.world.setBlockState(pos, Blocks.WATER.getDefaultState());
                tagTag.setBoolean("revealed", true);
                itemTag.setTag("tag", tagTag);
                tagCompound.setTag("Item", itemTag);
                entityItem.readFromNBT(tagCompound);
            }
        }
        /*
        if(entityItem.isInWater() && !tagTag.getBoolean("revealed")) {
            tagTag.setBoolean("revealed", true);
            itemTag.setTag("tag", tagTag);
            tagCompound.setTag("Item", itemTag);
            entityItem.readFromNBT(tagCompound);
        }
        */
        return false;

    }

    @Override
    public void registerModels() {

        VerbumMod.proxy.registerModel(this, 0, "inventory");

    }
}
