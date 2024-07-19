package me.livelyeko.cubethmod.entity.car;

import me.livelyeko.cubethmod.CubethMod;
import me.livelyeko.cubethmod.entity.CubethModelLayers;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CarEntityRenderer extends EntityRenderer<CarEntity> {

    public CarEntityRenderer(EntityRendererFactory.Context context) {
       super(context);
       //super(context, new CarEntityModel<>(context.getPart(CubethModelLayers.CAR_MODEL_LAYER)), 0.6f);
    }

    @Override
    public Identifier getTexture(CarEntity entity) {
        return Identifier.of(CubethMod.MOD_ID, "textures/entity/car/car.png");
    }


    @Override
    public void render(CarEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }
}
