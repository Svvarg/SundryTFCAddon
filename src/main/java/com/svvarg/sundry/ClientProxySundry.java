package com.svvarg.sundry;

import cpw.mods.fml.client.registry.RenderingRegistry;

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
}
