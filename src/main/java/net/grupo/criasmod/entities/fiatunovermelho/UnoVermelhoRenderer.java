package net.grupo.criasmod.entities.fiatunovermelho;

import com.mojang.blaze3d.vertex.PoseStack;
import net.grupo.criasmod.CriasMod;
import net.grupo.criasmod.entities.uno.FiatUno;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class UnoVermelhoRenderer extends GeoEntityRenderer<FiatUnoVermelho> {
    public UnoVermelhoRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new UnoVermelhoModel());
    }

    @Override
    public ResourceLocation getTextureLocation(FiatUnoVermelho animatable) {
        return new ResourceLocation(CriasMod.MOD_ID, "textures/entity/farebit_texture.png");
    }

    @Override
    public void render(FiatUnoVermelho entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {

        poseStack.scale(1.2f, 1.2f, 1.2f);

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
