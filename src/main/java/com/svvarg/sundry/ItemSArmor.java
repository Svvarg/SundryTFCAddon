/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svvarg.sundry;

/**
 *
 * @author Swarg
 */
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import com.svvarg.sundry.Sundry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ItemSArmor extends ItemArmor {

    public ItemSArmor(ArmorMaterial material, int armorType, String name) {
        super(material, 0, armorType);
        setUnlocalizedName(Sundry.MODID + "_" + name);
        setTextureName(Sundry.MODID + ":" + name);
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if (stack.getItem() == Sundry.shelmet || stack.getItem() == Sundry.schest
                || stack.getItem() == Sundry.sboots) {
            return Sundry.MODID + ":models/armor/sarmor1.png";
        } else if (stack.getItem() == Sundry.sleggings) {
            return Sundry.MODID + ":models/armor/sarmor2.png";
        } else {
            System.out.println("Invalid Item");
            return null;
        }
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (itemStack.getItem() == Sundry.shelmet) {
            if (player.isInWater()) {
                player.setAir(20);
            }
        }
    }

}
