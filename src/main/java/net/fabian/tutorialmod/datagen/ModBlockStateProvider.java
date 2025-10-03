package net.fabian.tutorialmod.datagen;

import net.fabian.tutorialmod.TutorialMod;
import net.fabian.tutorialmod.block.ModBlocks;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TutorialMod.MOD_ID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ketocononite_block);
        blockWithItem(ModBlocks.slimitite_block);
        blockWithItem(ModBlocks.raw_ketocononite_ore);
        blockWithItem(ModBlocks.raw_slimitite_ore);
        stairsBlock(((StairBlock)ModBlocks.KETOCONONITE_STAIRS.get()),blockTexture(ModBlocks.ketocononite_block.get()));
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
