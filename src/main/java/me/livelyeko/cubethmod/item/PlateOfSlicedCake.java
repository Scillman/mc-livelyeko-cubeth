package me.livelyeko.cubethmod.item;

import me.livelyeko.cubethmod.block.CubethBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class PlateOfSlicedCake extends BlockItem {

    public PlateOfSlicedCake(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        user.getHungerManager().add(1, 0.4f);
        user.playSound(SoundEvents.ENTITY_PLAYER_BURP, 1.0f, 1.0f);

        int slot = user.getInventory().selectedSlot;

        user.getInventory().setStack(slot, new ItemStack(CubethBlocks.GLASS_PLATE, 1));

        return super.use(world, user, hand);
    }
}