package com.svvarg.sundry.lootchest;

import com.svvarg.sundry.Sundry;
import com.svvarg.sundry.TileEntitySundry;
import com.svvarg.sundry.lootchest.TileEntityLootChest;
import static com.svvarg.sundry.lootchest.GuiLootChestHandler.GUIIDLOOTCHEST;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import static net.minecraft.block.Block.soundTypeStone;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 *
 * @author Swarg
 */
public class BlockLootChestTE extends BlockContainer {

    private String name = "lootChest";
    private IIcon icon;

    public BlockLootChestTE() {
        super(Material.rock);
        setBlockName(Sundry.MODID + "_" + name);
        setCreativeTab(CreativeTabs.tabBlock);
        setHardness(2F);
        setResistance(5F);
        setStepSound(soundTypeStone);
        setHarvestLevel("pichaxe", 2);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p1IconRegister) {
        icon = p1IconRegister.registerIcon(Sundry.MODID + ":" + name);
        
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p1, int p2) {
        return icon;
    }

    @Override
    public TileEntity createNewTileEntity(World w, int p2) {
        return new TileEntityLootChest();
    }

    @Override
    public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer player,
            int side, float hitX, float hitY, float hitZ) 
    {
        TileEntity entity = w.getTileEntity(x, y, z);
        if (entity != null && entity instanceof TileEntityLootChest) {
            TileEntityLootChest lootChestE =  (TileEntityLootChest) entity;
            if (!player.isSneaking())// && !w.isRemote) 
            {
                
                player.openGui(Sundry.instance, GUIIDLOOTCHEST, w, x, y, z);
            }
            return true;
        }
        return false;
    }
}
