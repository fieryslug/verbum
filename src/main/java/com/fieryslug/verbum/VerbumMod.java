package com.fieryslug.verbum;

import com.fieryslug.verbum.object.creativetab.TabVerbum;
import com.fieryslug.verbum.proxy.CommonProxy;
import com.fieryslug.verbum.util.handler.ChatEventHandler;
import com.fieryslug.verbum.util.handler.MobDropHandler;
import com.fieryslug.verbum.util.handler.RegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class VerbumMod {

    @Mod.Instance
    public static VerbumMod instance;

    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
    public static CommonProxy proxy;

    public static final CreativeTabs TAB_VERBUM = new TabVerbum();

    static {
        FluidRegistry.enableUniversalBucket();
    }

    public VerbumMod() {

        System.out.println("EVENTSUBSCRIBERREGISTRY1234");
        MinecraftForge.EVENT_BUS.register(RegistryHandler.class);
        MinecraftForge.EVENT_BUS.register(ChatEventHandler.class);
        MinecraftForge.EVENT_BUS.register(MobDropHandler.class);

    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("12345678910");
        RegistryHandler.preInitRegistry();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        RegistryHandler.initRegistry();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        RegistryHandler.postInitRegistry();
    }



}
