package me.xdani.rcaptcha.utils.compatibility.material;

import lombok.experimental.UtilityClass;
import org.bukkit.Material;

@UtilityClass
public final class MaterialUtil {

    public static Material getMaterial(String material) {
        try {
            return Material.getMaterial(Integer.parseInt(material));
        }
        catch (IllegalArgumentException exception) {
            return Material.getMaterial(material);
        }
    }

}

