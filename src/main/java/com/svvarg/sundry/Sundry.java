package com.svvarg.sundry;

//import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;

@Mod(modid = Sundry.MODID, version = Sundry.VERSION)
public class Sundry {

    public static final String MODID = "svvarg_sundry_tfc_addon";
    public static final String VERSION = "0.1";
    public static Item key;
    public static Item samdust;
    private static Item samingot;
    
    private static ItemFood berry;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        key = new ItemKey();        
        GameRegistry.registerItem(key, "Key");
        
        samdust = new ItemSamGeneric("samdust");
        samingot = new ItemSamGeneric("samingot");
        GameRegistry.registerItem(samdust, "SamDust");
        GameRegistry.registerItem(samingot, "SamIngot");
        
        berry = new ItemBerry(3, 0.3F, true, "Berry");
        GameRegistry.registerItem(berry, "Berry");
    }

    

    @EventHandler
    public void init(FMLInitializationEvent event) {
        //System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
        GameRegistry.addRecipe(new ItemStack(Items.apple),
                "XXX", "XXX", "XXX", 'X', Blocks.leaves);

        ItemStack enchantedSwordItemStack = new ItemStack(Items.stone_sword);
        enchantedSwordItemStack.addEnchantment(Enchantment.sharpness, 1);
        GameRegistry.addShapelessRecipe(enchantedSwordItemStack, Items.flint, Items.stone_sword);
    
    }
}
