package me.livelyeko.cubethmod.util;

import me.livelyeko.cubethmod.CubethMod;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class CubethTags {

    public static class Blocks {

    }

    public static class Items {
        public static final TagKey<Item> DINNERWARE = createTag("dinnerware");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(CubethMod.MOD_ID, name));
        }
    }
}
