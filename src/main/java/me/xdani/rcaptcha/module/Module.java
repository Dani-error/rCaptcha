package me.xdani.rcaptcha.module;

import lombok.Getter;
import lombok.Setter;
import me.xdani.rcaptcha.Captcha;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Module {

    private int priority;
    private static final List<Module> modules = new ArrayList<>();
    private boolean loaded;
    private String name;

    public static List<Module> getModules() {
        return modules;
    }

    public abstract void onEnable(Captcha plugin);

    public Module() {
        modules.add(this);
    }
}

