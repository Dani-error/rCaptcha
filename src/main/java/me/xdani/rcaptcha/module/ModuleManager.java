package me.xdani.rcaptcha.module;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.UtilityClass;
import me.xdani.rcaptcha.Captcha;
import me.xdani.rcaptcha.module.impl.*;

import java.util.Comparator;
import java.util.List;

@UtilityClass
@Getter
@Setter
public final class ModuleManager {

    private static ServiceModule serviceModule;
    private static FileModule fileModule;
    private static ManagerModule managerModule;

    public static void preLoad(Captcha plugin) {
        Module fileModule = ModuleManager.getByName("File");
        fileModule.onEnable(plugin);
        fileModule.setLoaded(true);
        Module serviceModule = ModuleManager.getByName("Service");
        serviceModule.onEnable(plugin);
        serviceModule.setLoaded(true);
    }


    public static Module getByName(String name) {
        for(Module module : Module.getModules()){
            if (module.getName().equalsIgnoreCase(name)) {
                return module;
            }
        }

        return null;
    }

    public static ServiceModule getServiceModule() {
        return serviceModule;
    }

    public static void setServiceModule(ServiceModule serviceModule) {
        ModuleManager.serviceModule = serviceModule;
    }

    public static FileModule getFileModule() {
        return fileModule;
    }

    public static void setFileModule(FileModule fileModule) {
        ModuleManager.fileModule = fileModule;
    }

    public static ManagerModule getManagerModule() {
        return managerModule;
    }

    public static void setManagerModule(ManagerModule managerModule) {
        ModuleManager.managerModule = managerModule;
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

        ModuleManager.setFileModule(new FileModule());
        ModuleManager.setServiceModule(new ServiceModule());
        ModuleManager.setManagerModule(new ManagerModule());

        new ListenerModule();

        new CommandModule();

    }
}

