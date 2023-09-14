package qbyssal.deepmachinery.fluid;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.Optional;

public abstract class MoltenFluid extends FlowableFluid {
    abstract public int getTint();

    @Override
    abstract public FlowableFluid getFlowing();

    @Override
    abstract public FlowableFluid getStill();

    @Override
    abstract public Item getBucketItem();

    @Override
    public boolean isStill(FluidState state) {
        return false;
    }

    @Override
    public int getLevel(FluidState state) {
        return 8;
    }

    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == this.getStill() || fluid == this.getFlowing();
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return null;
    }

    @Override
    protected boolean isInfinite(World world) {
        return false;
    }

    @Override
    public Optional<SoundEvent> getBucketFillSound() {
        return Optional.of(SoundEvents.ITEM_BUCKET_FILL_LAVA);
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
    }

    @Override
    public int getFlowSpeed(WorldView world) {
        return 2;
    }

    @Override
    public int getLevelDecreasePerBlock(WorldView world) {
        return 2;
    }

    @Override
    public boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return false;
    }

    @Override
    public int getTickRate(WorldView world) {
        return 30;
    }

    @Override
    protected float getBlastResistance() {
        return 100.0F;
    }

    public abstract static class Still extends MoltenFluid{
        public int getLevel(FluidState state) {
            return 8;
        }

        public boolean isStill(FluidState state) {
            return true;
        }
    }

    public abstract static class Flowing extends MoltenFluid{
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }
    }
}
