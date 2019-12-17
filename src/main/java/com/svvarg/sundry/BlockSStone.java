package com.svvarg.sundry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

/**
 *
 * @author Swarg
 */
public class BlockSStone extends Block {
    String name = "sstone";
    
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;
    
    public BlockSStone() {
        super(Material.rock);
        setBlockName(Sundry.MODID+"_"+name);
        //setBlockTextureName(Sundry.MODID+":"+name); for use block with meta
        setCreativeTab(CreativeTabs.tabMisc);
        setHardness(2f);//-1.0Fдля бедрока - не ломаемый); как долго ломать
        setResistance(5f);//6000000.0F);
        setStepSound(soundTypeStone);
        setHarvestLevel("pickaxe",2);        
    }
    
    @Override
    public Item getItemDropped(int meta, Random rand,int fortune){
        return Sundry.samdust;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        icons = new IIcon[2];
        for (int i = 0; i < icons.length; i++) 
        {
            icons[i] = par1IconRegister.registerIcon(Sundry.MODID+":"+name+i);            
        }    
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        return icons[par2];
    }
    
    @SuppressWarnings({"unckecked","rawtypes"})
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTab, List par3List)
    {
        for (int var4 = 0; var4 < 2; ++var4) {
            par3List.add(new ItemStack(par1,1,var4));
            
        }
    }

}
