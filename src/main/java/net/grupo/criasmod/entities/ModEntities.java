package net.grupo.criasmod.entities;

import net.grupo.criasmod.CriasMod;
import net.grupo.criasmod.entities.uno.FiatUno;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CriasMod.MOD_ID);


    public static final RegistryObject<EntityType<FiatUno>> UNO =
            ENTITY_TYPES.register("fiatuno",
                    () -> EntityType.Builder.of(FiatUno::new, MobCategory.CREATURE)
                            .sized(1.8f, 1.8f)
                            .build(new ResourceLocation(CriasMod.MOD_ID, "fiatuno").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
