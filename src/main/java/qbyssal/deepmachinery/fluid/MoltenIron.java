package qbyssal.deepmachinery.fluid;

import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;

public class MoltenIron extends MoltenFluid{
    @Override
    public int getTint(){
        return 0xbb0000;
    }

    @Override
    public FlowableFluid getStill() {
        return ModFluids.MOLTEN_IRON;
    }

    @Override
    public FlowableFluid getFlowing() {
        return ModFluids.FLOWING_MOLTEN_IRON;
    }

    @Override
    public Item getBucketItem() {
        return ModFluids.MOLTEN_IRON_BUCKET;
    }

    @Override
    public BlockState toBlockState(FluidState state) {
        return ModFluids.MOLTEN_IRON_BLOCK.getDefaultState().with(FluidBlock.LEVEL, getBlockStateLevel(state));
    }

    public static class Still extends MoltenIron {
        public boolean isStill(FluidState state) {
            return true;
        }
    }

    public static class Flowing extends MoltenIron {
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }
    }
}
