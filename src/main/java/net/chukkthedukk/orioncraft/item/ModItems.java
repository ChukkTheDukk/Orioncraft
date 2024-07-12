package net.chukkthedukk.orioncraft.item;

import net.chukkthedukk.orioncraft.Orioncraft;
import net.chukkthedukk.orioncraft.entity.ModEntities;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RAW_PLATINUM = registerItem("raw_platinum", new Item(new FabricItemSettings()));
    public static final Item PLATINUM_NUGGET = registerItem("platinum_nugget", new Item(new FabricItemSettings()));
    public static final Item PLATINUM_INGOT = registerItem("platinum_ingot", new Item(new FabricItemSettings()));
    public static final Item HEELER_SPAWN_EGG = registerItem("heeler_spawn_egg", new SpawnEggItem(ModEntities.HEELER, 0x6e6e6e, 0xCC6920, new FabricItemSettings()));

    private static void addItemstoIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(RAW_PLATINUM);
        entries.add(PLATINUM_NUGGET);
        entries.add(PLATINUM_INGOT);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Orioncraft.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Orioncraft.LOGGER.info("Registering Mod Items for Orioncraft");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemstoIngredientItemGroup);
    }
}
