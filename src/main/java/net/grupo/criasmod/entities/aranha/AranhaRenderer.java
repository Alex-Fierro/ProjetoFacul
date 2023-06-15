package net.grupo.criasmod.entities.aranha;

import com.mojang.blaze3d.vertex.PoseStack;
import net.grupo.criasmod.CriasMod;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class AranhaRenderer extends GeoEntityRenderer<Aranha> {
    public AranhaRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AranhaModel());
    }

    @Override
    public ResourceLocation getTextureLocation(Aranha animatable) {
        return new ResourceLocation(CriasMod.MOD_ID, "textures/entity/spidersakura.png");
    }


    @Override
    public void render(Aranha entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}


