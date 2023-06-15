package net.grupo.criasmod.entities.aranha;

import net.grupo.criasmod.CriasMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class AranhaModel extends GeoModel<Aranha> {
    @Override
    public ResourceLocation getModelResource(Aranha animatable) {
        return new ResourceLocation(CriasMod.MOD_ID, "geo/aranha.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Aranha animatable) {
        return new ResourceLocation(CriasMod.MOD_ID, "textures/entity/spidersakura.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Aranha animatable) {
        return new ResourceLocation(CriasMod.MOD_ID, "animations/aranha.animation.json");
    }

    @Override
    public void setCustomAnimations(Aranha animatable, long instanceId, AnimationState<Aranha> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
    }
}
