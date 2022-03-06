package me.xdani.rcaptcha.module.impl;

import lombok.Getter;
import me.xdani.rcaptcha.Captcha;
import me.xdani.rcaptcha.module.Module;
import me.xdani.rcaptcha.utils.command.CommandManager;

import java.util.Collections;

@Getter
public class ManagerModule extends Module {

    private CommandManager commandManager;

    @Override
    public int getPriority() {
        return 3;
    }

    @Override
    public String getName() {
        return "Manager";
    }

    @Override
    public void onEnable(Captcha plugin) {
        this.commandManager = new CommandManager(plugin, Collections.emptyList());
    }
}

