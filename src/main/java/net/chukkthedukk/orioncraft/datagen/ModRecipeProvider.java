package net.chukkthedukk.orioncraft.datagen;

import net.chukkthedukk.orioncraft.block.ModBlocks;
import net.chukkthedukk.orioncraft.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> PLATINUM_SMELTABLES = List.of(ModItems.RAW_PLATINUM, ModBlocks.PLATINUM_ORE, ModBlocks.DEEPSLATE_PLATINUM_ORE);
    private static final List<ItemConvertible> JADE_SMELTABLES = List.of(ModBlocks.JADE_ORE, ModBlocks.DEEPSLATE_JADE_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, PLATINUM_SMELTABLES, RecipeCategory.MISC, ModItems.PLATINUM_INGOT,
                0.7f, 200, "platinum");
        offerBlasting(exporter, PLATINUM_SMELTABLES, RecipeCategory.MISC, ModItems.PLATINUM_INGOT,
                0.7f, 100, "platinum");
        offerSmelting(exporter, JADE_SMELTABLES, RecipeCategory.MISC, ModItems.JADE,
                0.7f, 200, "jade");
        offerBlasting(exporter, JADE_SMELTABLES, RecipeCategory.MISC, ModItems.JADE,
                0.7f, 100, "jade");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MJ_DEFAULT, 1)
                .pattern("JQ")
                .pattern("JQ")
                .input('J', ModItems.JADE)
                .input('Q', Items.QUARTZ)
                .criterion(hasItem(ModItems.JADE), conditionsFromItem(ModItems.JADE))
                .criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.MJ_DEFAULT)));

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.JADE, RecipeCategory.DECORATIONS, ModBlocks.JADE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PLATINUM_INGOT, RecipeCategory.DECORATIONS, ModBlocks.PLATINUM_BLOCK);
    }
}
