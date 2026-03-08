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

public class ModItems {
    public static final Item lock = register_item(
            "lock",
            new LockItem(new Item.Settings().registryKey(
                    RegistryKey.of(RegistryKeys.ITEM, Identifier.of(DungeonsRework.MOD_ID, "lock"))
            ))
    );

    public static final Item key = register_item(
            "key",
            new KeyItem(new Item.Settings().registryKey(
                    RegistryKey.of(RegistryKeys.ITEM, Identifier.of(DungeonsRework.MOD_ID, "key"))
            ))
    );
    private static Item register_item(String name, Item item) {
        Identifier id = Identifier.of(DungeonsRework.MOD_ID, name);

        return Registry.register(
                Registries.ITEM,
                RegistryKey.of(RegistryKeys.ITEM, id),
                item
        );
    }

    public static void initialize_items() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(lock);
            entries.add(key);
        });
    }
}