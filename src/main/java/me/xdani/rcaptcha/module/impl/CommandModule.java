package me.xdani.rcaptcha.module.impl;

import me.xdani.rcaptcha.Captcha;
import me.xdani.rcaptcha.commands.CaptchaCommand;
import me.xdani.rcaptcha.module.Module;

public class CommandModule extends Module {

    @Override
    public int getPriority() {
        return 5;
    }

    @Override
    public String getName() {
        return "Command";
    }

    @Override
    public void onEnable(Captcha plugin) {
        new CaptchaCommand();
    }
}

