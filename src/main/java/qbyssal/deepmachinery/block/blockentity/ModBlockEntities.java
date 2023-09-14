package qbyssal.deepmachinery.block.blockentity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import qbyssal.deepmachinery.DeepMachinery;
import qbyssal.deepmachinery.block.ModBlocks;

public class ModBlockEntities {
    public static final BlockEntityType<CrucibleBlockEntity> CRUCIBLE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            new Identifier(DeepMachinery.MOD_ID,"crucible"),
            FabricBlockEntityTypeBuilder.create(CrucibleBlockEntity::new, ModBlocks.CRUCIBLE).build(null)
    );

    public static void registerBlockEntities(){
        DeepMachinery.LOGGER.info("Registering block entities for " + DeepMachinery.MOD_ID);
    }
}
