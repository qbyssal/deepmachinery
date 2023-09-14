package qbyssal.deepmachinery.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class CrucibleScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;

    public CrucibleScreenHandler(int syncId, PlayerInventory inventory){
        this(syncId,inventory, new SimpleInventory(3),new ArrayPropertyDelegate(2));
    }

    public CrucibleScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate delegate) {
        super(ModScreenHandlers.CRUCIBLE_SCREEN_HANDLER, syncId);
        checkSize(inventory,3);
        this.propertyDelegate=delegate;
        this.inventory=inventory;
        inventory.onOpen(playerInventory.player);

        this.addSlot(new Slot(inventory, 0, 9,49));
        this.addSlot(new Slot(inventory, 1, 45,49));
        this.addSlot(new Slot(inventory, 2, 99,49));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(delegate);
    }

    public boolean isCrafting(){
        return propertyDelegate.get(0)>0;
    }

    public int getScaledProgress(){
        int progress = propertyDelegate.get(0);
        int maxProgress = propertyDelegate.get(1);
        int arrowSize=26;

        return maxProgress !=0 && progress !=0 ? progress * arrowSize / maxProgress : 0;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if(slot != null && slot.hasStack()){
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if(invSlot < this.inventory.size()){
                if(!this.insertItem(originalStack,this.inventory.size(),this.slots.size(),true));{
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack,0,this.inventory.size(),false)){
                return ItemStack.EMPTY;
            }

            if(originalStack.isEmpty()){
                slot.setStack(ItemStack.EMPTY);
            }else{
                slot.markDirty();
            }
        }

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory){
        for(int i=0; i<3; ++i){
            for(int j=0; j<9; ++j){
                this.addSlot(new Slot(playerInventory,j + i * 9+9,9 + j * 18, 85 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory){
        for(int i=0; i<9; i++){
            this.addSlot(new Slot(playerInventory, i, 9 + i * 18, 143));
        }
    }
}
