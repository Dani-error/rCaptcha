package me.xdani.rcaptcha.listeners;

import com.google.common.collect.Maps;
import me.xdani.rcaptcha.Captcha;
import me.xdani.rcaptcha.handlers.CaptchaHandler;
import me.xdani.rcaptcha.menu.CaptchaMenu;
import me.xdani.rcaptcha.services.MainService;
import me.xdani.rcaptcha.tasks.KickTask;
import me.xdani.rcaptcha.utils.ChatUtil;
import me.xdani.rcaptcha.utils.TaskUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Map;
import java.util.UUID;

public class PlayerListener implements Listener {

    private final Map<UUID, KickTask> kickTasks = Maps.newHashMap();

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        if(player.hasPermission(MainService.BYPASS_PERMISSION)) return;

        TaskUtil.runLater(() -> new CaptchaMenu().openMenu(player), 5L);

        TaskUtil.runLater(() -> {
            KickTask kickTask = new KickTask(player, kickTasks);
            kickTask.run();
        }, MainService.TIME_TO_KICK * 20L);

        TaskUtil.runTimer(new BukkitRunnable() {
            @Override
            public void run() {
                if(CaptchaHandler.captchaPassed(event.getPlayer())){
                    ChatUtil.sendMessage(player, MainService.CAPTCHA_PASSED);
                    cancel();

                    if(kickTasks.get(player.getUniqueId()) != null){
                        kickTasks.get(player.getUniqueId()).cancel();
                    }
                }

                if(!player.isOnline()){
                    cancel();
                }
            }
        }, 5, 5);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        if(CaptchaHandler.captchaPassed(event.getPlayer())){
            CaptchaHandler.CAPTCHA_PASSED.remove(event.getPlayer().getUniqueId());

            if(kickTasks.get(event.getPlayer().getUniqueId()) != null){
                kickTasks.get(event.getPlayer().getUniqueId()).cancel();
            }
        }
    }

    public PlayerListener(){
        Bukkit.getPluginManager().registerEvents(this, Captcha.get());
    }
}
