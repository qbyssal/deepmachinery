package qbyssal.deepmachinery.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import qbyssal.deepmachinery.DeepMachinery;
import qbyssal.deepmachinery.block.ModBlocks;
import qbyssal.deepmachinery.fluid.ModFluids;
import qbyssal.deepmachinery.item.ModItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FERROCHROMIUM_ALLOY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHROMIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TUNGSTEN_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.TUNGSTEN_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHROMIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.FERROCHROMIUM_ALLOY_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_CHROMIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_TUNGSTEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROUGH_FERROCHROMIUM_ALLOY, Models.GENERATED);

        itemModelGenerator.register(ModFluids.MOLTEN_CHROMIUM_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModFluids.MOLTEN_FERROCHROMIUM_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModFluids.MOLTEN_IRON_BUCKET, Models.GENERATED);
    }
}
