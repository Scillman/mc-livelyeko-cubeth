package me.livelyeko.cubethmod.entity.car;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.10.4
public class CarEntityModel<T extends Entity> extends SinglePartEntityModel<T> {
    private final ModelPart root;

    public CarEntityModel(ModelPart root) {
        this.root = root;
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData structure = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.5F, 24.0F, 0.0F));

        ModelPartData cube_r1 = structure.addChild("cube_r1", ModelPartBuilder.create().uv(0, 4).cuboid(2.75F, -0.5F, 4.375F, 0.25F, 0.25F, 0.25F, new Dilation(0.0F))
        .uv(4, 1).cuboid(2.25F, -0.625F, 4.25F, 0.5F, 0.375F, 0.5F, new Dilation(0.0F))
        .uv(0, 1).cuboid(2.875F, -1.0F, 4.125F, 0.125F, 0.3125F, 0.75F, new Dilation(0.0F))
        .uv(0, 1).cuboid(2.0F, -1.0F, 4.0F, 1.0F, 0.3125F, 0.125F, new Dilation(0.0F))
        .uv(0, 1).cuboid(2.0F, -1.0F, 4.875F, 1.0F, 0.3125F, 0.125F, new Dilation(0.0F))
        .uv(0, 1).cuboid(2.0F, -0.6875F, 4.0F, 1.0F, 0.0625F, 1.0F, new Dilation(0.0F))
        .uv(0, 4).cuboid(2.75F, -0.5F, 2.375F, 0.25F, 0.25F, 0.25F, new Dilation(0.0F))
        .uv(4, 1).cuboid(2.25F, -0.625F, 2.25F, 0.5F, 0.375F, 0.5F, new Dilation(0.0F))
        .uv(0, 1).cuboid(2.875F, -1.0F, 2.125F, 0.125F, 0.3125F, 0.75F, new Dilation(0.0F))
        .uv(0, 1).cuboid(2.0F, -1.0F, 2.0F, 1.0F, 0.3125F, 0.125F, new Dilation(0.0F))
        .uv(0, 1).cuboid(2.0F, -1.0F, 2.875F, 1.0F, 0.3125F, 0.125F, new Dilation(0.0F))
        .uv(0, 1).cuboid(2.0F, -0.6875F, 2.0F, 1.0F, 0.0625F, 1.0F, new Dilation(0.0F))
        .uv(1, 2).mirrored().cuboid(-1.0F, -3.0625F, 4.0F, 1.0F, 0.0625F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(1, 2).mirrored().cuboid(-1.0F, -3.0625F, 3.0F, 1.0F, 0.0625F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(1, 2).mirrored().cuboid(-1.0F, -3.0625F, 2.0F, 1.0F, 0.0625F, 1.0F, new Dilation(0.0F)).mirrored(false)
        .uv(0, 2).cuboid(0.0F, -3.0625F, 4.0F, 1.0F, 0.0625F, 1.0F, new Dilation(0.0F))
        .uv(0, 2).cuboid(0.0F, -3.0625F, 3.0F, 1.0F, 0.0625F, 1.0F, new Dilation(0.0F))
        .uv(0, 2).cuboid(0.0F, -3.0625F, 2.0F, 1.0F, 0.0625F, 1.0F, new Dilation(0.0F))
        .uv(0, 1).cuboid(-0.5625F, -3.0F, 4.4375F, 0.125F, 1.0F, 0.125F, new Dilation(0.0F))
        .uv(1, 1).mirrored().cuboid(-0.5625F, -3.0F, 4.4375F, 0.125F, 1.0F, 0.125F, new Dilation(0.0F)).mirrored(false)
        .uv(0, 6).cuboid(-0.4375F, -3.0F, 4.4375F, 0.4375F, 1.0F, 0.125F, new Dilation(0.0F))
        .uv(0, 6).mirrored().cuboid(-0.5625F, -3.0F, 4.0F, 0.125F, 1.0F, 0.4375F, new Dilation(0.0F)).mirrored(false)
        .uv(0, 6).cuboid(-0.5625F, -3.0F, 4.4375F, 0.125F, 1.0F, 0.125F, new Dilation(0.0F))
        .uv(0, 1).cuboid(-0.5625F, -3.0F, 3.4375F, 0.125F, 1.0F, 0.125F, new Dilation(0.0F))
        .uv(1, 1).mirrored().cuboid(-0.5625F, -3.0F, 3.4375F, 0.125F, 1.0F, 0.125F, new Dilation(0.0F)).mirrored(false)
        .uv(1, 6).mirrored().cuboid(-0.5625F, -3.0F, 3.5625F, 0.125F, 1.0F, 0.4375F, new Dilation(0.0F)).mirrored(false)
        .uv(0, 6).mirrored().cuboid(-0.5625F, -3.0F, 3.0F, 0.125F, 1.0F, 0.4375F, new Dilation(0.0F)).mirrored(false)
        .uv(0, 6).cuboid(-0.5625F, -3.0F, 3.4375F, 0.125F, 1.0F, 0.125F, new Dilation(0.0F))
        .uv(1, 1).mirrored().cuboid(-0.5625F, -3.0F, 2.4375F, 0.125F, 1.0F, 0.125F, new Dilation(0.0F)).mirrored(false)
        .uv(0, 1).cuboid(-0.5625F, -3.0F, 2.4375F, 0.125F, 1.0F, 0.125F, new Dilation(0.0F))
        .uv(0, 6).cuboid(-0.4375F, -3.0F, 2.4375F, 0.4375F, 1.0F, 0.125F, new Dilation(0.0F))
        .uv(1, 6).mirrored().cuboid(-0.5625F, -3.0F, 2.5625F, 0.125F, 1.0F, 0.4375F, new Dilation(0.0F)).mirrored(false)
        .uv(0, 6).cuboid(-0.5625F, -3.0F, 2.4375F, 0.125F, 1.0F, 0.125F, new Dilation(0.0F))
        .uv(0, 1).cuboid(0.4375F, -3.0F, 4.4375F, 0.125F, 1.0F, 0.125F, new Dilation(0.0F))
        .uv(0, 1).cuboid(0.4375F, -3.0F, 4.4375F, 0.125F, 1.0F, 0.125F, new Dilation(0.0F))
        .uv(0, 6).cuboid(0.5625F, -3.0F, 4.4375F, 0.4375F, 1.0F, 0.125F, new Dilation(0.0F))
        .uv(0, 6).cuboid(0.0F, -3.0F, 4.4375F, 0.4375F, 1.0F, 0.125F, new Dilation(0.0F))
        .uv(0, 6).cuboid(0.4375F, -3.0F, 4.4375F, 0.125F, 1.0F, 0.125F, new Dilation(0.0F))
        .uv(0, 1).cuboid(0.4375F, -3.0F, 2.4375F, 0.125F, 1.0F, 0.125F, new Dilation(0.0F))
        .uv(0, 1).cuboid(0.4375F, -3.0F, 2.4375F, 0.125F, 1.0F, 0.125F, new Dilation(0.0F))
        .uv(0, 6).cuboid(0.5625F, -3.0F, 2.4375F, 0.4375F, 1.0F, 0.125F, new Dilation(0.0F))
        .uv(0, 6).cuboid(0.0F, -3.0F, 2.4375F, 0.4375F, 1.0F, 0.125F, new Dilation(0.0F))
        .uv(0, 6).cuboid(0.4375F, -3.0F, 2.4375F, 0.125F, 1.0F, 0.125F, new Dilation(0.0F))
        .uv(1, 2).cuboid(1.0F, -3.0F, 4.0F, 0.5F, 0.5F, 1.0F, new Dilation(0.0F))
        .uv(2, 0).cuboid(1.0F, -2.5F, 4.0F, 1.0F, 0.5F, 1.0F, new Dilation(0.0F))
        .uv(1, 1).cuboid(1.0F, -3.0F, 3.0F, 0.1875F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(1, 2).cuboid(1.0F, -3.0F, 2.0F, 0.5F, 0.5F, 1.0F, new Dilation(0.0F))
        .uv(2, 0).cuboid(1.0F, -2.5F, 2.0F, 1.0F, 0.5F, 1.0F, new Dilation(0.0F))
        .uv(1, 1).cuboid(-3.125F, -1.625F, 4.3125F, 0.125F, 0.25F, 0.375F, new Dilation(0.0F))
        .uv(1, 1).cuboid(-3.125F, -1.625F, 2.3125F, 0.125F, 0.25F, 0.375F, new Dilation(0.0F))
        .uv(0, 0).cuboid(-2.0F, -2.0F, 4.0F, 1.0F, 0.5F, 1.0F, new Dilation(0.0F))
        .uv(0, 0).cuboid(-2.0F, -2.0F, 2.0F, 1.0F, 0.5F, 1.0F, new Dilation(0.0F))
        .uv(0, 1).cuboid(-0.0012F, -1.75F, 3.3125F, 0.1875F, 0.5F, 0.375F, new Dilation(0.0F))
        .uv(0, 0).cuboid(1.0F, -2.0F, 4.0F, 1.0F, 0.5F, 1.0F, new Dilation(0.0F))
        .uv(0, 0).cuboid(1.0F, -2.0F, 2.0F, 1.0F, 0.5F, 1.0F, new Dilation(0.0F))
        .uv(1, 1).cuboid(-3.0F, -1.0F, 4.0F, 1.0F, 0.5F, 1.0F, new Dilation(0.0F))
        .uv(1, 1).cuboid(-3.0F, -1.0F, 3.0F, 1.0F, 0.5F, 1.0F, new Dilation(0.0F))
        .uv(1, 1).cuboid(-3.0F, -1.0F, 2.0F, 1.0F, 0.5F, 1.0F, new Dilation(0.0F))
        .uv(3, 6).mirrored().cuboid(-1.6875F, -0.625F, 5.0F, 0.375F, 0.25F, 0.125F, new Dilation(0.0F)).mirrored(false)
        .uv(0, 1).cuboid(-2.0F, -1.0F, 3.0F, 1.0F, 0.5F, 1.0F, new Dilation(0.0F))
        .uv(3, 0).cuboid(-1.6875F, -0.625F, 1.875F, 0.375F, 0.25F, 0.125F, new Dilation(0.0F))
        .uv(0, 1).cuboid(-1.0F, -1.0F, 4.0F, 1.0F, 0.5F, 1.0F, new Dilation(0.0F))
        .uv(0, 1).cuboid(-1.0F, -1.0F, 3.0F, 1.0F, 0.5F, 1.0F, new Dilation(0.0F))
        .uv(0, 1).cuboid(-1.0F, -1.0F, 2.0F, 1.0F, 0.5F, 1.0F, new Dilation(0.0F))
        .uv(0, 1).cuboid(0.0F, -1.0F, 4.0F, 1.0F, 0.5F, 1.0F, new Dilation(0.0F))
        .uv(0, 0).cuboid(0.0F, -1.0F, 3.0F, 1.0F, 0.5F, 1.0F, new Dilation(0.0F))
        .uv(0, 1).cuboid(0.0F, -1.0F, 2.0F, 1.0F, 0.5F, 1.0F, new Dilation(0.0F))
        .uv(3, 6).mirrored().cuboid(1.3125F, -0.625F, 5.0F, 0.375F, 0.25F, 0.125F, new Dilation(0.0F)).mirrored(false)
        .uv(0, 1).cuboid(1.0F, -1.0F, 3.0F, 1.0F, 0.5F, 1.0F, new Dilation(0.0F))
        .uv(3, 0).cuboid(1.3125F, -0.625F, 1.875F, 0.375F, 0.25F, 0.125F, new Dilation(0.0F))
        .uv(0, 1).cuboid(2.0F, -1.0F, 3.0F, 1.0F, 0.5F, 1.0F, new Dilation(0.0F))
        .uv(0, 0).cuboid(-3.0F, -2.0F, 4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(0, 0).cuboid(-3.0F, -2.0F, 3.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(0, 0).cuboid(-3.0F, -2.0F, 2.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(0, 0).cuboid(-2.0F, -2.0F, 3.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(0, 0).cuboid(-1.0F, -2.0F, 4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(0, 0).cuboid(-1.0F, -2.0F, 3.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(0, 0).cuboid(-1.0F, -2.0F, 2.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(0, 0).cuboid(0.0F, -2.0F, 4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(0, 0).cuboid(0.0F, -2.0F, 2.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(0, 0).cuboid(1.0F, -2.0F, 3.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(0, 0).cuboid(2.0F, -2.0F, 4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(0, 0).cuboid(2.0F, -2.0F, 3.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(0, 0).cuboid(2.0F, -2.0F, 2.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(0, 0).cuboid(-2.0F, -1.0F, 4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(0, 0).cuboid(-2.0F, -1.0F, 2.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(0, 0).cuboid(1.0F, -1.0F, 4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
        .uv(0, 0).cuboid(1.0F, -1.0F, 2.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
        return TexturedModelData.of(modelData, 8, 8);
    }


    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
        root.render(matrices, vertices, light, overlay);
    }

    @Override
    public ModelPart getPart() {
        return root;
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
}