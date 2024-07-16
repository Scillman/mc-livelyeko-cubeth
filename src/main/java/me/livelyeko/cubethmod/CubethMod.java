package me.livelyeko.cubethmod;

import me.livelyeko.cubethmod.block.CubethBlocks;
import me.livelyeko.cubethmod.item.CubethItems;
import me.livelyeko.cubethmod.networking.CubethMessages;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CubethMod implements ModInitializer {

    // ID and logger
    public static final String MOD_ID = "cubethmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Custom Item Group
    public static final RegistryKey<ItemGroup> CUBETH_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of("cubethmod", "item_group"));
    public static final ItemGroup CUBETH = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Items.BEACON))
            .displayName(Text.of("Cubeth Assets"))
            .noScrollbar()
            .build();

    @Override
    public void onInitialize() {

        Registry.register(Registries.ITEM_GROUP, CUBETH_KEY, CUBETH);

        CubethItems.initialize();
        CubethBlocks.initialize();

      //  PayloadTypeRegistry.playC2S().register();
    }
}