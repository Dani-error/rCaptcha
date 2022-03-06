package me.xdani.rcaptcha.utils;

import lombok.experimental.UtilityClass;
import me.xdani.rcaptcha.Captcha;
import org.apache.commons.lang.time.DurationFormatUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@UtilityClass
public class JavaUtil {

    public Integer tryParseInt(String string) {
        try {
            return Integer.parseInt(string);
        }
        catch (IllegalArgumentException ex) {
            return null;
        }
    }

    public void checkPluginChanged(){
        PluginDescriptionFile descriptionFile = Captcha.get().getDescription();

        if(descriptionFile.getAuthors().size() != 1 || !descriptionFile.getAuthors().get(0).equals("_xDani_") || !descriptionFile.getName().equals("rCaptcha") || !descriptionFile.getDescription().equals("Powerful Captcha Security.")){
            ChatUtil.log(ChatUtil.NORMAL_LINE);
            ChatUtil.log(" ");
            ChatUtil.log("&4&lrCaptcha");
            ChatUtil.log(" ");
            ChatUtil.log(" &7Trying to skid?");
            ChatUtil.log(" ");
            ChatUtil.log(ChatUtil.NORMAL_LINE);
            Bukkit.getPluginManager().disablePlugin(Captcha.get());
        }
    }

    public boolean pluginChanged(){
        PluginDescriptionFile descriptionFile = Captcha.get().getDescription();
        return descriptionFile.getAuthors().size() != 1 || !descriptionFile.getAuthors().get(0).equals("_xDani_") || !descriptionFile.getName().equals("rCaptcha") || !descriptionFile.getDescription().equals("Powerful Captcha Security.");
    }

    public String formatDurationInt(int input) {
        return DurationFormatUtils.formatDurationWords(input * 1000L, true, true);
    }

    public String formatDurationLong(long input) {
        return DurationFormatUtils.formatDurationWords(input, true, true);
    }

    public String formatLongMin(long time) {
        long totalSecs = time / 1000L;
        return String.format("%02d:%02d", totalSecs / 60L, totalSecs % 60L);
    }

    public String formatLongHour(long time) {
        long totalSecs = time / 1000L;

        long seconds = totalSecs % 60L;
        long minutes = totalSecs % 3600L / 60L;
        long hours = totalSecs / 3600L;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public long formatLong(String input) {
        if (input == null || input.isEmpty()) return -1L;

        long result = 0L;
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);

            if (Character.isDigit(c)) {
                number.append(c);
            }
            else {
                String str;
                if (Character.isLetter(c) && !(str = number.toString()).isEmpty()) {
                    result += convertLong(Integer.parseInt(str), c);
                    number = new StringBuilder();
                }
            }
        }
        return result;
    }

    private long convertLong(int value, char unit) {
        switch (unit) {
            case 'y': {
                return value * TimeUnit.DAYS.toMillis(365L);
            }
            case 'M': {
                return value * TimeUnit.DAYS.toMillis(30L);
            }
            case 'd': {
                return value * TimeUnit.DAYS.toMillis(1L);
            }
            case 'h': {
                return value * TimeUnit.HOURS.toMillis(1L);
            }
            case 'm': {
                return value * TimeUnit.MINUTES.toMillis(1L);
            }
            case 's': {
                return value * TimeUnit.SECONDS.toMillis(1L);
            }
            default: {
                return -1L;
            }
        }
    }

    public int formatInt(String input) {
        if (input == null || input.isEmpty()) return -1;

        int result = 0;
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);

            if (Character.isDigit(c)) {
                number.append(c);
            }
            else {
                String str;
                if (Character.isLetter(c) && !(str = number.toString()).isEmpty()) {
                    result += convertInt(Integer.parseInt(str), c);
                    number = new StringBuilder();
                }
            }
        }
        return result;
    }

    private int convertInt(int value, char unit) {
        switch (unit) {
            case 'd': {
                return value * 60 * 60 * 24;
            }
            case 'h': {
                return value * 60 * 60;
            }
            case 'm': {
                return value * 60;
            }
            case 's': {
                return value;
            }
            default: {
                return -1;
            }
        }
    }

    public static int randomNumber(int bound) {
        return new Random().nextInt(bound);
    }

    public static int randomNumber() {
        return new Random().nextInt();
    }

    public int randomNumberWithExclusion(int min, int bound, int... exclude) {
        int random = min + new Random().nextInt(bound - min + 1 - exclude.length);
        for (int ex : exclude) {
            if (random < ex) {
                break;
            }
            random++;
        }
        return random;
    }

    public int randomNumberWithExclusionWithoutMin(int bound, int... exclude) {
        int random = new Random().nextInt(bound + 1 - exclude.length);
        for (int ex : exclude) {
            if (random < ex) {
                break;
            }
            random++;
        }
        return random;
    }
}