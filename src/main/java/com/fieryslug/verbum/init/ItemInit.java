package com.fieryslug.verbum.init;

import com.fieryslug.verbum.Reference;
import com.fieryslug.verbum.object.armor.ArmorHelm;
import com.fieryslug.verbum.object.item.AncientTablet;
import com.fieryslug.verbum.object.item.ItemBase;
import com.fieryslug.verbum.object.tool.*;
import com.fieryslug.verbum.util.enumer.EnumCondition;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;


public class ItemInit {


    public static final Item.ToolMaterial TOOL_MAGIC_STEEL
            = EnumHelper.addToolMaterial("tool_magic_steel", 3, 846, 7.5f, 56.0F, 128);
    public static final ItemArmor.ArmorMaterial ARMOR_MAGIC_STEEL
            = EnumHelper.addArmorMaterial("armor_magic_steel", Reference.MODID + ":magic_steel", 20, new int[]{2, 5, 7, 2}, 30, SoundEvents.BLOCK_ANVIL_BREAK, 3.0F);


    public static final List<Item> ITEMS = new ArrayList<>();

    public static final Item INGOT_MAGIC_STEEL = new ItemBase("ingot_magic_steel");
    public static final Item PRECANTATE_CRYSTAL = new ItemBase("crystal_precantate");

    public static final Item SWORD_MAGIC_STEEL = new ToolSword(TOOL_MAGIC_STEEL, "sword_magic_steel");
    public static final Item PICKAXE_MAGIC_STEEL = new ToolPickaxe(TOOL_MAGIC_STEEL, "pickaxe_magic_steel");
    public static final Item AXE_MAGIC_STEEL = new ToolAxe(TOOL_MAGIC_STEEL, "axe_magic_steel");
    public static final Item SHOVEL_MAGIC_STEEL = new ToolShovel(TOOL_MAGIC_STEEL, "shovel_magic_steel");
    //public static final Item HOE_MAGIC_STEEL = new ToolHoe(TOOL_MAGIC_STEEL, "hoe_magic_steel");

    public static final Item HELM_MAGIC_STEEL = new ArmorHelm(ARMOR_MAGIC_STEEL, 3, "helm_magic_steel");

    public static final Item ANCIENT_TABLET = new AncientTablet("ancient_tablet", EnumCondition.NEUTRAL);
    public static final Item ANCIENT_TABLET_WATER = new AncientTablet("ancient_tablet_damp", EnumCondition.WET);
    public static final Item ANCIENT_TABLET_FIRE = new AncientTablet("ancient_tablet_parched", EnumCondition.DRY);


}