package me.xdani.rcaptcha.listeners;

import me.xdani.rcaptcha.Captcha;
import me.xdani.rcaptcha.handlers.CaptchaHandler;
import me.xdani.rcaptcha.menu.CaptchaMenu;
import me.xdani.rcaptcha.services.MainService;
import me.xdani.rcaptcha.utils.ChatUtil;
import me.xdani.rcaptcha.utils.TaskUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    @EventHandler
    private void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        if(player.hasPermission(MainService.BYPASS_PERMISSION)) return;

        TaskUtil.runLater(() -> new CaptchaMenu().openMenu(player), 5L);

        TaskUtil.runLater(() -> {
            if(!CaptchaHandler.captchaPassed(player)){
                player.kickPlayer(ChatUtil.translate(MainService.KICK_TIME));
            }
        }, MainService.TIME_TO_KICK * 20L);
    }

    @EventHandler
    private void onQuit(PlayerQuitEvent event){
        if(CaptchaHandler.captchaPassed(event.getPlayer())){
            CaptchaHandler.CAPTCHA_PASSED.remove(event.getPlayer().getUniqueId());
        }
    }

    public PlayerListener(){
        Bukkit.getPluginManager().registerEvents(this, Captcha.get());
    }
}
