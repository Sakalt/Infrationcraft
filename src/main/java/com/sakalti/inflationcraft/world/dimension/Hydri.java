package com.sakalti.inflationcraft.world.dimension;

import com.sakalti.inflationcraft.InflationCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.dimension.Dimension;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.ModEventBus;
import net.minecraftforge.registries.RegistryObject;

public class HydriDimension {
    
    public static final RegistryObject<DimensionType> HYDRI = DIMENSIONS.register("hydri", 
        () -> DimensionType.create(new ResourceLocation(InflationCraft.MODID, "hydri"), 
        true, true, true));

    // 登録処理
    public static void register(IEventBus eventBus) {
        DIMENSIONS.register(eventBus);
    }
}
