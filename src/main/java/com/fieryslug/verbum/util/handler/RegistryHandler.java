package com.fieryslug.verbum.util.handler;

import com.fieryslug.verbum.VerbumMod;
import com.fieryslug.verbum.init.BiomeInit;
import com.fieryslug.verbum.init.BlockInit;
import com.fieryslug.verbum.init.FluidInit;
import com.fieryslug.verbum.init.ItemInit;
import com.fieryslug.verbum.util.IHasModel;
import com.fieryslug.verbum.world.gen.VerbumOreGen;
import com.fieryslug.verbum.world.gen.VerbumTreeGen;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

//@Mod.EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {

        event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));

    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {

        for(Item item : ItemInit.ITEMS) {

            if(item instanceof IHasModel) {
                ((IHasModel)item).registerModels();
            }

        }

        for(Block block : BlockInit.BLOCKS) {

            if(block instanceof IHasModel) {
                ((IHasModel)block).registerModels();
            }
        }



    }

    public static void preInitRegistry() {

        FluidInit.registerFluids();

        GameRegistry.registerWorldGenerator(new VerbumOreGen(), 0);
        GameRegistry.registerWorldGenerator(new VerbumTreeGen(), 0);

        BiomeInit.registerBiomes();

        RenderHandler.registerCustomMeshesAndStates();




    }

    public static void initRegistry() {

        NetworkRegistry.INSTANCE.registerGuiHandler(VerbumMod.instance, new GuiHandler());
        OreDictionary.registerOre("basalt", BlockInit.BASALT);
        OreDictionary.registerOre("plankWood", BlockInit.PLANK_CECROPIA);
    }

    public static void postInitRegistry() {



    }
}
