package qbyssal.deepmachinery.fluid;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import qbyssal.deepmachinery.DeepMachinery;

public class ModFluids {
    public static MoltenFluid MOLTEN_CHROMIUM= registerFluid("molten_chromium",new MoltenChromium.Still());
    public static MoltenFluid FLOWING_MOLTEN_CHROMIUM = registerFluid("flowing_molten_chromium", new MoltenChromium.Flowing());
    public static Item MOLTEN_CHROMIUM_BUCKET = registerBucketItem("molten_chromium_bucket", new BucketItem(MOLTEN_CHROMIUM,new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));
    public static Block MOLTEN_CHROMIUM_BLOCK = registerBlock("molten_chromium", new FluidBlock(MOLTEN_CHROMIUM, FabricBlockSettings.copyOf(Blocks.LAVA)));

    public static MoltenFluid MOLTEN_FERROCHROMIUM= registerFluid("molten_ferrochromium",new MoltenFerrochromium.Still());
    public static MoltenFluid FLOWING_MOLTEN_FERROCHROMIUM = registerFluid("flowing_molten_ferrochromium", new MoltenFerrochromium.Flowing());
    public static Item MOLTEN_FERROCHROMIUM_BUCKET = registerBucketItem("molten_ferrochromium_bucket", new BucketItem(MOLTEN_FERROCHROMIUM,new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));
    public static Block MOLTEN_FERROCHROMIUM_BLOCK = registerBlock("molten_ferrochromium", new FluidBlock(MOLTEN_FERROCHROMIUM, FabricBlockSettings.copyOf(Blocks.LAVA)));

    public static MoltenFluid MOLTEN_IRON= registerFluid("molten_iron",new MoltenIron.Still());
    public static MoltenFluid FLOWING_MOLTEN_IRON = registerFluid("flowing_molten_iron", new MoltenIron.Flowing());
    public static Item MOLTEN_IRON_BUCKET = registerBucketItem("molten_iron_bucket", new BucketItem(MOLTEN_IRON,new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));
    public static Block MOLTEN_IRON_BLOCK = registerBlock("molten_iron", new FluidBlock(MOLTEN_IRON, FabricBlockSettings.copyOf(Blocks.LAVA)));


    private static Block registerBlock(String name, Block block){
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK,new Identifier(DeepMachinery.MOD_ID,name),block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM,new Identifier(DeepMachinery.MOD_ID,name),new BlockItem(block,new FabricItemSettings()));
    }

    private static <T extends MoltenFluid, U extends T> MoltenFluid registerFluid(String name, U fluid){
        return Registry.register(Registries.FLUID,new Identifier(DeepMachinery.MOD_ID,name),fluid);
    }

    private static Item registerBucketItem(String name, BucketItem item){
        return Registry.register(Registries.ITEM, new Identifier(DeepMachinery.MOD_ID,name),item);
    }

    public static void registerFluids(){
        DeepMachinery.LOGGER.info("Registering fluids for "+DeepMachinery.MOD_ID);
    }
}
