package com.sakalti.inflationcraft.items;

import net.minecraft.item.SwordItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;

public class MechaniumSword extends SwordItem {
    public MechaniumSword(IItemTier tier) {
        super(tier, 3, -2.4F, new Item.Properties().group(ItemGroup.COMBAT));
    }
}
