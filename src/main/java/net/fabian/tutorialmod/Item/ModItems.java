package net.fabian.tutorialmod.Item;

import net.fabian.tutorialmod.Item.custom.MetalDetectorItem;
import net.fabian.tutorialmod.TutorialMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> ketocononite_ingot = ITEMS.register("ketocononite_ingot",
        () ->new Item(new Item.Properties()));

    public static final RegistryObject<Item> slimitite_ingot = ITEMS.register("slimitite_ingot",
        () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> raw_ketocononite = ITEMS.register("raw_ketocononite",
        () ->new Item(new Item.Properties()));

    public static final RegistryObject<Item> raw_slimitite = ITEMS.register("raw_slimitite",
        () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
        () -> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

