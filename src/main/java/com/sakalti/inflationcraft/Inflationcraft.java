package com.sakalti.inflationcraft;

import com.mojang.logging.LogUtils;
import com.sakalti.inflationcraft.registry.MechaniumPeriodRegister;
import com.sakalti.inflationcraft.registry.NetherRegistry;
import com.sakalti.inflationcraft.registry.HydriRegistry;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.ModEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(InflationCraft.MODID)
public class InflationCraft {
    public static final String MODID = "inflationcraft";

    public InflationCraft() {
        IEventBus modEventBus = MinecraftForge.EVENT_BUS;
        
        // 各レジストリの登録
        modEventBus.addListener(this::onServerStart);
        
        // アイテムやエンティティの登録
        MechaniumPeriodRegister.onRegisterItems(modEventBus); // アイテムの登録
        NetherRegistry.register(); // Nether関連のエンティティやアイテムを登録
        HydriRegistry.register(); // Hydri関連のエンティティやアイテムを登録
    }

    private void onServerStart(ServerStartingEvent event) {
        LogUtils.getLogger().info("Hello from server start!");
    }
}
