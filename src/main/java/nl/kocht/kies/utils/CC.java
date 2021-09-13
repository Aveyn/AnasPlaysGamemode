package nl.kocht.kies.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class CC {

    public static String translate(final String in) {
        return ChatColor.translateAlternateColorCodes('&', in);
    }

    public static List<String> translate(final List<String> lines) {
     final List<String> toReturn = new ArrayList<>();
     for (final String line : lines){
         toReturn.add(ChatColor.translateAlternateColorCodes('&', line));
     }
     return toReturn;
    }
}
