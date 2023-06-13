package net.grupo.criasmod.entities.uno;

import com.mojang.blaze3d.vertex.PoseStack;
import net.grupo.criasmod.CriasMod;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class UnoRenderer extends GeoEntityRenderer<FiatUno> {
    public UnoRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new UnoModel());
    }

    @Override
    public ResourceLocation getTextureLocation(FiatUno animatable) {
        return new ResourceLocation(CriasMod.MOD_ID, "textures/entity/fiatuno_texture.png");
    }

    @Override
    public void render(FiatUno entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {

        poseStack.scale(1.2f, 1.2f, 1.2f);


        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
