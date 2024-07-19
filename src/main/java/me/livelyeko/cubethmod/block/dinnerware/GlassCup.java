package me.livelyeko.cubethmod.block.dinnerware;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class GlassCup extends Block {
    public static int MAX_VALUE = 1;
    public static IntProperty TYPE = IntProperty.of("type", 0, MAX_VALUE);
    private static VoxelShape SHAPE = Block.createCuboidShape(5, 0, 5, 11, 11, 11);

    public GlassCup(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(TYPE, 0));
    }

    public static void setType(int type) {
        TYPE = IntProperty.of("type", type, MAX_VALUE);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TYPE);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return SHAPE;
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
}
