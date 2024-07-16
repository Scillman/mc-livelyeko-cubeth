package me.livelyeko.cubethmod.item;

import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class GlassCup extends BlockItem {

    public GlassCup(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        HitResult hit = MinecraftClient.getInstance().crosshairTarget;

        if (hand == Hand.MAIN_HAND && hit.getType() != HitResult.Type.BLOCK) {
            user.playSound(SoundEvents.ENTITY_GENERIC_DRINK, 1.0f, 1.0f);
            user.sendMessage(Text.of("Gulp gulp gulp."));
        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
