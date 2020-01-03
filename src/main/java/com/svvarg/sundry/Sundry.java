package com.svvarg.sundry;

//import net.minecraft.entity.Entity;
//import com.bioxx.tfc.api.TFCItems;
import com.svvarg.sundry.lootchest.BlockLootChestTE;
import com.svvarg.sundry.lootchest.GuiLootChestHandler;
import com.svvarg.sundry.lootchest.TileEntityLootChest;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;


@Mod(modid = Sundry.MODID, version = Sundry.VERSION)
public class Sundry {
    
    @Instance("Sundry")
    public static Sundry instance;

    public static final String MODID = "svvarg_sundry_tfc_addon";
    public static final String VERSION = "0.1";
    public static Item key;
    public static Item samdust;
    private static Item samingot;

    public static ItemFood berry;

    public static Item titaniumpickaxe;
    ToolMaterial titanium = EnumHelper.addToolMaterial("titanium", 3, 1000, 9.5F, 3.5F, 10);

    private static Item sampaxel;

    //armor
    public static Item shelmet;
    public static Item schest;
    public static Item sleggings;
    public static Item sboots;
    
    public static Block sStone;
        
    public static Block sPlant;    
    public static Item sSeed;
    
    public static Block sTE;
    
    public static Block lootChestTE;
    
    SundryEventHandler handler = new SundryEventHandler();
   

    ArmorMaterial sarmor = EnumHelper.addArmorMaterial("sarmor", 20, new int[]{3, 7, 6, 3}, 10);

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

        titaniumpickaxe = new ItemTitaniumPickaxe(titanium, "titaniumpickaxe");
        GameRegistry.registerItem(titaniumpickaxe, "TitaniumPickaxe");

        sampaxel = new ItemSamPaxel(titanium, "sampaxel");
        GameRegistry.registerItem(sampaxel, "SamsPaxel");

        shelmet = new ItemSArmor(sarmor, 0, "shelmet");
        schest = new ItemSArmor(sarmor, 1, "schestplate");
        sleggings = new ItemSArmor(sarmor, 2, "sleggings");
        sboots = new ItemSArmor(sarmor, 3, "sboots");
        GameRegistry.registerItem(shelmet, "SHelmet");
        GameRegistry.registerItem(schest, "SChest");
        GameRegistry.registerItem(sleggings, "SLeggings");
        GameRegistry.registerItem(sboots, "SBooths");
        
        sStone = new BlockSStone();
        //GameRegistry.registerBlock(sStone, "SStone"); //normal register method without use meta
        GameRegistry.registerBlock(sStone, ItemSStone.class, "SStone");//for metadata
        //внутри класса ItemSStone указание что этот класс использует субмету
        //возврат меты для блока при ломании
        //возврат неЛокализованных имён
        
        sPlant = new BlockSPlant();
        GameRegistry.registerBlock(sPlant,"Sundry Plant");//reg method as without meta
        
        sSeed = new ItemSSeed(sPlant);
        GameRegistry.registerItem(sSeed, "SSeed");
        
        sTE = new BlockSTE();
        GameRegistry.registerBlock(sTE, "SundryTE");
        GameRegistry.registerTileEntity(TileEntitySundry.class, "TE_sundryTE");
        
        lootChestTE = new BlockLootChestTE();
        GameRegistry.registerBlock(lootChestTE, "LootChestTEBlock");
        GameRegistry.registerTileEntity(TileEntityLootChest.class, "TELootChest");
        
        
        
        GameRegistry.registerWorldGenerator(handler,0);        
        OreDictionary.registerOre("ingotSam", new ItemStack(samingot));
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        //System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
        GameRegistry.addRecipe(new ItemStack(Items.apple),
                "XXX", "XXX", "XXX", 'X', Blocks.leaves);

        ItemStack enchantedSwordItemStack = new ItemStack(Items.stone_sword);
        enchantedSwordItemStack.addEnchantment(Enchantment.sharpness, 1);
        GameRegistry.addShapelessRecipe(enchantedSwordItemStack, Items.flint, Items.stone_sword);

        Sundry.instance = this;
        NetworkRegistry.INSTANCE.registerGuiHandler(Sundry.instance, new GuiLootChestHandler());
        
        GameRegistry.addRecipe(new ShapedOreRecipe(Sundry.sampaxel,
        "XXX",
        " Y ",
        " Y ",
        'X',"ingotSam", 'Y', Items.stick
        ));
    }
}
