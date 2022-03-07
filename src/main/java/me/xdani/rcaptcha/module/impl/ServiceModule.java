package me.xdani.rcaptcha.module.impl;

import me.xdani.rcaptcha.Captcha;
import me.xdani.rcaptcha.module.Module;
import me.xdani.rcaptcha.services.MainService;

public class ServiceModule extends Module {

    @Override
    public int getPriority() {
        return 2;
    }

    @Override
    public boolean preLoad() {
        return true;
    }

    @Override
    public void onEnable(Captcha plugin) {
        this.reload();
    }

    @Override
    public String getName() {
        return "Service";
    }

    public void reload() {
        MainService.init();
    }

}

