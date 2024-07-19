package me.livelyeko.cubethmod.entity.car;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class CarEntity extends Entity {

    public CarEntity(EntityType<? extends Entity> type, World world) {
        super(type, world);
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        return player.startRiding(this) ? ActionResult.CONSUME : ActionResult.PASS;
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {

    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {

    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {

    }
}
