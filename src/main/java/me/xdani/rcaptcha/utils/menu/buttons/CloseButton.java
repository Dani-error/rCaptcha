package me.xdani.rcaptcha.utils.menu.buttons;

import me.xdani.rcaptcha.utils.item.ItemBuilder;
import me.xdani.rcaptcha.utils.menu.Button;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class CloseButton extends Button {

    @Override
    public ItemStack getButtonItem(Player player) {
        return new ItemBuilder(Material.INK_SACK)
                .setData(1)
                .setName("&cClose")
                .build();
    }

    @Override
    public void clicked(Player player, int i, ClickType clickType, int hb) {
        playNeutral(player);
        player.closeInventory();
    }
}