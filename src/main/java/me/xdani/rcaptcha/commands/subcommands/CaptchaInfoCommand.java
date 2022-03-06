package me.xdani.rcaptcha.commands.subcommands;

import me.xdani.rcaptcha.Captcha;
import me.xdani.rcaptcha.utils.ChatUtil;
import me.xdani.rcaptcha.utils.command.BaseCommand;
import me.xdani.rcaptcha.utils.command.Command;
import me.xdani.rcaptcha.utils.command.CommandArgs;
import org.bukkit.command.CommandSender;

public class CaptchaInfoCommand extends BaseCommand {

    @Override
    @Command(name="rcaptcha.info", aliases={"captcha.info"}, inGameOnly=false)
    public void onCommand(CommandArgs commandArgs) {
        CommandSender commandSender = commandArgs.getSender();
        ChatUtil.sendMessage(commandSender, "");
        ChatUtil.sendMessage(commandSender, ChatUtil.NORMAL_LINE);
        ChatUtil.sendMessage(commandSender, "   &2&l☘ &4&l"+ Captcha.get().getName() + " &2&l☘");
        ChatUtil.sendMessage(commandSender, "");
        ChatUtil.sendMessage(commandSender, " &7➼ &cAuthor&7: "+ Captcha.get().getDescription().getAuthors().get(0));
        ChatUtil.sendMessage(commandSender, " &7➼ &cVersion&7: "+Captcha.get().getDescription().getVersion());
        ChatUtil.sendMessage(commandSender, ChatUtil.NORMAL_LINE);
        ChatUtil.sendMessage(commandSender, "");
    }
}

