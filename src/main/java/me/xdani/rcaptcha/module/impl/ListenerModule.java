package me.xdani.rcaptcha.module.impl;

import me.xdani.rcaptcha.Captcha;
import me.xdani.rcaptcha.listeners.PlayerListener;
import me.xdani.rcaptcha.module.Module;
import me.xdani.rcaptcha.utils.menu.listener.MenuListener;

public class ListenerModule extends Module {

    @Override
    public int getPriority() {
        return 4;
    }

    @Override
    public String getName() {
        return "Listener";
    }

    @Override
    public void onEnable(Captcha plugin) {
        new PlayerListener();

        new MenuListener(plugin);
    }

}

