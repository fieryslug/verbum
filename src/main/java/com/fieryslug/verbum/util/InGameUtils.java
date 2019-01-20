package com.fieryslug.verbum.util;


import com.fieryslug.verbum.Reference;
import net.darkhax.bookshelf.item.ItemSubType;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentBase;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.Timer;
import java.util.TimerTask;

public class InGameUtils {

    public static void spawnEntity(World world, Entity entity, double x, double y, double z) {

        entity.setPositionAndUpdate(x, y, z);
        world.spawnEntity(entity);

    }

    public static void spawnEntity(World world, Entity entity) {

        world.spawnEntity(entity);

    }

    public static void placeBlock(World world, IBlockState state, BlockPos blockPos) {

        if(world.mayPlace(state.getBlock(), blockPos, false, EnumFacing.DOWN, null)) {

            world.setBlockState(blockPos, state);
        }

    }

    public static void giveItem(EntityPlayer player, Item item, int count) {

        giveItem(player, new ItemStack(item, count));

    }

    public static void giveItem(EntityPlayer player, ItemStack stack) {

        spawnEntity(player.world, new EntityItem(player.world, player.posX, player.posY, player.posZ, stack));

    }

    public static void sendMessage(EntityPlayer player, String message, long delay) {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ITextComponent component = new TextComponentString(message);
                component.setStyle(Reference.STYLE1);
                player.sendStatusMessage(component, true);
            }
        }, delay);

    }

    public static void sendEntity(EntityPlayer player, Entity entity, double speed) {

        World world = player.world;
        Vec3d vel = player.getLookVec();
        double x = player.posX + vel.x;
        double y = player.posY + vel.y;
        double z = player.posZ + vel.z;

        entity.setPositionAndUpdate(x, y, z);
        entity.setVelocity(vel.x * speed, vel.y * speed, vel.z * speed);
        world.spawnEntity(entity);

    }

    public static void propellPlayer(EntityPlayer player, double speed) {

        Vec3d dir = player.getLookVec();
        player.addVelocity(dir.x * speed, dir.y * speed, dir.z * speed);
    }


}
