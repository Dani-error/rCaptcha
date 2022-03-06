package me.xdani.rcaptcha.utils.menu.pagination;

import lombok.AllArgsConstructor;
import me.xdani.rcaptcha.utils.ChatUtil;
import me.xdani.rcaptcha.utils.item.ItemBuilder;
import me.xdani.rcaptcha.utils.menu.Button;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
public class JumpToPageButton extends Button {

    private final int page;
    private final PaginatedMenu menu;
    private final boolean current;

    @Override
    public ItemStack getButtonItem(Player player) {
        ItemBuilder itemBuilder = new ItemBuilder(this.current ? Material.ENCHANTED_BOOK : Material.BOOK, this.page);
        itemBuilder.setName(ChatUtil.translate("&cPage " + this.page));

        if (this.current) {
            itemBuilder.setLore(
                    "",
                    ChatUtil.translate("&aCurrent page")
            );
        }

        return itemBuilder.build();
    }

    @Override
    public void clicked(Player player, int i, ClickType clickType, int hb) {
        this.menu.modPage(player, this.page - this.menu.getPage());
        Button.playNeutral(player);
    }
}