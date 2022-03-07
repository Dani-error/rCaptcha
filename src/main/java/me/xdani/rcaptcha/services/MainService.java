package me.xdani.rcaptcha.services;

import com.google.common.collect.Lists;
import lombok.experimental.UtilityClass;
import me.xdani.rcaptcha.module.ModuleManager;
import me.xdani.rcaptcha.module.impl.FileModule;
import me.xdani.rcaptcha.utils.file.FileConfig;

import java.util.List;

@UtilityClass
public class MainService {

    private static final FileConfig mainConfig = ((FileModule) ModuleManager.getByName("File")).getFile("config");

    public static int TIME_TO_KICK;

    public static String BYPASS_PERMISSION;

    public static String KICK_TIME;
    public static String KICK_BAD_ITEM;

    public static String CAPTCHA_PASSED;

    public static String MENU_TITLE;
    public static int MENU_ROWS;

    public static String RANDOM_WOOL_NAME;
    public static List<String> RANDOM_WOOL_LORE;
    public static boolean RANDOM_WOOL_GLOW;

    public static String CORRECT_WOOL_NAME;
    public static List<String> CORRECT_WOOL_LORE;
    public static boolean CORRECT_WOOL_GLOW;

    public static void init() {

        TIME_TO_KICK = mainConfig.getInt("TIME-TO-KICK");

        BYPASS_PERMISSION = mainConfig.getString("BYPASS-PERMISSION");

        KICK_TIME = mainConfig.getString("KICK-MESSAGE.TIME");
        KICK_BAD_ITEM = mainConfig.getString("KICK-MESSAGE.BAD-ITEM");

        CAPTCHA_PASSED = mainConfig.getString("CAPTCHA-PASSED");

        MENU_TITLE = mainConfig.getString("MENU.TITLE");
        MENU_ROWS = mainConfig.getInt("MENU.ROWS");

        RANDOM_WOOL_NAME = mainConfig.getString("MENU.RANDOM-WOOL.NAME");
        RANDOM_WOOL_LORE = mainConfig.getStringListOrDefault("MENU.RANDOM-WOOL.LORE", Lists.newArrayList());
        RANDOM_WOOL_GLOW = mainConfig.getBoolean("MENU.RANDOM-WOOL.GLOW");

        CORRECT_WOOL_NAME = mainConfig.getString("MENU.CORRECT-WOOL.NAME");
        CORRECT_WOOL_LORE = mainConfig.getStringListOrDefault("MENU.CORRECT-WOOL.LORE", Lists.newArrayList());
        CORRECT_WOOL_GLOW = mainConfig.getBoolean("MENU.CORRECT-WOOL.GLOW");

    }
}
