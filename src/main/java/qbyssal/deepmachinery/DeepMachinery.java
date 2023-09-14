package qbyssal.deepmachinery;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qbyssal.deepmachinery.block.ModBlocks;
import qbyssal.deepmachinery.block.blockentity.ModBlockEntities;
import qbyssal.deepmachinery.fluid.ModFluids;
import qbyssal.deepmachinery.item.ModItemGroups;
import qbyssal.deepmachinery.item.ModItems;
import qbyssal.deepmachinery.screen.ModScreenHandlers;

public class DeepMachinery implements ModInitializer {
	public static final String MOD_ID = "deepmachinery";
    public static final Logger LOGGER = LoggerFactory.getLogger("deepmachinery");

	@Override
	public void onInitialize() {
		ModBlocks.registerBlocks();
		ModItems.registerItems();
		ModItemGroups.registerItemGroups();
		ModFluids.registerFluids();
		ModBlockEntities.registerBlockEntities();
	}
}