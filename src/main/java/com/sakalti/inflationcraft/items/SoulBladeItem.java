package com.sakalti.inflationcraft.item;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;

public class SoulBlade extends SwordItem {

    public SoulBlade() {
        super(new IItemTier() {
            @Override
            public int getUses() {
                return 2000; // 耐久値
            }

            @Override
            public float getSpeed() {
                return 1.8f; // 攻撃速度
            }

            @Override
            public float getAttackDamageBonus() {
                return 17.6f; // 攻撃力
            }

            @Override
            public int getLevel() {
                return 4; // ツールのレベル（ダイヤ以上）
            }

            @Override
            public int getEnchantmentValue() {
                return 13; // エンチャントの付与確率
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(Registration.SOUL_SAND.get()); // 修理材料（ソウルサンド）
            }
        }, 3, -2.4f, new Item.Properties().tab(InflationCraft.TAB).durability(2000).addToolType(ToolType.SWORD, 3));
    }
}
