package me.livelyeko.cubethmod.item;

import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class GlassPlate extends BlockItem {

    public GlassPlate(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (world.isClient()) {
            return super.use(world, user, hand);
        }

        HitResult hit = MinecraftClient.getInstance().crosshairTarget;

        if (hand == Hand.MAIN_HAND) {
            if(hit.getType() != HitResult.Type.BLOCK) {
                user.sendMessage(Text.of("A"));
            } else {
                user.sendMessage(Text.of("B"));
            }
        }

        user.sendMessage(Text.of(hit.getType().toString()));

        return TypedActionResult.success(user.getStackInHand(hand));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        HitResult hit = MinecraftClient.getInstance().crosshairTarget;

        PlayerEntity player = context.getPlayer();

        player.sendMessage(Text.of(hit.getType().toString()));

        return super.useOnBlock(context);
    }
}
