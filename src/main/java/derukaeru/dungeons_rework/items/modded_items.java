package derukaeru.dungeons_rework.items;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import derukaeru.dungeons_rework.DungeonsRework;

public class modded_items {
    public static final Item lock = register_item("lock", new Item.Settings());
    public static final Item key = register_item("key", new Item.Settings());

    private static Item register_item(String name, Item.Settings itemSettings) {
        Identifier id = Identifier.of(DungeonsRework.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item.Settings settings = itemSettings.registryKey(key);

        return Registry.register(Registries.ITEM, key, new Item(settings));
    }

    public static void initialize_items() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(lock);
            entries.add(key);
        });
    }
}