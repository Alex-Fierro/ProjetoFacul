package net.grupo.criasmod.entities.spirittree;
import net.grupo.criasmod.CriasMod;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SpiritCuteTreeRenderer extends GeoEntityRenderer <SpiritCuteTreeEntity> {

    public SpiritCuteTreeRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SpiritTreeModel());
    }

    @Override
    public ResourceLocation getTextureLocation(SpiritCuteTreeEntity animatable) {
        return new ResourceLocation(CriasMod.MOD_ID, "textures/entity/spirit.png");
    }

    /*@Override
    public void render(SpiritCuteTreeEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if(entity.isBaby()){
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

     */


}
