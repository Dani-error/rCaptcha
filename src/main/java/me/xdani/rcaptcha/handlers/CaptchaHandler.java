package me.xdani.rcaptcha.handlers;

import com.google.common.collect.Sets;
import org.bukkit.entity.Player;

import java.util.Set;
import java.util.UUID;

public class CaptchaHandler {

    public static Set<UUID> CAPTCHA_PASSED = Sets.newHashSet();

    public static boolean captchaPassed(Player player) {
        return CAPTCHA_PASSED.contains(player.getUniqueId());
    }

}
