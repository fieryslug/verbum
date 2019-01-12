package com.fieryslug.verbum.integration;


import com.fieryslug.verbum.init.ItemInit;
import com.fieryslug.verbum.object.item.ItemBase;
import mezz.jei.api.*;
import mezz.jei.api.ingredients.IIngredientBlacklist;
import mezz.jei.api.ingredients.IIngredientHelper;
import mezz.jei.api.ingredients.IModIngredientRegistration;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IIngredientType;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.lwjgl.Sys;

import java.util.Collections;

@JEIPlugin
public class VerbumJEIPlugin implements IModPlugin {


    @Override
    public void registerItemSubtypes(ISubtypeRegistry subtypeRegistry) {



    }

    @Override
    public void registerIngredients(IModIngredientRegistration registry) {

        //registry.register(VanillaTypes.ITEM, Collections.singleton(new ItemStack(ItemInit.INGOT_MAGIC_STEEL)), , null);
        //IIngredientHelper

    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {



    }

    @Override
    public void register(IModRegistry registry) {

        IIngredientBlacklist blacklist = registry.getJeiHelpers().getIngredientBlacklist();
        blacklist.addIngredientToBlacklist(ItemInit.INGOT_MAGIC_STEEL);
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {

    }
}
