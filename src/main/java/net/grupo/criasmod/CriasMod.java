package net.grupo.criasmod;

import com.mojang.logging.LogUtils;
import net.grupo.criasmod.entities.ModEntities;
import net.grupo.criasmod.entities.aranha.AranhaRenderer;
import net.grupo.criasmod.entities.fiatunovermelho.UnoVermelhoRenderer;
import net.grupo.criasmod.entities.golem.Golem;
import net.grupo.criasmod.entities.golem.GolemRenderer;
import net.grupo.criasmod.entities.spirittree.SpiritCuteTreeRenderer;
import net.grupo.criasmod.entities.t_rex.T_Rex_Renderer;
import net.grupo.criasmod.entities.uno.UnoRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CriasMod.MOD_ID)
public class CriasMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "criasmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public CriasMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }



    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            EntityRenderers.register(ModEntities.UNO.get(), UnoRenderer::new);
            EntityRenderers.register(ModEntities.UNOVERMELHO.get(), UnoVermelhoRenderer::new);
            EntityRenderers.register(ModEntities.ARANHA.get(), AranhaRenderer::new);
            EntityRenderers.register(ModEntities.TREX.get(), T_Rex_Renderer::new);
            EntityRenderers.register(ModEntities.GOLEM.get(), GolemRenderer::new);
            EntityRenderers.register(ModEntities.SPIRITTREE.get(), SpiritCuteTreeRenderer::new);
        }
    }
}
