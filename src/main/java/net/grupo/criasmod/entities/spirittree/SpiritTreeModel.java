package net.grupo.criasmod.entities.spirittree;
import net.grupo.criasmod.CriasMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpiritTreeModel extends GeoModel<SpiritCuteTreeEntity> {


    @Override
    public ResourceLocation getModelResource(SpiritCuteTreeEntity animatable) {
        return new ResourceLocation(CriasMod.MOD_ID, "geo/spirit.geo.json");

    }

    @Override
    public ResourceLocation getTextureResource(SpiritCuteTreeEntity animatable) {
        return new ResourceLocation(CriasMod.MOD_ID, "texture/entity/spirit.png");

    }

    @Override
    public ResourceLocation getAnimationResource(SpiritCuteTreeEntity animatable) {
        return new ResourceLocation(CriasMod.MOD_ID, "animations/spirttree.animation.json");
    }
}





