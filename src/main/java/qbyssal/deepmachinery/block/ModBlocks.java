package qbyssal.deepmachinery.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import qbyssal.deepmachinery.DeepMachinery;
import qbyssal.deepmachinery.fluid.ModFluids;

public class ModBlocks {
    public static final Block CHROMIUM_BLOCK = registerBlock("chromium_block",new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block FERROCHROMIUM_ALLOY_BLOCK = registerBlock("ferrochromium_alloy_block",new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block TUNGSTEN_BLOCK = registerBlock("tungsten_block",new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block CRUCIBLE = registerBlock("crucible", new CrucibleBlock(FabricBlockSettings.copyOf(Blocks.CAULDRON)));

    public static Block registerBlock(String name, Block block){
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK,new Identifier(DeepMachinery.MOD_ID,name),block);
    }
    public static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM,new Identifier(DeepMachinery.MOD_ID,name),new BlockItem(block,new FabricItemSettings()));
    }

    public static void registerBlocks(){
        DeepMachinery.LOGGER.info("Registering mod blocks for "+ DeepMachinery.MOD_ID);
    }
}
