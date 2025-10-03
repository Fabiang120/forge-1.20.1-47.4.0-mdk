package net.fabian.tutorialmod.datagen;

import net.fabian.tutorialmod.Item.ModItems;
import net.fabian.tutorialmod.TutorialMod;
import net.fabian.tutorialmod.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> Ketocononite_Smeltables = List.of(ModItems.raw_ketocononite.get());
    private static final List<ItemLike> Slimitite_Smeltables = List.of(ModItems.raw_slimitite.get());


    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }


    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, Ketocononite_Smeltables, RecipeCategory.MISC, ModItems.ketocononite_ingot.get(), 0.25f, 100, "ketocononite");
        oreSmelting(pWriter, Ketocononite_Smeltables, RecipeCategory.MISC, ModItems.ketocononite_ingot.get(), 0.25f, 100, "ketocononite");
        oreBlasting(pWriter, Slimitite_Smeltables, RecipeCategory.MISC, ModItems.slimitite_ingot.get(), 0.25f, 100, "slimitite");
        oreSmelting(pWriter, Slimitite_Smeltables, RecipeCategory.MISC, ModItems.slimitite_ingot.get(), 0.25f, 100, "slimitite");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ketocononite_block.get())
            .pattern("SSS")
            .pattern("SSS")
            .pattern("SSS")
            .define('S', ModItems.ketocononite_ingot.get())
            .unlockedBy("has_ketocononite", has(ModItems.ketocononite_ingot.get()))
            .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ketocononite_ingot.get(),
            9)
            .requires(ModBlocks.ketocononite_block.get())
            .unlockedBy(getHasName(ModBlocks.ketocononite_block.get()), has(ModBlocks.ketocononite_block.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.slimitite_block.get())
            .pattern("SSS")
            .pattern("SSS")
            .pattern("SSS")
            .define('S', ModItems.slimitite_ingot.get())
            .unlockedBy("has_slimitite", has(ModItems.slimitite_ingot.get()))
            .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.slimitite_ingot.get(),
                9)
            .requires(ModBlocks.slimitite_block.get())
            .unlockedBy(getHasName(ModBlocks.slimitite_block.get()), has(ModBlocks.slimitite_block.get()))
            .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                pExperience, pCookingTime, pCookingSerializer)
                .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                .save(pFinishedRecipeConsumer, TutorialMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
