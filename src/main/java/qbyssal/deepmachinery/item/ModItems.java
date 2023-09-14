package qbyssal.deepmachinery.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import qbyssal.deepmachinery.DeepMachinery;
import qbyssal.deepmachinery.fluid.ModFluids;

public class ModItems {
    public static final Item RAW_CHROMIUM = registerItem("raw_chromium",new Item(new FabricItemSettings()));
    public static final Item CHROMIUM_INGOT = registerItem("chromium_ingot",new Item(new FabricItemSettings()));
    public static final Item ROUGH_FERROCHROMIUM_ALLOY = registerItem("rough_ferrochromium_alloy",new Item(new FabricItemSettings()));
    public static final Item FERROCHROMIUM_ALLOY_INGOT = registerItem("ferrochromium_alloy_ingot",new Item(new FabricItemSettings()));
    public static final Item TUNGSTEN_INGOT = registerItem("tungsten_ingot",new Item(new FabricItemSettings()));
    public static final Item RAW_TUNGSTEN = registerItem("raw_tungsten",new Item(new FabricItemSettings()));



    public static void registerItems(){
        DeepMachinery.LOGGER.info("Registering items for" + DeepMachinery.MOD_ID);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(DeepMachinery.MOD_ID,name),item);
    }
}
