package net.chukkthedukk.orioncraft.item;

import net.chukkthedukk.orioncraft.Orioncraft;

import net.chukkthedukk.orioncraft.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup ORION_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Orioncraft.MOD_ID, "orion"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.orion"))
                    .icon(() -> new ItemStack(ModItems.PLATINUM_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_PLATINUM);
                        entries.add(ModItems.PLATINUM_NUGGET);
                        entries.add(ModItems.PLATINUM_INGOT);
                        entries.add(ModBlocks.PLATINUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_PLATINUM_ORE);
                        entries.add(ModBlocks.RAW_PLATINUM_BLOCK);
                        entries.add(ModBlocks.PLATINUM_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        Orioncraft.LOGGER.info("Registering Item Groups for Orioncraft");
    }
}
