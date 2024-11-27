package com.sakalti.inflationcraft.registry;

import com.sakalti.inflationcraft.items.MechaniumIngot;
import com.sakalti.inflationcraft.items.MechaniumSword;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.sakalti.inflationcraft.InflationCraft.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MechaniumPeriodRegister {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> MECHANIUM_INGOT = ITEMS.register("mechanium_ingot", MechaniumIngot::new);
    public static final RegistryObject<Item> MECHANIUM_SWORD = ITEMS.register("mechanium_sword", () -> new MechaniumSword(new MechaniumToolMaterial()));

    @SubscribeEvent
    public static void onRegisterItems(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
