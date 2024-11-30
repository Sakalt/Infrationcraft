package com.sakalti.inflationcraft.world.biome;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateFeatureConfig;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import com.sakalti.inflationcraft.registry.Registration;

public class HydrogenHillsBiome {

    public static Biome createHydrogenHillsBiome() {
        // バイオームの視覚効果
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
                .fogColor(0x88E4FF)
                .waterColor(0x38A1DB)
                .waterFogColor(0x1F78B4)
                .skyColor(0x50C5FF)
                .build();

        // モブのスポーン設定
        MobSpawnSettings.Builder mobSpawns = new MobSpawnSettings.Builder();
        mobSpawns.addSpawn(EntityClassification.MONSTER,
                new MobSpawnSettings.SpawnerData(Registration.HYDRINE_ENTITY.get(), 10, 2, 4));

        // 地形の生成設定
        BiomeGenerationSettings.Builder generation = new BiomeGenerationSettings.Builder();
        
        // Hydriの地形ブロック追加 (hydri_grassとhydri_stone)
        generation.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES,
                Feature.SIMPLE_BLOCK
                        .configured(new BlockStateFeatureConfig(Registration.HYDRI_GRASS_BLOCK.get().defaultBlockState()))
                        .placed()); // HydriGrassを追加
        generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES,
                Feature.ORE
                        .configured(new BlockStateFeatureConfig(Registration.HYDRI_STONE_BLOCK.get().defaultBlockState()))
                        .placed()); // HydriStoneを追加

        return new Biome.BiomeBuilder()
                .specialEffects(effects)
                .mobSpawnSettings(mobSpawns.build())
                .generationSettings(generation.build())
                .temperature(0.8F)
                .downfall(0.2F)
                .build();
    }
}
