package me.livelyeko.cubethmod.block;

import me.livelyeko.cubethmod.CubethMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class PlateOfSlicedCake extends Block {

    public PlateOfSlicedCake(Settings settings) {
        super(settings);
    }

    private static VoxelShape SHAPE = Block.createCuboidShape(3, 0, 3,13, 7, 13);

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {

        if(player.isCreative())
        {
            player.playSound(SoundEvents.BLOCK_GLASS_BREAK, 1.0f, 1.0f);
        } else {
            player.playSound(SoundEvents.BLOCK_GLASS_PLACE, 1.0f, 1.0f);
        }

        return super.onBreak(world, pos, state, player);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        BlockState newState = CubethBlocks.GLASS_PLATE.getDefaultState();
        world.setBlockState(pos, newState);

        player.getHungerManager().add(1, 0.4f);
        player.playSound(SoundEvents.ENTITY_PLAYER_BURP, 1.0f, 1.0f);

        return super.onUse(state, world, pos, player, hit);
    }
}
