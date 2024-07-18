package me.livelyeko.cubethmod.item.dinnerware;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

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


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();

        BlockState blockstate =  world.getBlockState(context.getBlockPos());
        Block block = blockstate.getBlock();

        player.sendMessage(Text.of(block.getName()));

        return super.useOnBlock(context);
    }
*/

}



