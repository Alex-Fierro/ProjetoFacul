package net.grupo.criasmod.entities.events;

import net.grupo.criasmod.CriasMod;
import net.grupo.criasmod.entities.Veiculo;
import net.grupo.criasmod.entities.uno.FiatUno;
import net.grupo.criasmod.util.KeyBindings;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = CriasMod.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {


        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            Player player = Minecraft.getInstance().player;


            var minecraft = Minecraft.getInstance();
            if(KeyBindings.TRANSFORM_KEY.consumeClick() && player.isPassenger()) {
                if(player.getVehicle() instanceof FiatUno) {
                    Entity montaria = player.getVehicle();
                    if(montaria instanceof FiatUno) {
                        FiatUno fiatUno = (FiatUno) montaria;
                        if(fiatUno.getTransformado() == true) {
                            //Minecraft.getInstance().player.sendSystemMessage(Component.literal("NORMAL"));
                            fiatUno.setTransformado(false);
                        } else {
                            //Minecraft.getInstance().player.sendSystemMessage(Component.literal("OFFROAD"));
                            fiatUno.setTransformado(true);
                        }
                    }
                }
            }
        }





        @Mod.EventBusSubscriber(modid = CriasMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
        public static class ClientModBusEvents {
            @SubscribeEvent
            public static void onKeyRegister(RegisterKeyMappingsEvent event) {
                event.register(KeyBindings.TRANSFORM_KEY);
            }

        }
    }
}
