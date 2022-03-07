package me.xdani.rcaptcha.utils.command;

import me.xdani.rcaptcha.module.ModuleManager;
import me.xdani.rcaptcha.module.impl.ManagerModule;

public abstract class BaseCommand {

    public abstract void onCommand(CommandArgs commandArgs);

    public BaseCommand() {
        ((ManagerModule) ModuleManager.getByName("Manager")).getCommandManager().registerCommands(this, null);
    }
}

