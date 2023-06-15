package net.grupo.criasmod.entities.golem;

import net.grupo.criasmod.CriasMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class GolemModel extends GeoModel<Golem> {
    @Override
    public ResourceLocation getModelResource(Golem animatable) {
        return new ResourceLocation(CriasMod.MOD_ID, "geo/golem.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Golem animatable) {
        return new ResourceLocation(CriasMod.MOD_ID, "textures/entity/golem.txt.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Golem animatable) {
        return new ResourceLocation(CriasMod.MOD_ID, "animations/golem.animation.json");
    }

    @Override
    public void setCustomAnimations(Golem animatable, long instanceId, AnimationState<Golem> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
    }
}
