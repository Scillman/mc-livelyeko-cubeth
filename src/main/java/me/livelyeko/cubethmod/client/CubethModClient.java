package me.livelyeko.cubethmod.client;


import me.livelyeko.cubethmod.networking.payload.ExamplePayload;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class CubethModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient(){
        ClientPlayNetworking.registerGlobalReceiver(ExamplePayload.PACKET_ID, (payload, context) -> {
            context.client().execute(() -> {
                context.player().sendMessage(Text.of("packet sent"));

                //ClientBlockHighlighting.highlightBlock(client, payload.blockPos());
            });
        });
    }
}
