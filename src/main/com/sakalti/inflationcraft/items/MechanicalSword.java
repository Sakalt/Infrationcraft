package com.sakalti.inflationcraft.items;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ItemSettings;
import net.minecraft.item.ItemGroup;

public class MechaniumSword extends SwordItem {
    public MechaniumSword() {
        super(new ToolMaterial() {
            @Override
            public int getDurability() {
                return 2048; // 例として耐久力を2048に設定
            }

            @Override
            public float getMiningSpeedMultiplier() {
                return 8.0F; // 掘削速度
            }

            @Override
            public float getAttackDamage() {
                return 12.5F; // 攻撃力
            }

            @Override
            public int getMiningLevel() {
                return 3; // 鉱石の採掘レベル
            }

            @Override
            public int getEnchantability() {
                return 15; // エンチャントの最大値
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.ofItems(Items.MECHANIUM_INGOT); // メカニウムインゴットで修理
            }
        }, 3, -2.4F, new ItemSettings().group(ItemGroup.COMBAT));
    }
}
