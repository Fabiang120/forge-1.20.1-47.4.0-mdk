package net.fabian.tutorialmod.block;
import net.fabian.tutorialmod.Item.ModItems;
import net.fabian.tutorialmod.TutorialMod;
import net.fabian.tutorialmod.block.custom.JungleGlowBlock;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS
        = DeferredRegister.create(ForgeRegistries.BLOCKS,TutorialMod.MOD_ID);

    public static final RegistryObject<Block> raw_slimitite_ore =
        registerBlock("raw_slimitite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of()
                .strength(4f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK), UniformInt.of(2, 4)));

    public static final RegistryObject<Block> slimitite_block = registerBlock("slimitite_block",
        ()->new Block(BlockBehaviour.Properties.of()
            .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> ketocononite_block =registerBlock("ketocononite_block",
        () ->new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> jungle_glow_block =registerBlock("jungle_glow_block",
        () ->new JungleGlowBlock(BlockBehaviour.Properties.copy(Blocks.GLOW_LICHEN)));

    public static final RegistryObject<Block> raw_ketocononite_ore =
        registerBlock("raw_ketocononite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of()
                            .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST), UniformInt.of(2, 4)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T>block) {
        ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
