package net.fabian.tutorialmod.Item;

import net.fabian.tutorialmod.TutorialMod;
import net.fabian.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB,TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL = CREATIVE_MODE_TABS.register("tutorial_tab",
        ()->CreativeModeTab.builder().icon(()->new ItemStack(ModItems.ketocononite_ingot.get()))
            .title(Component.translatable("creativetab.tutorial_tab"))
            .displayItems((pParameters, pOutput)->{
                    pOutput.accept(ModItems.ketocononite_ingot.get());
                    pOutput.accept(ModItems.slimitite_ingot.get());
                    pOutput.accept(ModBlocks.ketocononite_block.get());
                    pOutput.accept(ModBlocks.slimitite_block.get());
                    pOutput.accept(ModBlocks.raw_ketocononite_ore.get());
                    pOutput.accept(ModBlocks.raw_slimitite_ore.get());
                    pOutput.accept(ModItems.raw_ketocononite.get());
                    pOutput.accept(ModItems.raw_slimitite.get());
                })
               .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
