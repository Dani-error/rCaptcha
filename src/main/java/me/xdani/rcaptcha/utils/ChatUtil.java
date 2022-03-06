package me.xdani.rcaptcha.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public final class ChatUtil {

    public static String SHORT_LINE = "&7&m---------------";
    public static String NORMAL_LINE = "&7&m-----------------------------";
    public static String LONG_LINE = "&7&m----------------------------------------";

    public String BLUE = ChatColor.BLUE.toString();
    public String AQUA = ChatColor.AQUA.toString();
    public String YELLOW = ChatColor.YELLOW.toString();
    public String RED = ChatColor.RED.toString();
    public String GRAY = ChatColor.GRAY.toString();
    public String GOLD = ChatColor.GOLD.toString();
    public String GREEN = ChatColor.GREEN.toString();
    public String WHITE = ChatColor.WHITE.toString();
    public String BLACK = ChatColor.BLACK.toString();
    public String BOLD = ChatColor.BOLD.toString();
    public String ITALIC = ChatColor.ITALIC.toString();
    public String UNDER_LINE = ChatColor.UNDERLINE.toString();
    public String STRIKE_THROUGH = ChatColor.STRIKETHROUGH.toString();
    public String RESET = ChatColor.RESET.toString();
    public String MAGIC = ChatColor.MAGIC.toString();
    public String DARK_BLUE = ChatColor.DARK_BLUE.toString();
    public String DARK_AQUA = ChatColor.DARK_AQUA.toString();
    public String DARK_GRAY = ChatColor.DARK_GRAY.toString();
    public String DARK_GREEN = ChatColor.DARK_GREEN.toString();
    public String DARK_PURPLE = ChatColor.DARK_PURPLE.toString();
    public String DARK_RED = ChatColor.DARK_RED.toString();
    public String PINK = ChatColor.LIGHT_PURPLE.toString();


    public static void broadcast(String message) {
        Bukkit.broadcastMessage(ChatUtil.translate(message));
    }

    public static String capitalize(String message) {
        return WordUtils.capitalize(message);
    }

    public static void log(String message) {
        Bukkit.getConsoleSender().sendMessage(ChatUtil.translate(message));
    }

    public static List<String> translate(List<String> message) {
        return message.stream().map(ChatUtil::translate).collect(Collectors.toList());
    }

    public static String strip(String message) {
        return ChatColor.stripColor(message);
    }

    public String toReadable(Enum<?> enu) {
        return WordUtils.capitalize(enu.name().replace("_", " ").toLowerCase());
    }

    public static String translate(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static void sendMessage(CommandSender commandSender, String message) {
        if (commandSender instanceof Player) {
            Player player = (Player)commandSender;
            player.sendMessage(ChatUtil.translate(message));
        } else {
            commandSender.sendMessage(ChatUtil.translate(message));
        }
    }
}

