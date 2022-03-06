package me.xdani.rcaptcha;

import lombok.Getter;
import me.xdani.rcaptcha.module.ModuleManager;
import me.xdani.rcaptcha.utils.ChatUtil;
import me.xdani.rcaptcha.utils.JavaUtil;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class Captcha extends JavaPlugin {

    @Override
    public void onEnable() {
        JavaUtil.checkPluginChanged();

        ModuleManager.register();
        ModuleManager.preLoad(this);
        ModuleManager.loadAll(this);

        ChatUtil.log(" ");
        ChatUtil.log(ChatUtil.NORMAL_LINE);
        ChatUtil.log("&4&lrCaptcha");
        ChatUtil.log(" ");
        ChatUtil.log(" &c* &4Author: &f_xDani_");
        ChatUtil.log(" &c* &4Version: &f"+getDescription().getVersion());
        ChatUtil.log(" ");
        ChatUtil.log(ChatUtil.NORMAL_LINE);
        ChatUtil.log(" ");
    }

    public static Captcha get(){
        return getPlugin(Captcha.class);
    }
}
