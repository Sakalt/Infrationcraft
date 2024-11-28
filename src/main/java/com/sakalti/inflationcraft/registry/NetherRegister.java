package com.sakalti.inflationcraft.registry;

import com.sakalti.inflationcraft.InflationCraft;
import com.sakalti.inflationcraft.entity.InferneEntity;
import com.sakalti.inflationcraft.entity.BlueInferneEntity;
import com.sakalti.inflationcraft.item.SoulBlade;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InflationCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NetherRegistry {

    // Inferneの登録
    public static final RegistryObject<EntityType<InferneEntity>> INFERNE = Registration.ENTITIES.register("inferne",
            () -> EntityType.Builder.of(InferneEntity::new, EntityClassification.MONSTER)
                    .sized(0.6F, 1.95F) // プレイヤーサイズ
                    .build(new ResourceLocation(InflationCraft.MODID, "inferne").toString()));

    // Inferneのスポーンエッグ
    public static final RegistryObject<Item> INFERNE_SPAWN_EGG = Registration.ITEMS.register("inferne_spawn_egg",
            () -> new SpawnEggItem(INFERNE.get(), 0xFF4500, 0x550000, new Item.Properties().tab(InflationCraft.TAB)));

    // BlueInferneの登録
    public static final RegistryObject<EntityType<BlueInferneEntity>> BLUE_INFERNE = Registration.ENTITIES.register("blue_inferne",
            () -> EntityType.Builder.of(BlueInferneEntity::new, EntityClassification.MONSTER)
                    .sized(0.6F, 1.95F) // プレイヤーサイズ
                    .build(new ResourceLocation(InflationCraft.MODID, "blue_inferne").toString()));

    // BlueInferneのスポーンエッグ
    public static final RegistryObject<Item> BLUE_INFERNE_SPAWN_EGG = Registration.ITEMS.register("blue_inferne_spawn_egg",
            () -> new SpawnEggItem(BLUE_INFERNE.get(), 0x5D8AA8, 0x00008B, new Item.Properties().tab(InflationCraft.TAB)));

    // ソウルブレードの登録
    public static final RegistryObject<Item> SOUL_BLADE = Registration.ITEMS.register("soul_blade",
            () -> new SoulBlade());

    public static void register() {
        Registration.ENTITIES.register();
        Registration.ITEMS.register();
        MinecraftForge.EVENT_BUS.addListener(NetherRegistry::onBiomeLoad);
    }

    // 属性登録
    @SubscribeEvent
    public static void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(INFERNE.get(), InferneEntity.createAttributes().build());
        event.put(BLUE_INFERNE.get(), BlueInferneEntity.createAttributes().build());
    }

    // ネザーでのスポーン設定
    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        if (event.getCategory() == Biome.BiomeCategory.NETHER) {
            // Inferneのスポーン設定
            event.getSpawns().addSpawn(EntityClassification.MONSTER,
                    new MobSpawnSettings.SpawnerData(INFERNE.get(), 10, 1, 3));

            // BlueInferneのスポーン設定 (ソウルサンドバレー限定)
            if (event.getName() != null && event.getName().getPath().contains("soul_sand_valley")) {
                event.getSpawns().addSpawn(EntityClassification.MONSTER,
                        new MobSpawnSettings.SpawnerData(BLUE_INFERNE.get(), 8, 1, 2));
            }
        }
    }
}
