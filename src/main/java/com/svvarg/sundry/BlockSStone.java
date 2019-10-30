/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svvarg.sundry;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 *
 * @author Swarg
 */
public class BlockSStone extends Block {
    String name = "sstone";

    public BlockSStone() {
        super(Material.rock);
        setBlockName(Sundry.MODID+"_"+name);
        setBlockTextureName(Sundry.MODID+":"+name);
        setCreativeTab(CreativeTabs.tabMisc);
        setHardness(2f);//-1.0F);
        setResistance(5f);//6000000.0F);
        setHarvestLevel("pickaxe",2);        
    }
    @Override
    public Item getItemDropped(int meta, Random rand,int fortune){
        return Sundry.samdust;
    }

}
