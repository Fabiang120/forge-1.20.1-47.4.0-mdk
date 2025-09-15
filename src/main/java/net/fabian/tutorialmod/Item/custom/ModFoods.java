package net.fabian.tutorialmod.Item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static FoodProperties TREX_MEAT = new FoodProperties.Builder().nutrition(2)
        .saturationMod(0.2f).effect(()->new MobEffectInstance(MobEffects.MOVEMENT_SPEED,200), 0.1f).build();
}
