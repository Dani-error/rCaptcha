package me.xdani.rcaptcha.utils.compatibility.sound;

import lombok.experimental.UtilityClass;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

@UtilityClass
public final class SoundUtil {

    public void play(Player player, String sound) {
        if (!sound.isEmpty()) play(player, Sound.valueOf(sound));
    }

    public void play(Player player, Sound sound) {
        if (sound != null) player.playSound(player.getLocation(), sound, 1.0f, 1.0f);
    }

}

