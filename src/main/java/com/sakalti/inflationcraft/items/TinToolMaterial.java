package com.sakalti.inflationcraft.items;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;

public class MechaniumToolMaterial implements IItemTier {
    @Override
    public int getMaxUses() {
        return 2100; // 耐久性
    }

    @Override
    public float getEfficiency() {
        return 10.0F; // 掘削速度
    }

    @Override
    public float getAttackDamage() {
        return 48.0F; // 攻撃力
    }

    @Override
    public int getHarvestLevel() {
        return 4; // 鉱石の採掘レベル
    }

    @Override
    public int getEnchantability() {
        return 8; // エンチャント性
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(Items.DIAMOND); // 修理アイテム
    }
}
