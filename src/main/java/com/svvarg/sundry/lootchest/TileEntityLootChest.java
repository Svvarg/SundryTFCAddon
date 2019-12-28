package com.svvarg.sundry.lootchest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

/**
 *
 * @author Swarg
 */
public class TileEntityLootChest extends TileEntity implements IInventory {
     private int SLOTCOUNT = 9;
     private ItemStack[] inventory = new ItemStack[SLOTCOUNT];

    @Override
    public int getSizeInventory() {
        return SLOTCOUNT;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return ( this.inventory != null && slot < this.inventory.length) ? this.inventory[slot]: null;
    }

    @Override
    public ItemStack decrStackSize(int p1, int p2) {
        //дефолтное копипаст из диспенсера
        if (this.inventory[p1] != null)
        {
            ItemStack itemstack;

            if (this.inventory[p1].stackSize <= p2)
            {
                itemstack = this.inventory[p1];
                this.inventory[p1] = null;
                this.markDirty();
                return itemstack;
            }
            else
            {
                itemstack = this.inventory[p1].splitStack(p2);

                if (this.inventory[p1].stackSize == 0)
                {
                    this.inventory[p1] = null;
                }

                this.markDirty();
                return itemstack;
            }
        }
        else
        {
            return null;
        }
        
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int p) {
      if (this.inventory[p] != null)
        {
            ItemStack itemstack = this.inventory[p];
            this.inventory[p] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int p, ItemStack is) {
      this.inventory[p] = is;

        if (is != null && is.stackSize > this.getInventoryStackLimit())
        {
            is.stackSize = this.getInventoryStackLimit();
        }

        this.markDirty();
    }

    @Override
    public String getInventoryName() {
      return "container.lootCheast";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return true;      
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;     
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory() {
     
    }

    @Override
    public void closeInventory() {
     
    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
        return true;     
    }
    
    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        NBTTagList nbttaglist = tag.getTagList("Items", 10);
        this.inventory = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 255;

            if (j >= 0 && j < this.inventory.length)
            {
                this.inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
    }

    public void writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.inventory.length; ++i)
        {
            if (this.inventory[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.inventory[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        tag.setTag("Items", nbttaglist);
    }
}
