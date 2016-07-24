package me.jjm_223.chatdinger.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy extends CommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
        // Nothing should be done on servers.
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);
        // Nothing should be done on servers.
    }
}
