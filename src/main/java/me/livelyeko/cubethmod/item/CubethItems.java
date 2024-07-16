package me.livelyeko.cubethmod.item;

import me.livelyeko.cubethmod.CubethMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class CubethItems {
    public static Item register(Item item, String id) {
        // Create the identifier for the item.
        Identifier itemID = Identifier.of(CubethMod.MOD_ID, id);

        // Return the registered item!
        return Registry.register(Registries.ITEM, itemID, item);
    }

    /*
    public static final Item GLASS_CUP = register(
            new GlassCupBlockItem(new GlassCupBlock(AbstractBlock.Settings.create()), new Item.Settings()),
        "glass_cup"
    );
*/
    public static void initialize() {
        /*
        ItemGroupEvents.modifyEntriesEvent(CubethMod.CUBETH_KEY).register(entries -> {
            entries.add(CubethItems.GLASS_CUP.asItem());
        });

         */
    }
}
