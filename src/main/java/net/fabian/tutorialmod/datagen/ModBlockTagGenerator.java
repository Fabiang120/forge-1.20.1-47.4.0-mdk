package net.fabian.tutorialmod.datagen;

import net.fabian.tutorialmod.TutorialMod;
import net.fabian.tutorialmod.block.ModBlocks;
import net.fabian.tutorialmod.util.ModTags;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
            .addTag(Tags.Blocks.ORES);
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(ModBlocks.ketocononite_block.get())
            .add(ModBlocks.raw_ketocononite_ore.get())
            .add(ModBlocks.slimitite_block.get())
            .add(ModBlocks.raw_slimitite_ore.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE)
            .add(ModBlocks.CHARCOAL_WOOD.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .add(ModBlocks.ketocononite_block.get())
            .add(ModBlocks.raw_ketocononite_ore.get())
            .add(ModBlocks.slimitite_block.get())
            .add(ModBlocks.raw_slimitite_ore.get());

    }
}
