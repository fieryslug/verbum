package com.fieryslug.verbum.util.handler;

import com.fieryslug.verbum.init.ItemInit;
import com.fieryslug.verbum.util.InGameUtils;
import net.minecraft.block.BlockAnvil;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.fml.common.WorldAccessContainer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Timer;
import java.util.TimerTask;

public class ChatEventHandler {

    @SubscribeEvent
    public static void onChat(ServerChatEvent event) {

        String message = event.getMessage();
        EntityPlayer player = event.getPlayer();
        World world = player.world;

        event.setCanceled(true);

        if(!world.isRemote) {

            if(message.equals("hello")) {

                InGameUtils.sendMessage(player, "hi there", 100);

            }

            if(message.equals("ingot")) {

                System.out.println("ingot!!");
                InGameUtils.giveItem(player, ItemInit.INGOT_MAGIC_STEEL, 3);
                //CommandUtil.giveStack(new ItemStack(ItemInit.INGOT_MAGIC_STEEL, 6), 0);
            }

            if(message.equals("anvil")) {


                InGameUtils.placeBlock(world, Blocks.ANVIL.getDefaultState().withProperty(BlockAnvil.DAMAGE, 2), new BlockPos(player.posX, player.posY+6, player.posZ));

            }

            if(message.equals("anvil 0")) {

                InGameUtils.placeBlock(world, Blocks.ANVIL.getDefaultState(), new BlockPos(player.posX, player.posY+6, player.posZ));

            }

            if(message.equals("squid")) {

                InGameUtils.spawnEntity(world, new EntitySquid(world), player.posX, player.posY, player.posZ);

            }

        }


    }


}
