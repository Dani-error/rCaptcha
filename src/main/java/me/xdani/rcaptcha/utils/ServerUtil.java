package me.xdani.rcaptcha.utils;

import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;

@UtilityClass
public final class ServerUtil {

    public static final String SERVER_VERSION = Bukkit.getServer()
            .getClass().getPackage()
            .getName().split("\\.")[3]
            .substring(1);

    public static final int SERVER_VERSION_INT = Integer.parseInt(
            SERVER_VERSION
                    .replace("1_", "")
                    .replaceAll("_R\\d", ""));

}

