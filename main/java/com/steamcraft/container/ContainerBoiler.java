package com.steamcraft.container;

import com.steamcraft.item.SteamCraftItem;
import com.steamcraft.tileentity.TileEntityBoiler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerBoiler extends Container
{
    private final int PLAYER_INVENTORY_ROWS = 3;
    private final int PLAYER_INVENTORY_COLUMNS = 9;
    private TileEntityBoiler tileEntityAludel;
    private int lastDeviceCookTime;
    private int lastFuelBurnTime;
    private int lastItemCookTime;

    public ContainerBoiler(InventoryPlayer inventoryPlayer, TileEntityBoiler tileEntityAludel)
    {
        
    }

    @Override
    public void addCraftingToCrafters(ICrafting iCrafting)
    {

    }

    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex)
    {
//        ItemStack itemStack = null;
//        Slot slot = (Slot) inventorySlots.get(slotIndex);
//
//        if (slot != null && slot.getHasStack())
//        {
//            ItemStack slotItemStack = slot.getStack();
//            itemStack = slotItemStack.copy();
//
//            /**
//             * If we are shift-clicking an item out of the Aludel's container,
//             * attempt to put it in the first available slot in the player's
//             * inventory
//             */
//            if (slotIndex < TileEntityAludel.INVENTORY_SIZE)
//            {
//                if (!this.mergeItemStack(slotItemStack, TileEntityAludel.INVENTORY_SIZE, inventorySlots.size(), false))
//                {
//                    return null;
//                }
//            }
//            else
//            {
//                /**
//                 * If the stack being shift-clicked into the Aludel's container
//                 * is a fuel, first try to put it in the fuel slot. If it cannot
//                 * be merged into the fuel slot, try to put it in the input
//                 * slot.
//                 */
//                if (TileEntityFurnace.isItemFuel(slotItemStack))
//                {
//                    if (!this.mergeItemStack(slotItemStack, TileEntityAludel.FUEL_INVENTORY_INDEX, TileEntityAludel.OUTPUT_INVENTORY_INDEX, false))
//                    {
//                        return null;
//                    }
//                }
//
//                /**
//                 * If the stack being shift-clicked into the Aludel's container
//                 * is a dust, first try to put it in the dust slot. If it cannot
//                 * be merged into the dust slot, try to put it in the input
//                 * slot.
//                 */
//                else if (slotItemStack.getItem() instanceof ItemAlchemicalDust)
//                {
//                    if (!this.mergeItemStack(slotItemStack, TileEntityAludel.DUST_INVENTORY_INDEX, TileEntityAludel.OUTPUT_INVENTORY_INDEX, false))
//                    {
//                        return null;
//                    }
//                }
//
//                /**
//                 * Finally, attempt to put stack into the input slot
//                 */
//                else if (!this.mergeItemStack(slotItemStack, TileEntityAludel.INPUT_INVENTORY_INDEX, TileEntityAludel.DUST_INVENTORY_INDEX, false))
//                {
//                    return null;
//                }
//            }
//
//            if (slotItemStack.stackSize == 0)
//            {
//                slot.putStack(null);
//            }
//            else
//            {
//                slot.onSlotChanged();
//            }
//        }
//
        return new ItemStack(SteamCraftItem.brassBallBearing, 0);
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int valueType, int updatedValue)
    {
        
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer)
    {
        return true;
    }

}
