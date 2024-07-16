package me.livelyeko.cubethmod.block;

import me.livelyeko.cubethmod.CubethMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class CubethBlocks {

    public static final Block GLASS_CUP = new GlassCup(AbstractBlock.Settings.create().noBlockBreakParticles().sounds(BlockSoundGroup.GLASS).strength(0.0f));
    public static final Block GLASS_PLATE = new GlassPlate(AbstractBlock.Settings.create().noBlockBreakParticles().sounds(BlockSoundGroup.GLASS).strength(0.0f));

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(CubethMod.CUBETH_KEY).register((itemGroup) -> {
            itemGroup.add(CubethBlocks.GLASS_CUP.asItem());
        });
        Registry.register(Registries.ITEM, Identifier.of(CubethMod.MOD_ID, "glass_cup"), new me.livelyeko.cubethmod.item.GlassCup(GLASS_CUP, new Item.Settings()));
        Registry.register(Registries.BLOCK, Identifier.of(CubethMod.MOD_ID, "glass_cup"), GLASS_CUP);

        ItemGroupEvents.modifyEntriesEvent(CubethMod.CUBETH_KEY).register((itemGroup) -> {
            itemGroup.add(CubethBlocks.GLASS_PLATE.asItem());
        });
        Registry.register(Registries.ITEM, Identifier.of(CubethMod.MOD_ID, "glass_plate"), new me.livelyeko.cubethmod.item.GlassPlate(GLASS_PLATE, new Item.Settings()));
        Registry.register(Registries.BLOCK, Identifier.of(CubethMod.MOD_ID, "glass_plate"), GLASS_PLATE);
    }
}