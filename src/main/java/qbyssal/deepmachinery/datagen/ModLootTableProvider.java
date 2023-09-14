package qbyssal.deepmachinery.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import qbyssal.deepmachinery.block.ModBlocks;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CHROMIUM_BLOCK);
        addDrop(ModBlocks.FERROCHROMIUM_ALLOY_BLOCK);
        addDrop(ModBlocks.CRUCIBLE);
    }
}
