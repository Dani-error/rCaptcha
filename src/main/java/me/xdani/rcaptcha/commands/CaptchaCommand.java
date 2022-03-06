package me.xdani.rcaptcha.commands;

import me.xdani.rcaptcha.Captcha;
import me.xdani.rcaptcha.commands.subcommands.CaptchaInfoCommand;
import me.xdani.rcaptcha.commands.subcommands.CaptchaReloadCommand;
import me.xdani.rcaptcha.utils.ChatUtil;
import me.xdani.rcaptcha.utils.command.BaseCommand;
import me.xdani.rcaptcha.utils.command.Command;
import me.xdani.rcaptcha.utils.command.CommandArgs;
import org.bukkit.command.CommandSender;

public class CaptchaCommand extends BaseCommand {

    @Override
    @Command(name="rcaptcha", aliases={"captcha"}, inGameOnly = false)
    public void onCommand(CommandArgs commandArgs) {
        CommandSender sender = commandArgs.getSender();

        ChatUtil.sendMessage(sender, "");
        ChatUtil.sendMessage(sender, ChatUtil.NORMAL_LINE);
        ChatUtil.sendMessage(sender, "&4&l"+ Captcha.get().getName() + " Help");
        ChatUtil.sendMessage(sender, "");
        ChatUtil.sendMessage(sender, " &7➼ &c/"+commandArgs.getLabel() + " info");
        ChatUtil.sendMessage(sender, " &7➼ &c/"+commandArgs.getLabel() + " reload");
        ChatUtil.sendMessage(sender, ChatUtil.NORMAL_LINE);
        ChatUtil.sendMessage(sender, "");
    }

    public CaptchaCommand(){
        new CaptchaReloadCommand();
        new CaptchaInfoCommand();
    }
}

