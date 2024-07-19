package me.livelyeko.cubethmod.client;


import me.livelyeko.cubethmod.entity.CubethEntities;
import me.livelyeko.cubethmod.entity.car.CarEntityModel;
import me.livelyeko.cubethmod.entity.car.CarEntityRenderer;
import me.livelyeko.cubethmod.entity.CubethModelLayers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class CubethModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(){

        EntityRendererRegistry.register(CubethEntities.CAR, CarEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(CubethModelLayers.CAR_MODEL_LAYER, CarEntityModel::getTexturedModelData);

    }
}
