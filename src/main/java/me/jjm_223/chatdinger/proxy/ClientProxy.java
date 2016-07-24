package me.jjm_223.chatdinger.proxy;

import me.jjm_223.chatdinger.ChatDinger;
import me.jjm_223.chatdinger.ChatHandler;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lwjgl.input.Keyboard;

public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
        ChatDinger.loadConfig(event.getSuggestedConfigurationFile());
        MinecraftForge.EVENT_BUS.register(new ChatHandler());
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);
        KeyBinding binding = new KeyBinding("key.reloaddinger", Keyboard.KEY_C, "key.categories.chatdinger");
        ChatDinger.setKeybind(binding);
        ClientRegistry.registerKeyBinding(binding);
    }
}
