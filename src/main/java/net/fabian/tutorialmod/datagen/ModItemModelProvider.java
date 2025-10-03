package net.fabian.tutorialmod.datagen;

import net.fabian.tutorialmod.Item.ModItems;
import net.fabian.tutorialmod.TutorialMod;
import net.fabian.tutorialmod.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TutorialMod.MOD_ID,existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.raw_ketocononite);
        simpleItem(ModItems.raw_slimitite);
        simpleItem(ModItems.TREX_MEAT);
        simpleItem(ModItems.slimitite_ingot);
        simpleItem(ModItems.ketocononite_ingot);
        simpleBlockItem(ModBlocks.KETOCONONITE_STAIRS);
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
            new ResourceLocation("item/generated"))
            .texture("layer0",
            new ResourceLocation(TutorialMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> block) {
        return withExistingParent(block.getId().getPath(),
            new ResourceLocation(TutorialMod.MOD_ID, "block/" + block.getId().getPath()));
    }


}
