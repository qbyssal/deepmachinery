package qbyssal.deepmachinery.fluid;

import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

public class MoltenChromium extends MoltenFluid{
    @Override
    public int getTint(){
        return 0xffffff;
    }
    @Override
    public FlowableFluid getStill() {
        return ModFluids.MOLTEN_CHROMIUM;
    }

    @Override
    public FlowableFluid getFlowing() {
        return ModFluids.FLOWING_MOLTEN_CHROMIUM;
    }

    @Override
    public Item getBucketItem() {
        return ModFluids.MOLTEN_CHROMIUM_BUCKET;
    }

    @Override
    public BlockState toBlockState(FluidState state) {
        return ModFluids.MOLTEN_CHROMIUM_BLOCK.getDefaultState().with(FluidBlock.LEVEL, getBlockStateLevel(state));
    }

    public static class Still extends MoltenChromium{
        public boolean isStill(FluidState state) {
            return true;
        }
    }

    public static class Flowing extends MoltenChromium{
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }
    }
}
