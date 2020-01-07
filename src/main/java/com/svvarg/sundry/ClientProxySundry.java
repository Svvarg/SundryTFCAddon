package com.svvarg.sundry;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.renderer.entity.RenderSnowball;

/**
 *
 * @author Swarg
 */
public class ClientProxySundry extends CommonProxySundry
{
    @Override
    public void registerRendering()
    {     
        RenderingRegistry.registerEntityRenderingHandler(EntitySundryMob.class, 
                new RenderSundryMob(new ModelSundryMob(),0.5f));
    }
    
    @Override
    public void registerItemRenders()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntitySundryThrowable.class, 
                new RenderSnowball(Sundry.sunthrow));
    }
}
