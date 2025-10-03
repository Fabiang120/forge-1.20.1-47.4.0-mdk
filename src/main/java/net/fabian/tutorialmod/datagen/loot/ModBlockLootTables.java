package net.fabian.tutorialmod.datagen.loot;

import net.fabian.tutorialmod.Item.ModItems;
import net.fabian.tutorialmod.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        this.dropSelf(ModBlocks.ketocononite_block.get());
        this.dropSelf(ModBlocks.slimitite_block.get());
        this.dropSelf(ModBlocks.raw_slimitite_ore.get());
        this.dropSelf(ModBlocks.raw_ketocononite_ore.get());
        this.dropSelf(ModBlocks.CHARCOAL_WOOD.get());
        this.dropSelf(ModBlocks.jungle_glow_block.get());
        this.dropSelf(ModBlocks.KETOCONONITE_STAIRS.get());
        this.add(ModBlocks.raw_ketocononite_ore.get(),
            block->createOreDrop(ModBlocks.raw_ketocononite_ore.get(), ModItems.raw_ketocononite.get()));
        this.add(ModBlocks.raw_slimitite_ore.get(),
            block->createOreDrop(ModBlocks.raw_slimitite_ore.get(), ModItems.raw_slimitite.get()));

    }

    @Override
    public Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
