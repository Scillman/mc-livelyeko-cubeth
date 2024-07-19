package me.livelyeko.cubethmod;

import me.livelyeko.cubethmod.entity.CubethEntities;
import me.livelyeko.cubethmod.entity.car.CarEntityModel;
import me.livelyeko.cubethmod.entity.car.CarEntityRenderer;
import me.livelyeko.cubethmod.entity.CubethModelLayers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import me.livelyeko.cubethmod.block.CubethBlocks;

@Environment(EnvType.CLIENT)
public class CubethModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(CubethEntities.CAR, CarEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(CubethModelLayers.CAR_MODEL_LAYER, CarEntityModel::getTexturedModelData);

        BlockRenderLayerMap.INSTANCE.putBlock(CubethBlocks.GLASS_CUP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CubethBlocks.GLASS_PLATE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(CubethBlocks.GLASS_PLATE_OF_SLICED_CAKE, RenderLayer.getCutout());
    }
}
