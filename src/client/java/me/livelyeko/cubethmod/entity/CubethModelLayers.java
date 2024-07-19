package me.livelyeko.cubethmod.entity;

import me.livelyeko.cubethmod.CubethMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class CubethModelLayers {
    public static final EntityModelLayer CAR_MODEL_LAYER =
        new EntityModelLayer(Identifier.of(CubethMod.MOD_ID, "car"), "main");
}
