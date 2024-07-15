package net.chukkthedukk.orioncraft.block;

import net.chukkthedukk.orioncraft.Orioncraft;
import net.chukkthedukk.orioncraft.block.custom.MahjongBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block PLATINUM_ORE = registerBlock("platinum_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f), UniformIntProvider.create(3, 8)));
    public static final Block DEEPSLATE_PLATINUM_ORE = registerBlock("deepslate_platinum_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(3.5f), UniformIntProvider.create(3, 8)));
    public static final Block RAW_PLATINUM_BLOCK = registerBlock("raw_platinum_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_GOLD_BLOCK)));
    public static final Block PLATINUM_BLOCK = registerBlock("platinum_block",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));

    public static final Block JADE_ORE = registerBlock("jade_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f), UniformIntProvider.create(2, 5)));
    public static final Block DEEPSLATE_JADE_ORE = registerBlock("deepslate_jade_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(3.5f), UniformIntProvider.create(2, 5)));
    public static final Block JADE_BLOCK = registerBlock("jade_block",
            new Block(FabricBlockSettings.copyOf(Blocks.LAPIS_BLOCK)));

    public static final Block MJ_DEFAULT = registerBlock("mj_default", new MahjongBlock(FabricBlockSettings.copyOf(Blocks.DIORITE).nonOpaque()));
    public static final Block MJ_EAST = registerBlock("mj_east", new MahjongBlock(FabricBlockSettings.copyOf(Blocks.DIORITE).nonOpaque()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Orioncraft.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Orioncraft.MOD_ID, name),
            new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Orioncraft.LOGGER.info("Registering Mod Blocks for Orioncraft");
    }
}
