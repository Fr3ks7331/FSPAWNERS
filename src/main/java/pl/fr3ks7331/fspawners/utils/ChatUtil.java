package pl.fr3ks7331.fspawners.utils;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ChatUtil
{
    public static String fixColors(String message)
    {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String[] fixColors(String[] message)
    {
        for (int i = 0; i < message.length; i++) {
            message[i] = fixColors(message[i]);
        }
        return message;
    }



    public static List<String> fixColors(List<String> message)
    {
        if (message == null) {
            return null;
        }
        for (int i = 0; i < message.size(); i++) {
            message.set(i, fixColors((String)message.get(i)));
        }
        return message;
    }

    public static void log(String message)
    {
        Bukkit.getConsoleSender().sendMessage(fixColors(message));
    }
}
