package com.sakalti.inflationcraft.items;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;

public class MechaniumToolMaterial implements IItemTier {
    @Override
    public int getMaxUses() {
        return 2048; // 耐久性
    }

    @Override
    public float getEfficiency() {
        return 8.0F; // 掘削速度
    }

    @Override
    public float getAttackDamage() {
        return 12.5F; // 攻撃力
    }

    @Override
    public int getHarvestLevel() {
        return 3; // 鉱石の採掘レベル
    }

    @Override
    public int getEnchantability() {
        return 15; // エンチャント性
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(Items.DIAMOND); // 修理アイテム
    }
}
