package qbyssal.deepmachinery.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import qbyssal.deepmachinery.DeepMachinery;
import qbyssal.deepmachinery.block.ModBlocks;
import qbyssal.deepmachinery.fluid.ModFluids;

public class ModItemGroups{
    public static final ItemGroup DEEP_MACHINERY_GROUP = Registry.register(
            Registries.ITEM_GROUP, new Identifier(DeepMachinery.MOD_ID,"deepmachinery"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.deepmachinery"))
                    .icon(()->new ItemStack(ModItems.RAW_CHROMIUM))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_TUNGSTEN);
                        entries.add(ModItems.RAW_CHROMIUM);
                        entries.add(ModItems.ROUGH_FERROCHROMIUM_ALLOY);
                        entries.add(ModItems.TUNGSTEN_INGOT);
                        entries.add(ModItems.CHROMIUM_INGOT);
                        entries.add(ModItems.FERROCHROMIUM_ALLOY_INGOT);
                        entries.add(ModFluids.MOLTEN_CHROMIUM_BUCKET);
                        entries.add(ModFluids.MOLTEN_FERROCHROMIUM_BUCKET);
                        entries.add(ModFluids.MOLTEN_IRON_BUCKET);
                        entries.add(ModBlocks.CHROMIUM_BLOCK);
                        entries.add(ModBlocks.FERROCHROMIUM_ALLOY_BLOCK);
                        entries.add(ModBlocks.TUNGSTEN_BLOCK);
                        entries.add(ModBlocks.CRUCIBLE);
                    })
                    .build()
            );

    public static void registerItemGroups() {
        DeepMachinery.LOGGER.info("Registering Item Groups for "+DeepMachinery.MOD_ID);
    }
}
