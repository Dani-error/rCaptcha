package me.xdani.rcaptcha.utils.command;

import me.xdani.rcaptcha.module.ModuleManager;

public abstract class BaseCommand {

    public abstract void onCommand(CommandArgs commandArgs);

    public BaseCommand() {
        ModuleManager.getManagerModule().getCommandManager().registerCommands(this, null);
    }
}

