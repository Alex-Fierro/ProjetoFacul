package net.grupo.criasmod.entities.uno;

import net.grupo.criasmod.entities.Veiculo;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;

public class FiatUno extends Veiculo implements GeoEntity {

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    private boolean isTransformed = false;


    public FiatUno(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
    }

    public void setIsTransformed(boolean i) {
        this.isTransformed = i;
    }

    public boolean getIsTransformed() {
        return this.isTransformed;
    }

    public static AttributeSupplier setAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 200D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.5f).build();
    }

    private <T extends GeoAnimatable> PlayState mode_predicate(AnimationState<T> animationState) {
        if(isTransformed == true) {
            animationState.getController().setAnimation(RawAnimation.begin().then("animation.fiatuno.2offroad", Animation.LoopType.HOLD_ON_LAST_FRAME));
            Minecraft.getInstance().player.sendSystemMessage(Component.literal(String.valueOf(standAnimO)));
            return PlayState.CONTINUE;
        } else {
            animationState.getController().setAnimation(RawAnimation.begin().then("animation.fiatuno.2normal", Animation.LoopType.HOLD_ON_LAST_FRAME));
            return PlayState.CONTINUE;
        }
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> animationState) {
        LivingEntity livingEntity = this.getControllingPassenger();
        if(livingEntity != null) {
            animationState.getController().setAnimation(RawAnimation.begin().then("animation.fiatuno.with_player", Animation.LoopType.HOLD_ON_LAST_FRAME));
            return PlayState.CONTINUE;
        } else {
            animationState.getController().setAnimation(RawAnimation.begin().then("animation.fiatuno.no_player", Animation.LoopType.HOLD_ON_LAST_FRAME));
            return PlayState.CONTINUE;
        }
    }

    private <T extends GeoAnimatable> PlayState wheels_predicate(AnimationState<T> animationState) {
        if(animationState.isMoving()) {
            animationState.getController().setAnimation(RawAnimation.begin().then("animation.fiatuno.wheels_on", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        } else {
            animationState.getController().setAnimation(RawAnimation.begin().then("animation.fiatuno.wheels_off", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
    }



    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));
        controllers.add(new AnimationController<>(this, "wheel_controller", 0, this::wheels_predicate));
        controllers.add(new AnimationController<>(this, "mode_controller", 0, this::mode_predicate));
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

}
