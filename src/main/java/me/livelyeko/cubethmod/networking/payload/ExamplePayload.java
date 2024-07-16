package me.livelyeko.cubethmod.networking.payload;

import me.livelyeko.cubethmod.CubethMod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;



public class ExamplePayload implements CustomPayload {

    public static final CustomPayload.Id<ExamplePayload> ID = new CustomPayload.Id<>(Identifier.of(CubethMod.MOD_ID, "example"));
    //public static final PacketCodec<RegistryByteBuf, ExamplePayload> CODEC = PacketCodec.tuple(BlockPos.PACKET_CODEC, ExamplePayload::blockPos, ExamplePayload::new);

    // should you need to send more data, add the appropriate record parameters and change your codec:
    // public static final PacketCodec<RegistryByteBuf, BlockHighlightPayload> CODEC = PacketCodec.tuple(
    //         BlockPos.PACKET_CODEC, BlockHighlightPayload::blockPos,
    //         PacketCodecs.INTEGER, BlockHighlightPayload::myInt,
    //         Uuids.PACKET_CODEC, BlockHighlightPayload::myUuid,
    //         BlockHighlightPayload::new
    // );

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }


    /*
    EntityType.COW.spawn((ServerWorld) player.getServerWorld(), null, player.getBlockPos(),
            SpawnReason.TRIGGERED, true, false);
     */
}
