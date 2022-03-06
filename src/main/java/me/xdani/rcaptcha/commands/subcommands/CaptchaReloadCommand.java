package me.xdani.rcaptcha.commands.subcommands;

import me.xdani.rcaptcha.module.ModuleManager;
import me.xdani.rcaptcha.utils.ChatUtil;
import me.xdani.rcaptcha.utils.command.BaseCommand;
import me.xdani.rcaptcha.utils.command.Command;
import me.xdani.rcaptcha.utils.command.CommandArgs;
import org.bukkit.command.CommandSender;

public class CaptchaReloadCommand extends BaseCommand {

    @Override
    @Command(name="rcaptcha.reload", permission="rcaptcha.reload", aliases={"captcha.reload"}, inGameOnly=false)
    public void onCommand(CommandArgs commandArgs) {
        CommandSender commandSender = commandArgs.getSender();
        ModuleManager.getFileModule().reload();
        ModuleManager.getServiceModule().reload();
        ChatUtil.sendMessage(commandSender, "&aAll files has been reloaded!");
    }
}

