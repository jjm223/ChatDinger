package me.jjm_223.chatdinger;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

import java.util.List;
import java.util.regex.Pattern;

public class ChatHandler
{
    private static Pattern pattern;

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event)
    {
        String message = event.getMessage().getUnformattedText();
        List<String> sentMessages = Minecraft.getMinecraft().ingameGUI.getChatGUI().getSentMessages();
        if (sentMessages.size() != 0 && message.endsWith(sentMessages.get(sentMessages.size() - 1)))
        {
            return;
        }
        if (pattern.matcher(message).matches())
        {
            Minecraft.getMinecraft().thePlayer.playSound(new SoundEvent(new ResourceLocation("entity.experience_orb.pickup")), 1, 1);
        }
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event)
    {
        if (ChatDinger.getKeybind().isPressed())
        {
            ChatDinger.reloadConfig();
            Minecraft.getMinecraft().thePlayer.addChatMessage(new TextComponentString("Reloaded chat dinger config."));
        }
    }

    public static void setPattern(String pattern)
    {
        ChatHandler.pattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
    }
}
