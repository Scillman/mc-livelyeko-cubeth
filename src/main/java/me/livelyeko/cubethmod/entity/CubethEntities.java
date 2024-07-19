package me.livelyeko.cubethmod.entity;

import me.livelyeko.cubethmod.CubethMod;
import me.livelyeko.cubethmod.entity.car.CarEntity;
import me.livelyeko.cubethmod.entity.car.CarEntityRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CubethEntities {

    public static final EntityType<CarEntity> CAR = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(CubethMod.MOD_ID, "car"),
            EntityType.Builder.create(CarEntity::new, SpawnGroup.MISC).dimensions(6, 3).build()

    );

    public static void initialize() {
        EntityRendererRegistry.register(CAR, CarEntityRenderer::new);
    }
}
