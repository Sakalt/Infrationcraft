package com.sakalti.inflationcraft.item;

import com.sakalti.inflationcraft.InflationCraft;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fml.RegistryObject;

public class EnhancedNetheriteArmor {

    // 防具の素材定義
    public static final IArmorMaterial ENHANCED_NETHERITE = new IArmorMaterial() {
        private final int[] DURABILITY = new int[]{664, 892, 765, 701};
        private final int[] PROTECTION = new int[]{5, 8, 8, 4};

        @Override
        public int getDurabilityForSlot(EquipmentSlotType slot) {
            return DURABILITY[slot.getIndex()];
        }

        @Override
        public int getDefenseForSlot(EquipmentSlotType slot) {
            return PROTECTION[slot.getIndex()];
        }

        @Override
        public int getEnchantmentValue() {
            return 15;
        }

        @Override
        public net.minecraft.util.SoundEvent getEquipSound() {
            return SoundEvents.ARMOR_EQUIP_NETHERITE;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(net.minecraft.item.Items.NETHERITE_INGOT);
        }

        @Override
        public String getName() {
            return InflationCraft.MODID + ":enhanced_netherite";
        }

        @Override
        public float getToughness() {
            return 3.0F;
        }

        @Override
        public float getKnockbackResistance() {
            return 0.2F;
        }
    };

    // ヘルメット
    public static final RegistryObject<Item> ENHANCED_NETHERITE_HELMET = Registration.ITEMS.register("enhanced_netherite_helmet",
            () -> new ArmorItem(ENHANCED_NETHERITE, EquipmentSlotType.HEAD, new Item.Properties().tab(InflationCraft.TAB).fireResistant()));

    // チェストプレート
    public static final RegistryObject<Item> ENHANCED_NETHERITE_CHESTPLATE = Registration.ITEMS.register("enhanced_netherite_chestplate",
            () -> new ArmorItem(ENHANCED_NETHERITE, EquipmentSlotType.CHEST, new Item.Properties().tab(InflationCraft.TAB).fireResistant()));

    // レギンス
    public static final RegistryObject<Item> ENHANCED_NETHERITE_LEGGINGS = Registration.ITEMS.register("enhanced_netherite_leggings",
            () -> new ArmorItem(ENHANCED_NETHERITE, EquipmentSlotType.LEGS, new Item.Properties().tab(InflationCraft.TAB).fireResistant()));

    // ブーツ
    public static final RegistryObject<Item> ENHANCED_NETHERITE_BOOTS = Registration.ITEMS.register("enhanced_netherite_boots",
            () -> new ArmorItem(ENHANCED_NETHERITE, EquipmentSlotType.FEET, new Item.Properties().tab(InflationCraft.TAB).fireResistant()));
}
