package net.grupo.criasmod.entities;

import net.grupo.criasmod.CriasMod;
import net.grupo.criasmod.entities.aranha.Aranha;
import net.grupo.criasmod.entities.fiatunovermelho.FiatUnoVermelho;
import net.grupo.criasmod.entities.golem.Golem;
import net.grupo.criasmod.entities.t_rex.T_Rex_Entity;
import net.grupo.criasmod.entities.t_rex.T_Rex_Renderer;
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

    public static final RegistryObject<EntityType<FiatUnoVermelho>> UNOVERMELHO =
            ENTITY_TYPES.register("fiatunovermelho",
                    () -> EntityType.Builder.of(FiatUnoVermelho::new, MobCategory.CREATURE)
                            .sized(1.8f, 1.8f)
                            .build(new ResourceLocation(CriasMod.MOD_ID, "fiatunovermelho").toString()));

    public static final RegistryObject<EntityType<Aranha>> ARANHA =
            ENTITY_TYPES.register("aranha",
                    () -> EntityType.Builder.of(Aranha::new, MobCategory.CREATURE)
                            .sized(1.0f, 1.0f)
                            .build(new ResourceLocation(CriasMod.MOD_ID, "aranha").toString()));

    public static final RegistryObject<EntityType<T_Rex_Entity>> TREX =
            ENTITY_TYPES.register("trex",
                    () -> EntityType.Builder.of(T_Rex_Entity::new, MobCategory.CREATURE)
                            .sized(3.0f, 6.0f)
                            .build(new ResourceLocation(CriasMod.MOD_ID, "trex").toString()));

    public static final RegistryObject<EntityType<Golem>> GOLEM =
            ENTITY_TYPES.register("golem",
                    () -> EntityType.Builder.of(Golem::new, MobCategory.CREATURE)
                            .sized(2.5f, 3.0f)
                            .build(new ResourceLocation(CriasMod.MOD_ID, "golem").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
