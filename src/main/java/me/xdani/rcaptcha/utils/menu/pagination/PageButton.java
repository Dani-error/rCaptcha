package me.xdani.rcaptcha.utils.menu.pagination;

import lombok.AllArgsConstructor;
import me.xdani.rcaptcha.utils.compatibility.material.CompatibleMaterial;
import me.xdani.rcaptcha.utils.item.ItemBuilder;
import me.xdani.rcaptcha.utils.menu.Button;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
public class PageButton extends Button {

    private final int mod;
    private final PaginatedMenu menu;

    @Override
    public ItemStack getButtonItem(Player player) {
        ItemBuilder itemBuilder = new ItemBuilder(CompatibleMaterial.CARPET.getMaterial());

        if (mod > 0) {
            itemBuilder.setData((short) 13);
        }
        else {
            itemBuilder.setData((short) 14);
        }

        if (this.hasNext(player)) {
            itemBuilder.setName(this.mod > 0 ? "&aNext page" : "&cPrevious page");
        }
        else {
            itemBuilder.setName("&7" + (this.mod > 0 ? "Last page" : "First page"));
        }

        return itemBuilder.build();
    }

    @Override
    public void clicked(Player player, int i, ClickType clickType, int hb) {
        if (hasNext(player)) {
            this.menu.modPage(player, this.mod);
            Button.playNeutral(player);
        } else {
            Button.playFail(player);
        }
    }

    private boolean hasNext(Player player) {
        int pg = this.menu.getPage() + this.mod;
        return pg > 0 && this.menu.getPages(player) >= pg;
    }
}