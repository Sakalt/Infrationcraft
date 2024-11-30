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
    public static final RegistryObject<Block> HYDRISTONE = Registration.BLOCKS.register("hydristone",
            () -> new Block(Block.Properties.of(Material.STONE)
                    .strength(1.5F, 9.0F))); // 石の硬さと爆発耐性

    // Hydrigrassブロック
    public static final RegistryObject<Block> HYDRIGRASS = Registration.BLOCKS.register("hydrigrass",
            () -> new Block(Block.Properties.of(Material.GRASS)
                    .strength(1.5F) // 草の硬さ
                    .sound(Blocks.GRASS_BLOCK.defaultBlockState().getSoundType())));

    // アイテム化（ブロックアイテム登録）
    public static final RegistryObject<Item> HYDRISTONE_ITEM = Registration.ITEMS.register("hydristone",
            () -> new BlockItem(HYDRISTONE.get(), new Item.Properties().tab(InflationCraft.TAB)));

    public static final RegistryObject<Item> HYDRIGRASS_ITEM = Registration.ITEMS.register("hydrigrass",
            () -> new BlockItem(HYDRIGRASS.get(), new Item.Properties().tab(InflationCraft.TAB)));

    public static void register() {
        Registration.BLOCKS.register();
        Registration.ITEMS.register();
    }
}
