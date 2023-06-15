package net.grupo.criasmod.entities.golem;

import com.mojang.blaze3d.vertex.PoseStack;
import net.grupo.criasmod.CriasMod;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GolemRenderer extends GeoEntityRenderer<Golem> {
    public GolemRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GolemModel());
    }
    @Override
    public ResourceLocation getTextureLocation(Golem animatable) {
        return new ResourceLocation(CriasMod.MOD_ID, "textures/entity/golem.txt.png");
    }

    @Override
    public void render(Golem entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {

        poseStack.scale(1.0f, 1.0f, 1.0f);


        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
