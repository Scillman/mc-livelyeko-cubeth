package me.livelyeko.cubethmod.entity.car;


import me.livelyeko.cubethmod.CubethMod;
import me.livelyeko.cubethmod.entity.CubethModelLayers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class CarEntityRenderer extends EntityRenderer<CarEntity> {
    public static final Identifier TEXTURE = Identifier.of(CubethMod.MOD_ID, "textures/entity/car/car.png");

    protected CarEntityModel<CarEntity> model;

    public CarEntityRenderer(EntityRendererFactory.Context context) {
       super(context);
       this.model = new CarEntityModel<CarEntity>(context.getPart(CubethModelLayers.CAR_MODEL_LAYER));
    }

    @Override
    public Identifier getTexture(CarEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(CarEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumerProvider, int light) {
        super.render(entity, yaw, tickDelta, matrices, vertexConsumerProvider, light);

        RenderLayer renderLayer = this.model.getLayer(this.getTexture(entity));
        if (renderLayer != null) {
            VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(renderLayer);
            int overlay = OverlayTexture.packUv(OverlayTexture.getU(tickDelta), OverlayTexture.getV(false));
            this.model.render(matrices, vertexConsumer, light, overlay, -1);
        }
    }
}
