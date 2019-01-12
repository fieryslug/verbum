package com.fieryslug.verbum.object.armor;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ArmorHelm extends ItemArmor {

    public ArmorHelm(ArmorMaterial armorMaterial, int index,  String name) {

        super(armorMaterial, index, EntityEquipmentSlot.HEAD);

    }

}
