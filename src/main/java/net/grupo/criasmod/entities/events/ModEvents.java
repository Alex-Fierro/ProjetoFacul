package net.grupo.criasmod.entities.events;

import net.grupo.criasmod.CriasMod;
import net.grupo.criasmod.entities.ModEntities;
import net.grupo.criasmod.entities.aranha.Aranha;
import net.grupo.criasmod.entities.fiatunovermelho.FiatUnoVermelho;
import net.grupo.criasmod.entities.golem.Golem;
import net.grupo.criasmod.entities.spirittree.SpiritCuteTreeEntity;
import net.grupo.criasmod.entities.t_rex.T_Rex_Entity;
import net.grupo.criasmod.entities.uno.FiatUno;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CriasMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {

    @Mod.EventBusSubscriber(modid = CriasMod.MOD_ID)
    public static class ForgeEvents {

        @SubscribeEvent
        public static void onMount(EntityMountEvent event) {
            if(event.getEntityMounting() instanceof Player player) {
                if(event.isDismounting()) {
                    player.setInvisible(false);
                }
            }
        }


    }

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntities.UNO.get(), FiatUno.setAttributes());
        event.put(ModEntities.ARANHA.get(), Aranha.setAttributes());
        event.put(ModEntities.UNOVERMELHO.get(), FiatUnoVermelho.setAttributes());
        event.put(ModEntities.TREX.get(), T_Rex_Entity.setAttributes());
        event.put(ModEntities.GOLEM.get(), Golem.setAttributes());
        event.put(ModEntities.SPIRITTREE.get(), SpiritCuteTreeEntity.setAttributes());
    }
}
