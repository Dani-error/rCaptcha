package me.xdani.rcaptcha.utils;

import lombok.experimental.UtilityClass;
import me.xdani.rcaptcha.Captcha;
import org.bukkit.scheduler.BukkitRunnable;

@UtilityClass
public class TaskUtil {

    public void run(Runnable runnable) {
        Captcha.get().getServer().getScheduler().runTask(Captcha.get(), runnable);
    }

    public void runTimer(Runnable runnable, long delay, long timer) {
        Captcha.get().getServer().getScheduler().runTaskTimer(Captcha.get(), runnable, delay, timer);
    }

    public void runTimer(BukkitRunnable runnable, long delay, long timer) {
        runnable.runTaskTimer(Captcha.get(), delay, timer);
    }

    public void runTimerAsync(Runnable runnable, long delay, long timer) {
        Captcha.get().getServer().getScheduler().runTaskTimerAsynchronously(Captcha.get(), runnable, delay, timer);
    }

    public void runTimerAsync(BukkitRunnable runnable, long delay, long timer) {
        runnable.runTaskTimerAsynchronously(Captcha.get(), delay, timer);
    }

    public void runLater(Runnable runnable, long delay) {
        Captcha.get().getServer().getScheduler().runTaskLater(Captcha.get(), runnable, delay);
    }

    public void runLaterAsync(Runnable runnable, long delay) {
        try {
            Captcha.get().getServer().getScheduler().runTaskLaterAsynchronously(Captcha.get(), runnable, delay);
        } catch (IllegalStateException e) {
            Captcha.get().getServer().getScheduler().runTaskLater(Captcha.get(), runnable, delay);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void runTaskTimerAsynchronously(Runnable runnable, int delay) {
        try {
            Captcha.get().getServer().getScheduler().runTaskTimerAsynchronously(Captcha.get(), runnable, 20L * delay, 20L * delay);
        } catch (IllegalStateException e) {
            Captcha.get().getServer().getScheduler().runTaskTimer(Captcha.get(), runnable, 20L * delay, 20L * delay);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void runAsync(Runnable runnable) {
        try {
            Captcha.get().getServer().getScheduler().runTaskAsynchronously(Captcha.get(), runnable);
        } catch (IllegalStateException e) {
            Captcha.get().getServer().getScheduler().runTask(Captcha.get(), runnable);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}