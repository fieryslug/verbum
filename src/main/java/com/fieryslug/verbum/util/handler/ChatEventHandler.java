package com.fieryslug.verbum.util.handler;

import com.fieryslug.verbum.init.BlockInit;
import com.fieryslug.verbum.init.ItemInit;
import com.fieryslug.verbum.object.block.BlockBricks;
import com.fieryslug.verbum.util.InGameUtils;
import net.minecraft.block.BlockAnvil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.fml.common.WorldAccessContainer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ChatEventHandler {


    private static Random random = new Random();

    @SubscribeEvent
    public static void onChat(ServerChatEvent event) {

        String message = event.getMessage();
        EntityPlayer player = event.getPlayer();
        World world = player.world;



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

                InGameUtils.placeBlock(world, Blocks.ANVIL.getDefaultState(), player.getPosition());

            }


            if(message.equals("squid")) {

                InGameUtils.sendEntity(player, new EntitySquid(world), 5.0);

            }

            if(message.equals("fireball")) {

                Entity entityFireBall = new EntityFireball(world) {
                    @Override
                    protected void onImpact(RayTraceResult result) {


                        if(world.getBlockState(this.getPosition()).getBlock() != Blocks.AIR || result.typeOfHit == RayTraceResult.Type.ENTITY) {
                            world.createExplosion(this, this.posX, this.posY, this.posZ, 3.0F, true);
                            world.removeEntity(this);
                        }
                    }
                };

                InGameUtils.sendEntity(player, entityFireBall, 2);

            }

            if(message.equals("big fireball")) {

                Entity entityFireBall = new EntityLargeFireball(world);
                InGameUtils.sendEntity(player, entityFireBall, 0.2);


            }

            if(message.equals("pig")) {

                Entity entityPig = new EntityPig(world);
                InGameUtils.sendEntity(player, entityPig, 1.5F);

            }

            if(message.equals("launch")) {

                InGameUtils.propellPlayer(player, 10);

            }

        }


    }


}
