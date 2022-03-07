package me.xdani.rcaptcha.module.impl;

import com.google.common.collect.Maps;
import lombok.Getter;
import me.xdani.rcaptcha.Captcha;
import me.xdani.rcaptcha.module.Module;
import me.xdani.rcaptcha.utils.file.FileConfig;

import java.util.Map;

@Getter
public class FileModule extends Module {

    private final Map<String, FileConfig> files;

    public FileModule() {
        this.files = Maps.newHashMap();
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public boolean preLoad() {
        return true;
    }

    @Override
    public String getName() {
        return "File";
    }

    @Override
    public void onEnable(Captcha plugin) {
        this.files.put("config", new FileConfig(plugin, "config.yml"));
    }

    public void reload() {
        for(FileConfig config : this.files.values()){
            config.reload();
        }
    }

    public FileConfig getFile(String file) {
        return this.files.get(file);
    }

}

