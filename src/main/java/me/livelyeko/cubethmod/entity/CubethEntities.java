package me.livelyeko.cubethmod.entity;

import me.livelyeko.cubethmod.CubethMod;
import me.livelyeko.cubethmod.entity.car.CarEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CubethEntities {

    public static final EntityType<CarEntity> CAR = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(CubethMod.MOD_ID, "car"),
        EntityType.Builder.create(CarEntity::new, SpawnGroup.MISC).dimensions(6.0f, 3.0f).build() // .maxTrackingRange(8)
    );

    public static void initialize() {
    }
}
