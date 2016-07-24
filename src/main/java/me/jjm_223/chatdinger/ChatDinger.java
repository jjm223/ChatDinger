package me.jjm_223.chatdinger;

import me.jjm_223.chatdinger.proxy.CommonProxy;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

@Mod(modid = ChatDinger.MODID, version = ChatDinger.VERSION)
public class ChatDinger
{
    public static final String MODID = "chatdinger";
    public static final String VERSION = "1.0";

    @SidedProxy(clientSide = "me.jjm_223.chatdinger.proxy.ClientProxy", serverSide = "me.jjm_223.chatdinger.proxy.ServerProxy")
    public static CommonProxy proxy;

    private static File configFile;
    private static Configuration config;
    private static String regexString;

    private static KeyBinding reloadRegex;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);

    }

    public static String getRegexString()
    {
        return regexString;
    }

    public static void loadConfig(File file)
    {
        configFile = file;
        config = new Configuration(configFile);
        reloadConfig();
        config.save();
    }

    public static void reloadConfig()
    {
        config.load();
        regexString = config.getString("regexString", Configuration.CATEGORY_CLIENT, "a^", "The RegEx expression you'd like to use to see if a message is a match.");
        ChatHandler.setPattern(ChatDinger.getRegexString());
    }

    public static void setKeybind(KeyBinding bind)
    {
        reloadRegex = bind;
    }

    public static KeyBinding getKeybind()
    {
        return reloadRegex;
    }
}
