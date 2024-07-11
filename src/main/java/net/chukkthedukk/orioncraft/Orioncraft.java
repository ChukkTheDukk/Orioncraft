package net.chukkthedukk.orioncraft;

import net.chukkthedukk.orioncraft.item.ModItemGroups;
import net.chukkthedukk.orioncraft.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Orioncraft implements ModInitializer {
	public static final String MOD_ID = "orioncraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
	}
}