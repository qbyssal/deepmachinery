package qbyssal.deepmachinery.block.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import qbyssal.deepmachinery.item.ModItems;
import qbyssal.deepmachinery.screen.CrucibleScreenHandler;


public class CrucibleBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3,ItemStack.EMPTY);

    private int progress=0;
    private int maxProgess=50;
    protected final PropertyDelegate propertyDelegate;

    public CrucibleBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CRUCIBLE, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> CrucibleBlockEntity.this.progress;
                    case 1 -> CrucibleBlockEntity.this.maxProgess;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch(index){
                    case 0 -> CrucibleBlockEntity.this.progress = value;
                    case 1 -> CrucibleBlockEntity.this.maxProgess = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("to be removed");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new CrucibleScreenHandler(syncId,playerInventory,this,this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt,inventory);
        super.writeNbt(nbt);
        nbt.putInt("crucible.progess",progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt,inventory);
        super.readNbt(nbt);
        nbt.getInt("crucible.progress");
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, CrucibleBlockEntity entity) {
        if(world.isClient()){
            return;
        }

        if(hasRecipe(entity)){
            entity.progress++;
            markDirty(world,blockPos,state);
            if(entity.progress >= entity.maxProgess){
                craftItem(entity);
                entity.resetProgress();
            }
        }else{
            entity.resetProgress();
            markDirty(world,blockPos,state);
        }
    }

    private void resetProgress() {
        this.progress=0;
    }

    private static void craftItem(CrucibleBlockEntity entity){
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for(int i = 0; i<entity.size(); i++){
            inventory.setStack(i,entity.getStack(i));
        }

        entity.removeStack(0,1);
        entity.removeStack(1,1);

        entity.setStack(2,new ItemStack(ModItems.ROUGH_FERROCHROMIUM_ALLOY, entity.getStack(2).getCount()+1));
    }

    private static boolean hasRecipe(CrucibleBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for(int i = 0; i<entity.size(); i++){
            inventory.setStack(i,entity.getStack(i));
        }

        boolean hasIron = entity.getStack(0).getItem()== Items.IRON_INGOT;
        boolean hasChromium = entity.getStack(1).getItem()== ModItems.CHROMIUM_INGOT;

        return hasIron && hasChromium && canInsertIntoOutputSlot(inventory,1) && canInsertItemIntoOutputSlot(inventory, ModItems.ROUGH_FERROCHROMIUM_ALLOY);
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item item) {
        return inventory.getStack(2).getItem()==item || inventory.getStack(2).isEmpty();
    }

    private static boolean canInsertIntoOutputSlot(SimpleInventory inventory, int count) {
        return inventory.getStack(2).getMaxCount() >= inventory.getStack(2).getCount()+count;
    }
}
