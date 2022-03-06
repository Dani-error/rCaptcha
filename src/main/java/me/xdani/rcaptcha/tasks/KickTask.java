package me.xdani.rcaptcha.tasks;

import lombok.AllArgsConstructor;
import me.xdani.rcaptcha.handlers.CaptchaHandler;
import me.xdani.rcaptcha.services.MainService;
import me.xdani.rcaptcha.utils.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
public class KickTask extends BukkitRunnable {

    private final Player player;
    private final Map<UUID, KickTask> kickTasks;

    @Override
    public void run() {
        kickTasks.put(player.getUniqueId(), this);

        if(!CaptchaHandler.captchaPassed(this.player)){
            this.player.kickPlayer(ChatUtil.translate(MainService.KICK_TIME));
        }
    }
}
