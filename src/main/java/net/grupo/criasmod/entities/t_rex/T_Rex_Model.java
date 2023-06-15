package net.grupo.criasmod.entities.t_rex;

import net.grupo.criasmod.CriasMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class T_Rex_Model extends GeoModel<T_Rex_Entity> {

    @Override
    public ResourceLocation getModelResource(T_Rex_Entity animatable) {
        return new ResourceLocation(CriasMod.MOD_ID, "geo/trex.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T_Rex_Entity animatable) {
        return new ResourceLocation(CriasMod.MOD_ID, "textures/entity/trex_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(T_Rex_Entity animatable) {
        return new ResourceLocation(CriasMod.MOD_ID, "animations/trex.animation.json");
    }

    @Override
    public void setCustomAnimations(T_Rex_Entity animatable, long instanceId, AnimationState<T_Rex_Entity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
    }
}
