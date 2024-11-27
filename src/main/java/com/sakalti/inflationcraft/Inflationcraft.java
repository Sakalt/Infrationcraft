package com.sakalti.inflationcraft;

import com.mojang.logging.LogUtils;
import com.sakalti.inflationcraft.registry.MechaniumPeriodRegister;
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
        modEventBus.addListener(this::onServerStart);
        MechaniumPeriodRegister.onRegisterItems(modEventBus); // アイテムの登録
    }

    private void onServerStart(ServerStartingEvent event) {
        LogUtils.getLogger().info("Hello from server start!");
    }
}
