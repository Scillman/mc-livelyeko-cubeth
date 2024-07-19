package me.livelyeko.cubethmod.block.dinnerware;

import me.livelyeko.cubethmod.block.CubethBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class GlassPlate extends Block {
    public static int MAX_VALUE = 1;
    public static IntProperty TYPE = IntProperty.of("type", 0, MAX_VALUE);
    private static VoxelShape[] SHAPE = new VoxelShape[] {
            Block.createCuboidShape(3, 0, 3, 13, 1, 13),
            Block.createCuboidShape(5, 0, 5, 11, 11, 11),
    };

    public GlassPlate(Settings settings, int value) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(TYPE, value));
    }

    public static void setType(int type) {
        TYPE = IntProperty.of("type", type, MAX_VALUE);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TYPE);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE[state.get(TYPE)];
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {

        if (player.isCreative()) {
            player.playSound(SoundEvents.BLOCK_GLASS_BREAK, 1.0f, 1.0f);
        } else {
            player.playSound(SoundEvents.BLOCK_GLASS_PLACE, 1.0f, 1.0f);
        }

        return super.onBreak(world, pos, state, player);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        if (state.get(TYPE) > 0) {
            BlockState newState = CubethBlocks.GLASS_PLATE.getDefaultState();
            world.setBlockState(pos, newState);

            player.getHungerManager().add(1, 0.4f);
            player.playSound(SoundEvents.ENTITY_PLAYER_BURP, 1.0f, 1.0f);
        }

        return super.onUse(state, world, pos, player, hit);
    }
}
