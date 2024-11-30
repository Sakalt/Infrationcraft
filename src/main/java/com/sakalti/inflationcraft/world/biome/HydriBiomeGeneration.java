package com.sakalti.inflationcraft.world.biome;

import com.sakalti.inflationcraft.InflationCraft;
import com.sakalti.inflationcraft.registry.HydriRegister;
import com.sakalti.inflationcraft.world.dimension.HydriDimension;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InflationCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HydriBiomeGeneration {

    @SubscribeEvent
    public static void onBiomeLoading(BiomeLoadingEvent event) {
        // Hydriディメンションにのみ水素の丘を生成
        if (event.getCategory() == Biome.BiomeCategory.NONE) {
            // "Hydri"ディメンションにおいてのみ「水素の丘」が生成される
            if (event.getLevel().dimension() == HydriDimension.HYDRI.get()) {
                if (event.getName().getPath().equals("hydrogen_hill")) {
                    // 水素の丘の草などを追加
                    event.getGeneration().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, HydriRegister.HYDRI_GRASS.get());
                }
            }
        }
    }
}
