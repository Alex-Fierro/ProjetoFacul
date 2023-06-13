package net.grupo.criasmod.entities;

import net.grupo.criasmod.Exception.GuiErrorScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundDisconnectPacket;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;


public abstract class Veiculo extends Mob {

    protected float standAnimO = -0.5f;
    private float deltaRotation;

    protected Veiculo(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if(this.isAlive()) {
            this.doPlayerRide(player);
            return InteractionResult.sidedSuccess(this.level.isClientSide);
        }
        return super.mobInteract(player, hand);
    }

    protected void doPlayerRide(Player player) {
        if (!this.level.isClientSide) {
            player.setYRot(this.getYRot());
            player.setXRot(this.getXRot());
            player.startRiding(this);
        }
    }

    public void positionRider(Entity entity) {
        super.positionRider(entity);
        if(entity instanceof Mob mob) {
            this.yBodyRot = mob.yBodyRot;
        }

        if(this.standAnimO < 0.0F) {
            float f3 = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F));
            float f = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F));
            float f1 = 0.7F * this.standAnimO;
            float f2 = 0.15F * this.standAnimO;
            entity.setPos(this.getX() + (double) (f1 * f3) + 0.6D, this.getY() + this.getPassengersRidingOffset() + entity.getMyRidingOffset() + (double) f2 - 1.0D, this.getZ() - (double) (f1 * f));
            if(entity instanceof LivingEntity) {
                ((LivingEntity)entity).yBodyRot = this.yBodyRot;
                //entity.setYRot(this.getYRot());
            }
        }

    }

    @Override
    public void tick() {
        super.tick();
        Player player = Minecraft.getInstance().player;
        LivingEntity livingentity = this.getControllingPassenger();
        if(player != null) {
            if(this.isVehicle()) {
                if(this.level.isClientSide) {
                    try {
                        this.controll();
                    } catch (NullPointerException e) {
                        String message = "Internal Exception: " + e.toString();
                        String message2 = "Aconteceu uma exceção, não posso verificar .zza porque livingentity é null";
                        String message3 = "Crashou pq vc é BURRO";
                        //Minecraft.getInstance().player.sendSystemMessage(Component.literal(message));
                        Minecraft.getInstance().player.connection.handleDisconnect(new ClientboundDisconnectPacket(Component.literal(message3)));
                        //Minecraft.getInstance().setScreen(new GuiErrorScreen(message));
                    }
                }
            }
        }
    }


    private void controll() {
            LivingEntity livingentity = this.getControllingPassenger();
            if(this.isAlive()) {
                float f = 0.0F;

                if (livingentity.xxa > 0 && deltaRotation > (-10)) {
                    //Minecraft.getInstance().player.sendSystemMessage(Component.literal("LEFT"));
                    this.deltaRotation = deltaRotation - 0.3f;
                }

                if (livingentity.xxa < 0  && deltaRotation < 10) {
                    //Minecraft.getInstance().player.sendSystemMessage(Component.literal("RIGHT"));
                    this.deltaRotation = deltaRotation + 0.3f;
                }


                if (livingentity.zza == 0 && f != 0) {
                    f = f - 0.005F;
                }

                this.setYRot(this.getYRot() + this.deltaRotation);
                if (livingentity.zza > 0) {
                    f = f + 0.2F;
                }

                if (livingentity.zza < 0) {
                    f -= 0.05F;
                }

                this.setDeltaMovement(this.getDeltaMovement().add( (Mth.sin(-this.getYRot() * ((float) Math.PI / 180F)) * f), 0.0D, (Mth.cos(this.getYRot() * ((float) Math.PI / 180F)) * f)));
            }
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        if (this.isAlive()) {
            Entity entity = this.getFirstPassenger();
            if(entity instanceof LivingEntity) {

                entity.setInvisible(true);

                return (LivingEntity)entity;

            }
        }

        return null;
    }

}
