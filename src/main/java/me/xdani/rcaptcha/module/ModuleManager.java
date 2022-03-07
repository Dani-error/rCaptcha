package me.xdani.rcaptcha.module;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.UtilityClass;
import me.xdani.rcaptcha.Captcha;
import me.xdani.rcaptcha.module.impl.*;
import me.xdani.rcaptcha.utils.ReflectUtils;

import java.util.Comparator;
import java.util.List;

@UtilityClass
@Getter
@Setter
public final class ModuleManager {

    public static void preLoad(Captcha plugin) {
        Module.getModules().stream().filter((Module::preLoad)).forEach((module -> {
            module.onEnable(plugin);
            module.setLoaded(true);
        }));
    }


    public static Module getByName(String name) {
        for(Module module : Module.getModules()){
            if (module.getName().equalsIgnoreCase(name)) {
                return module;
            }
        }

        return null;
    }

    public static List<Module> getOrderModules() {
        List<Module> modules = Module.getModules();
        modules.sort(Comparator.comparingInt(Module::getPriority));
        return modules;
    }

    public static void loadAll(Captcha plugin) {
        for(Module module : ModuleManager.getOrderModules()){
            if(!module.isLoaded()){
                module.onEnable(plugin);
                module.setLoaded(true);
            }
        }
    }


    public static void register() {

        for (Class<?> clazz : ReflectUtils.getClassesInPackage("me.xdani.rcaptcha.module.impl")) {
            try {
                clazz.newInstance();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

    }

}

