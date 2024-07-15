package net.chukkthedukk.orioncraft;

import net.chukkthedukk.orioncraft.block.ModBlocks;
import net.chukkthedukk.orioncraft.entity.ModEntities;
import net.chukkthedukk.orioncraft.entity.custom.HeelerEntity;
import net.chukkthedukk.orioncraft.item.ModItemGroups;
import net.chukkthedukk.orioncraft.item.ModItems;
import net.chukkthedukk.orioncraft.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Orioncraft implements ModInitializer {
	public static final String MOD_ID = "orioncraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModEntities.registerModEntities();
		ModWorldGen.generateWorldGen();
		//ModBlockEntities.registerBlockEntities();

		FabricDefaultAttributeRegistry.register(ModEntities.HEELER, HeelerEntity.createHeelerAttributes());
	}
}