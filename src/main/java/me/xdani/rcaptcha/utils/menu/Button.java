package me.xdani.rcaptcha.utils.menu;

import me.xdani.rcaptcha.utils.compatibility.sound.CompatibleSound;
import me.xdani.rcaptcha.utils.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public abstract class Button {

    public static Button placeholder(Material material, final int data, String title) {
        return (new Button() {
            public ItemStack getButtonItem(Player player) {
                return new ItemBuilder(material).setData(data).setName(title).build();
            }
        });
    }

    public static void playFail(Player player) {
        CompatibleSound.DIG_GRASS.play(player, 20F, 0.1F);
    }

    public static void playSuccess(Player player) {
        CompatibleSound.NOTE_PIANO.play(player, 20F, 15F);
    }

    public static void playNeutral(Player player) {
        CompatibleSound.CLICK.play(player, 20F, 1F);
    }

    public abstract ItemStack getButtonItem(Player player);

    public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {

    }

    public boolean shouldUpdate(Player player, int slot, ClickType clickType) {
        return false;
    }

    public boolean shouldCancel(Player player, int slot, ClickType clickType) {
        return true;
    }

    public boolean shouldShift(Player player, int slot, ClickType clickType) {
        return true;
    }
}
