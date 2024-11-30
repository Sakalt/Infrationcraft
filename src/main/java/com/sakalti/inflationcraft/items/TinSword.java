package com.sakalti.inflationcraft.items;

import net.minecraft.item.SwordItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;

public class TinSword extends SwordItem {
    public TinSword(IItemTier tier) {
        super(tier, 4, -2.4F, new Item.Properties().group(ItemGroup.COMBAT));
    }
}
