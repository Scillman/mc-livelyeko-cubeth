package me.livelyeko.cubethmod.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import me.livelyeko.cubethmod.block.CubethBlocks;
import me.livelyeko.cubethmod.util.CubethTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.block.CandleBlock;
import net.minecraft.block.CandleCakeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

@Mixin(CakeBlock.class)
public class CakeBlockMixin {
    /**
     * @author livelyeko
     * @change Added else if statement to existing if statement.
     * @reason Overwritten to add interaction with a Glass Plate.
     */
    @Overwrite()
    public ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        Item item = stack.getItem();
        if (stack.isIn(ItemTags.CANDLES) && (Integer)state.get(((CakeBlock)(Object) this).BITES) == 0) {
            Block var10 = Block.getBlockFromItem(item);
            if (var10 instanceof CandleBlock) {
                CandleBlock candleBlock = (CandleBlock)var10;
                stack.decrementUnlessCreative(1, player);
                world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_CAKE_ADD_CANDLE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                world.setBlockState(pos, CandleCakeBlock.getCandleCakeFromCandle(candleBlock));
                world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
                player.incrementStat(Stats.USED.getOrCreateStat(item));
                return ItemActionResult.SUCCESS;
            }
        } else if (stack.isIn(CubethTags.Items.DINNERWARE) && state.get(CakeBlock.BITES) <= CakeBlock.MAX_BITES) {
            stack.decrement(1);


            player.sendMessage(Text.of("Took cake"));

            world.playSound(null, pos, SoundEvents.BLOCK_POWDER_SNOW_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);

            if(state.get(((CakeBlock)(Object) this).BITES) < 6) {
                world.setBlockState(pos, (BlockState)state.with(((CakeBlock)(Object) this).BITES, state.get(((CakeBlock)(Object) this).BITES) + 1), 3);
            } else {
                world.removeBlock(pos, false);
                world.emitGameEvent(player, GameEvent.BLOCK_DESTROY, pos);
            }

            // Give plate of sliced cake to player.
            ItemStack SlicedCake = new ItemStack(CubethBlocks.GLASS_PLATE_OF_SLICED_CAKE, 1);
            boolean wasAdded =  player.getInventory().insertStack(SlicedCake);

            if(!wasAdded)
            {
                player.dropItem(SlicedCake, false);
            }

            world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            return ItemActionResult.SUCCESS;
        }

        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
}
