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
        setHardness(2f);//-1.0Fдля бедрока - не ломаемый); как долго ломать
        setResistance(5f);//6000000.0F);
        setStepSound(soundTypeStone);
        setHarvestLevel("pickaxe",2);        
    }
    @Override
    public Item getItemDropped(int meta, Random rand,int fortune){
        return Sundry.samdust;
    }

}
