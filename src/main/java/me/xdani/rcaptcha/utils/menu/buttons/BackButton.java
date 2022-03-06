package me.xdani.rcaptcha.utils.menu.buttons;

import lombok.AllArgsConstructor;
import me.xdani.rcaptcha.utils.item.ItemBuilder;
import me.xdani.rcaptcha.utils.menu.Button;
import me.xdani.rcaptcha.utils.menu.Menu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
public class BackButton extends Button {

    private final Menu back;

    @Override
    public ItemStack getButtonItem(Player player) {
        return new ItemBuilder(Material.REDSTONE)
                .setName("&c&lBack")
                .setLore(
                        "&cClick here to return",
                        "&cto the previous menu."
                )
                .build();
    }

    @Override
    public void clicked(Player player, int i, ClickType clickType, int hb) {
        Button.playNeutral(player);
        this.back.openMenu(player);
    }
}