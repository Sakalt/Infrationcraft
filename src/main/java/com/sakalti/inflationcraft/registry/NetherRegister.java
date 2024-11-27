package com.sakalti.inflationcraft.registry;

import com.sakalti.inflationcraft.InflationCraft;
import com.sakalti.inflationcraft.entity.InferneEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InflationCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NetherRegistry {

    // エンティティ登録
    public static final RegistryObject<EntityType<InferneEntity>> INFERNE = Registration.ENTITIES.register("inferne",
            () -> EntityType.Builder.of(InferneEntity::new, EntityClassification.MONSTER)
                    .sized(0.6F, 1.95F) // プレイヤーサイズ
                    .build(new ResourceLocation(InflationCraft.MODID, "inferne").toString()));

    // スポーンエッグの登録
    public static final RegistryObject<Item> INFERNE_SPAWN_EGG = Registration.ITEMS.register("inferne_spawn_egg",
            () -> new SpawnEggItem(INFERNE.get(), 0xFF4500, 0x550000, new Item.Properties().tab(InflationCraft.TAB)));

    public static void register() {
        Registration.ENTITIES.register();
        Registration.ITEMS.register();
        MinecraftForge.EVENT_BUS.addListener(NetherRegistry::onBiomeLoad);
    }

    // 属性登録
    @SubscribeEvent
    public static void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(INFERNE.get(), InferneEntity.createAttributes().build());
    }

    // ネザーでのスポーン設定
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        if (event.getCategory() == Biome.BiomeCategory.NETHER) {
            event.getSpawns().addSpawn(EntityClassification.MONSTER,
                    new MobSpawnSettings.SpawnerData(INFERNE.get(), 10, 1, 3)); // スポーン設定
        }
    }
}
