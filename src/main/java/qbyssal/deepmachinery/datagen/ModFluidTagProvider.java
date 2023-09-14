package qbyssal.deepmachinery.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;
import qbyssal.deepmachinery.block.ModBlocks;
import qbyssal.deepmachinery.fluid.ModFluids;

import java.util.concurrent.CompletableFuture;

public class ModFluidTagProvider extends FabricTagProvider.FluidTagProvider {
    public ModFluidTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(FluidTags.LAVA)
                .add(ModFluids.MOLTEN_CHROMIUM)
                .add(ModFluids.FLOWING_MOLTEN_CHROMIUM)
                .add(ModFluids.MOLTEN_FERROCHROMIUM)
                .add(ModFluids.FLOWING_MOLTEN_FERROCHROMIUM)
                .add(ModFluids.MOLTEN_IRON)
                .add(ModFluids.FLOWING_MOLTEN_IRON)
                ;
    }
}
