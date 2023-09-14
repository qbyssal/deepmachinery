package qbyssal.deepmachinery.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import qbyssal.deepmachinery.block.ModBlocks;
import qbyssal.deepmachinery.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> CHROMIUM_SMELTABLES = List.of(ModItems.RAW_CHROMIUM);
    private static final List<ItemConvertible> TUNGSTEN_SMELTABLES = List.of(ModItems.RAW_TUNGSTEN);
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter,CHROMIUM_SMELTABLES, RecipeCategory.MISC,ModItems.CHROMIUM_INGOT, 0.7F,200,"chromium");
        offerBlasting(exporter,CHROMIUM_SMELTABLES, RecipeCategory.MISC,ModItems.CHROMIUM_INGOT, 0.7F,100,"chromium");

        offerSmelting(exporter,TUNGSTEN_SMELTABLES, RecipeCategory.MISC,ModItems.TUNGSTEN_INGOT, 0.7F,200,"tungsten");
        offerBlasting(exporter,TUNGSTEN_SMELTABLES, RecipeCategory.MISC,ModItems.TUNGSTEN_INGOT, 0.7F,100,"tungsten");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC,ModItems.TUNGSTEN_INGOT,RecipeCategory.MISC, ModBlocks.TUNGSTEN_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC,ModItems.CHROMIUM_INGOT,RecipeCategory.MISC, ModBlocks.CHROMIUM_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC,ModItems.FERROCHROMIUM_ALLOY_INGOT,RecipeCategory.MISC, ModBlocks.FERROCHROMIUM_ALLOY_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.CRUCIBLE,1)
                .pattern("T T")
                .pattern("TBT")
                .pattern("TTT")
                .input('T',ModItems.TUNGSTEN_INGOT)
                .input('B', Items.BUCKET)
                .criterion(hasItem(ModItems.TUNGSTEN_INGOT),conditionsFromItem(ModItems.TUNGSTEN_INGOT))
                .offerTo(exporter,new Identifier(getRecipeName(ModBlocks.CRUCIBLE)));
    }
}
