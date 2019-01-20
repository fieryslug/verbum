package com.fieryslug.verbum.object.block;

import cofh.CoFHCore;
import cofh.core.util.helpers.RedstoneControlHelper;
import cofh.redstoneflux.RedstoneFlux;
import com.fieryslug.verbum.VerbumMod;
import com.fieryslug.verbum.init.BlockInit;
import com.fieryslug.verbum.init.ItemInit;
import com.fieryslug.verbum.object.item.block.ItemBlockBricks;
import com.fieryslug.verbum.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import scala.Array;
import scala.actors.threadpool.Arrays;
import slimeknights.tconstruct.library.tinkering.TinkersItem;

import javax.xml.bind.annotation.XmlType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockBricks extends Block implements IHasModel {

    public static final PropertyEnum<EnumBricksType> VARIANT = PropertyEnum.create("variant", EnumBricksType.class);
    private Item itemBricks;
    private List<String> names;

    public BlockBricks(String name, Material material, float hardness, float resistance, String[] names) {

        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(hardness);
        setResistance(resistance);
        setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumBricksType.CARVED));
        setCreativeTab(VerbumMod.TAB_VERBUM);

        this.names = Arrays.asList(names);

        this.itemBricks = new ItemBlockBricks(this, name, (String[])this.names.toArray());
        BlockInit.BLOCKS.add(this);
        Item itemBlock = new ItemBlock(this).setRegistryName(this.getRegistryName());
        ItemInit.ITEMS.add(this.itemBricks);

    }

    public BlockBricks setSubNames(String... names) {

        this.names = Arrays.asList(names);
        return this;

    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        return this.getDefaultState().withProperty(VARIANT, EnumBricksType.byMeta(meta));
    }

    @Override
    public int damageDropped(IBlockState state) {
        return EnumBricksType.byType(state.getValue(VARIANT));
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        /*
        items.add(new ItemStack(this, 1, 0));
        items.add(new ItemStack(this, 1, 2));
        items.add(new ItemStack(this, 1, 3));
        items.add(new ItemStack(this, 1, 4));
        */
        for(int i=0; i<this.names.size(); ++i) {
            if(i != 1)
                items.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public void registerModels() {

        /*
        VerbumMod.proxy.registerModel(this.itemBricks, 0, "inventory", "bricks_basalt");
        VerbumMod.proxy.registerModel(this.itemBricks, 2, "inventory", "bricks_basalt_cracked");
        VerbumMod.proxy.registerModel(this.itemBricks, 3, "inventory", "bricks_basalt_carved");
        VerbumMod.proxy.registerModel(this.itemBricks, 4, "inventory", "bricks_basalt_polished");
        */
        for(int i=0; i<this.names.size(); ++i) {
            if(i != 1)
                VerbumMod.proxy.registerModel(this.itemBricks, i, "inventory", this.names.get(i));

        }

    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, VARIANT);
    }




    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(VARIANT, EnumBricksType.byMeta(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return EnumBricksType.byType(state.getValue(VARIANT));
    }

    public static enum EnumBricksType implements IStringSerializable {

        DEFAULT(0, "default"), CRACKED(2, "cracked"), CARVED(3, "carved"), POLISHED(4, "polished"), ;

        private final int ordinal;
        private final String name;

        private EnumBricksType(int ordinal, String name) {

            this.ordinal = ordinal;
            this.name = name;

        }

        @Override
        public String getName() {
            return this.name;
        }

        public static EnumBricksType byMeta(int meta) {

            if(meta == 0) return DEFAULT;
            if(meta == 2) return CRACKED;
            if(meta == 3) return CARVED;
            if(meta == 4) return POLISHED;

            return DEFAULT;

        }

        public static int byType(EnumBricksType type) {

            return type.ordinal;

        }

    }


}
