package me.livelyeko.cubethmod.block;

import me.livelyeko.cubethmod.CubethMod;
import me.livelyeko.cubethmod.block.dinnerware.GlassCup;
import me.livelyeko.cubethmod.block.dinnerware.GlassPlate;
import me.livelyeko.cubethmod.block.food.pastry.BundtCake;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CubethBlocks {

    public static final Block GLASS_CUP = new GlassCup(
            AbstractBlock.Settings.create().noBlockBreakParticles().strength(0.0f));
    public static final Block GLASS_PLATE = new GlassPlate(
            AbstractBlock.Settings.create().noBlockBreakParticles().strength(0.0f), 0);
    public static final Block GLASS_PLATE_OF_SLICED_CAKE = new GlassPlate(
            AbstractBlock.Settings.create().noBlockBreakParticles().strength(0.0f), 1);

    public static final Block BUNDT_CAKE = new BundtCake(AbstractBlock.Settings.create().strength(1f));

    // private static <T extends Block> T register(String id, T block)
    // {
    // Identifier guid = Identifier.of(CubethMod.MOD_ID, id);
    // Registry.register(Registries.BLOCK, guid, block);
    // Registry.register(Registries.ITEM, guid, new BlockItem(block, new
    // Item.Settings()));
    // BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
    // return block;
    // }

    public static void initialize() {
        // Glass Cup Registry
        ItemGroupEvents.modifyEntriesEvent(CubethMod.CUBETH_KEY).register((itemGroup) -> {
            itemGroup.add(CubethBlocks.GLASS_CUP.asItem());
        });
        Registry.register(Registries.ITEM, Identifier.of(CubethMod.MOD_ID, "glass_cup"),
                new me.livelyeko.cubethmod.item.dinnerware.GlassCup(GLASS_CUP, new Item.Settings()));
        Registry.register(Registries.BLOCK, Identifier.of(CubethMod.MOD_ID, "glass_cup"), GLASS_CUP);
        //BlockRenderLayerMap.INSTANCE.putBlock(GLASS_CUP, RenderLayer.getCutout());

        // Glass Plate Registry
        ItemGroupEvents.modifyEntriesEvent(CubethMod.CUBETH_KEY).register((itemGroup) -> {
            itemGroup.add(CubethBlocks.GLASS_PLATE.asItem());
        });
        Registry.register(Registries.ITEM, Identifier.of(CubethMod.MOD_ID, "glass_plate"),
                new me.livelyeko.cubethmod.item.dinnerware.GlassPlate(GLASS_PLATE, new Item.Settings()));
        Registry.register(Registries.BLOCK, Identifier.of(CubethMod.MOD_ID, "glass_plate"), GLASS_PLATE);
        //BlockRenderLayerMap.INSTANCE.putBlock(GLASS_PLATE, RenderLayer.getCutout());

        // Plate of Sliced Cake Registry
        ItemGroupEvents.modifyEntriesEvent(CubethMod.CUBETH_KEY).register((itemGroup) -> {
            itemGroup.add(CubethBlocks.GLASS_PLATE_OF_SLICED_CAKE.asItem());
        });
        Registry.register(Registries.ITEM, Identifier.of(CubethMod.MOD_ID, "glass_plate_of_sliced_cake"),
                new me.livelyeko.cubethmod.item.dinnerware.GlassPlateOfSlicedCake(GLASS_PLATE_OF_SLICED_CAKE,
                        new Item.Settings().maxCount(1)));
        Registry.register(Registries.BLOCK, Identifier.of(CubethMod.MOD_ID, "glass_plate"), GLASS_PLATE_OF_SLICED_CAKE);
        //BlockRenderLayerMap.INSTANCE.putBlock(GLASS_PLATE_OF_SLICED_CAKE, RenderLayer.getCutout());

        // Bundt Cake
        ItemGroupEvents.modifyEntriesEvent(CubethMod.CUBETH_KEY).register((itemGroup) -> {
            itemGroup.add(CubethBlocks.BUNDT_CAKE.asItem());
        });
        Registry.register(Registries.ITEM, Identifier.of(CubethMod.MOD_ID, "bundt_cake"),
                new me.livelyeko.cubethmod.item.food.pastry.BundtCake(BUNDT_CAKE, new Item.Settings().maxCount(1)));
        Registry.register(Registries.BLOCK, Identifier.of(CubethMod.MOD_ID, "bundt_cake"), BUNDT_CAKE);
    }
}