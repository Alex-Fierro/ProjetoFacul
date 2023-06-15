package net.grupo.criasmod.entities.t_rex;

import com.mojang.blaze3d.vertex.PoseStack;
import net.grupo.criasmod.CriasMod;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class T_Rex_Renderer extends GeoEntityRenderer<T_Rex_Entity> {

    public T_Rex_Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new T_Rex_Model());
    }


    @Override
    public ResourceLocation getTextureLocation(T_Rex_Entity animatable) {
        return new ResourceLocation(CriasMod.MOD_ID, "textures/entity/trex_texture.png");    }



    @Override
    public void render(T_Rex_Entity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {


        poseStack.scale(3.0f,3.0f,3.0f);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}