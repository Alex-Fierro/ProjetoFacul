package net.grupo.criasmod.entities.uno;

import net.grupo.criasmod.CriasMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class UnoModel extends GeoModel<FiatUno> {
    @Override
    public ResourceLocation getModelResource(FiatUno animatable) {
        return new ResourceLocation(CriasMod.MOD_ID, "geo/fiatuno.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FiatUno animatable) {
        return new ResourceLocation(CriasMod.MOD_ID, "textures/entity/fiatuno_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FiatUno animatable) {
        return new ResourceLocation(CriasMod.MOD_ID, "animations/fiatuno.animation.json");
    }
}
