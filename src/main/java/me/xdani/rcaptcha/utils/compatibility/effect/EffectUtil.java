package me.xdani.rcaptcha.utils.compatibility.effect;

import lombok.experimental.UtilityClass;
import org.bukkit.Effect;
import org.bukkit.entity.Player;

@UtilityClass
public class EffectUtil {

    public void play(Player player, String effect) {
        if (!effect.isEmpty()) play(player, Effect.valueOf(effect));
    }

    public static void play(Player player, Effect effect) {
        player.getWorld().spigot().playEffect(player.getLocation(), effect, 26, 0, 0.2F, 0.5F, 0.2F, 0.2F, 12, 387);
    }
}
