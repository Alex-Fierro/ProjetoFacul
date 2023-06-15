package net.grupo.criasmod.entities.fiatunovermelho;

import net.grupo.criasmod.CriasMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class UnoVermelhoModel extends GeoModel<FiatUnoVermelho> {

    @Override
    public ResourceLocation getModelResource(FiatUnoVermelho animatable) {
        return new ResourceLocation(CriasMod.MOD_ID, "geo/fiatunovermelho.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FiatUnoVermelho animatable) {
        return new ResourceLocation(CriasMod.MOD_ID, "textures/entity/farebit_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FiatUnoVermelho animatable) {
        return new ResourceLocation(CriasMod.MOD_ID, "animations/fiatunovermelho.animation.json");
    }
}
