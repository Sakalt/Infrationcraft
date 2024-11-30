package com.sakalti.inflationcraft.registry;

import com.sakalti.inflationcraft.InflationCraft;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class HydriRegister {

    // Hydristoneブロック
    public static final RegistryObject<Block> HYDRI_STONE = Registration.BLOCKS.register("hydri_stone",
            () -> new Block(Block.Properties.of(Material.STONE)
                    .strength(1.5F, 9.0F))); // 石の硬さと爆発耐性

    // Hydrigrassブロック
    public static final RegistryObject<Block> HYDRI_GRASS = Registration.BLOCKS.register("hydri_grass",
            () -> new Block(Block.Properties.of(Material.GRASS)
                    .strength(1.5F) // 草の硬さ
                    .sound(Blocks.GRASS_BLOCK.defaultBlockState().getSoundType())));

    // アイテム化（ブロックアイテム登録）
    public static final RegistryObject<Item> HYDRI_STONE_ITEM = Registration.ITEMS.register("hydri_stone",
            () -> new BlockItem(HYDRI_STONE.get(), new Item.Properties().tab(InflationCraft.TAB)));

    public static final RegistryObject<Item> HYDRI_GRASS_ITEM = Registration.ITEMS.register("hydri_grass",
            () -> new BlockItem(HYDRI_GRASS.get(), new Item.Properties().tab(InflationCraft.TAB)));

    public static void register() {
        Registration.BLOCKS.register();
        Registration.ITEMS.register();
    }
}
