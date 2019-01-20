package com.fieryslug.verbum.util.handler;

import com.fieryslug.verbum.init.ItemInit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class MobDropHandler {

    private static Random random = new Random();
    private static final String[] INSCRIPTIONS = {
      "HUC ARE",
      "UDINE CUX QOBBI",
      "RET HUC ISSIL NIUR MAGORROS TIMCI"
    };

    @SubscribeEvent
    public static void onMobDrop(LivingDropsEvent event) {

        DamageSource source = event.getSource();
        if(source instanceof EntityDamageSource) {

            if(((EntityDamageSource)source).getTrueSource() instanceof EntityPlayer) {

                if(random.nextInt(2) == 0) {

                    ItemStack stack = new ItemStack(ItemInit.ANCIENT_TABLET);
                    System.out.println("loot!");
                    NBTTagCompound compound = new NBTTagCompound();
                    compound.setString("inscription", INSCRIPTIONS[random.nextInt(3)]);
                    compound.setBoolean("revealed", false);
                    stack.setTagCompound(compound);
                    event.getEntity().entityDropItem(stack, 1+random.nextInt(2));

                }

            }

        }


    }

}
