package com.sakalti.inflationcraft.registry;

import com.sakalti.inflationcraft.InflationCraft;
import com.sakalti.inflationcraft.entity.HydrineEntity;
import com.sakalti.inflationcraft.world.dimension.HydriDimension;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.RegistryObject;

public class HydriRegister {

    // Hydrineの登録
    public static final RegistryObject<EntityType<HydrineEntity>> HYDRINE = Registration.ENTITIES.register("hydrine",
            () -> EntityType.Builder.of(HydrineEntity::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.8F) // プレイヤーサイズ
                    .build(new ResourceLocation(InflationCraft.MODID, "hydrine").toString()));

    // Hydrineのスポーンエッグ
    public static final RegistryObject<Item> HYDRINE_SPAWN_EGG = Registration.ITEMS.register("hydrine_spawn_egg",
            () -> new SpawnEggItem(HYDRINE.get(), 0x476134, 0x222636, new Item.Properties().tab(InflationCraft.TAB)));

    // Hydristoneブロック
    public static final RegistryObject<Block> HYDRI_STONE = Registration.BLOCKS.register("hydri_stone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5F, 9.0F) // 硬さと爆発耐性
                    .sound(SoundType.STONE))); // 石の音

    // Hydrigrassブロック
    public static final RegistryObject<Block> HYDRI_GRASS = Registration.BLOCKS.register("hydri_grass",
            () -> new Block(BlockBehaviour.Properties.of(Material.GRASS)
                    .strength(0.6F, 4.5F) // 草ブロックの硬さと爆発耐性
                    .sound(SoundType.GRASS))); // 草の音

    // アイテム化（ブロックアイテム登録）
    public static final RegistryObject<Item> HYDRI_STONE_ITEM = Registration.ITEMS.register("hydri_stone",
            () -> new BlockItem(HYDRI_STONE.get(), new Item.Properties().tab(InflationCraft.TAB)));

    public static final RegistryObject<Item> HYDRI_GRASS_ITEM = Registration.ITEMS.register("hydri_grass",
            () -> new BlockItem(HYDRI_GRASS.get(), new Item.Properties().tab(InflationCraft.TAB)));

    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", TinIngot::new);
    public static final RegistryObject<Item> TIN_SWORD = ITEMS.register("tin_sword", () -> new TinSword(new TinToolMaterial()));
    // Hydriディメンションとバイオームの登録
    public static void register() {
        // ディメンションとバイオームの登録
        HydriDimension.register();
        HydriBiomeRegister.register();
        // その他の登録処理
        Registration.BLOCKS.register();
        Registration.ITEMS.register();
        Registration.ENTITIES.register();
    }
}
