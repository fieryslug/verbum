package com.fieryslug.verbum.object.item;

import com.fieryslug.verbum.VerbumMod;
import com.fieryslug.verbum.init.ItemInit;
import com.fieryslug.verbum.util.enumer.EnumCondition;
import com.fieryslug.verbum.util.enumer.EnumElement;
import com.fieryslug.verbum.util.IHasModel;
import com.fieryslug.verbum.util.handler.GuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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

        BlockPos pos = playerIn.getPosition();
        playerIn.openGui(VerbumMod.instance, GuiHandler.GUI_ANCIENT_TABLET, worldIn, pos.getX(), pos.getY(), pos.getZ());


        return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));

    }

    @Override
    public void registerModels() {

        VerbumMod.proxy.registerItemRendrer(this, 0, "inventory");

    }
}
