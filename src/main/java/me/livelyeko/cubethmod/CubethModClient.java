package me.livelyeko.cubethmod;

import me.livelyeko.cubethmod.networking.CubethMessages;
import net.fabricmc.api.ClientModInitializer;

public class CubethModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        CubethMessages.registerS2CPackets();
    }
}
