package me.livelyeko.cubethmod.item;

import me.livelyeko.cubethmod.networking.payload.ExamplePayload;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class GlassPlate extends BlockItem {

    public GlassPlate(Block block, Settings settings) {
        super(block, settings);
    }

    /*
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (world.isClient()) {
            return super.use(world, user, hand);
        }

        HitResult hit = MinecraftClient.getInstance().crosshairTarget;
        BlockState blockstate =  world.getBlockState(BlockPos.ofFloored(hit.getPos()));
        Block block = blockstate.getBlock();

        BlockPos target = user.getBlockPos();
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeBlockPos(target);

        CustomPayload payload = new ExamplePayload(target);

        for (ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) world, target)) {
            ServerPlayNetworking.send(player, payload);
        }

        if(hit.getType() == HitResult.Type.BLOCK) {
            user.sendMessage(Text.of(block.getName()));
        } else {
            user.sendMessage(Text.of("Not a block"));
        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }
*/

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();

        BlockState blockstate =  world.getBlockState(context.getBlockPos());
        Block block = blockstate.getBlock();

        player.sendMessage(Text.of(block.getName()));

        return super.useOnBlock(context);
    }


}



