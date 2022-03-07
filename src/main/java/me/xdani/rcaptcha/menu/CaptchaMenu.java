package me.xdani.rcaptcha.menu;

import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import me.xdani.rcaptcha.handlers.CaptchaHandler;
import me.xdani.rcaptcha.services.MainService;
import me.xdani.rcaptcha.utils.ChatUtil;
import me.xdani.rcaptcha.utils.JavaUtil;
import me.xdani.rcaptcha.utils.compatibility.material.CompatibleMaterial;
import me.xdani.rcaptcha.utils.item.ItemBuilder;
import me.xdani.rcaptcha.utils.menu.Button;
import me.xdani.rcaptcha.utils.menu.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class CaptchaMenu extends Menu {

    @Override
    public String getTitle(Player player) {
        return ChatUtil.translate(MainService.MENU_TITLE);
    }

    @Override
    public int getSize() {
        return MainService.MENU_ROWS * 9;
    }

    @Override
    public boolean canPlayerClose(Player player) {
        return CaptchaHandler.captchaPassed(player);
    }

    @Override
    public boolean isUpdateAfterClick() {
        return false;
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        HashMap<Integer, Button> buttons = Maps.newHashMap();

        int woolData = JavaUtil.randomNumber(15);
        int slot = JavaUtil.randomNumber(getSize());

        for (int i = 0; i < getSize(); i++) {

            if(i == slot) continue;

            int randomWool = JavaUtil.randomNumberWithExclusionWithoutMin(15, woolData);
            buttons.put(i, new RandomWool(randomWool));
        }

        buttons.put(slot, new CorrectWool(woolData));


        return buttons;
    }

    @AllArgsConstructor
    private static class RandomWool extends Button {

        private final int data;

        @Override
        public ItemStack getButtonItem(Player player) {
            return new ItemBuilder(CompatibleMaterial.WOOL.getMaterial()).setData(data).setName(MainService.RANDOM_WOOL_NAME).setLore(MainService.RANDOM_WOOL_LORE).setEnchant(MainService.RANDOM_WOOL_GLOW).build();
        }

        @Override
        public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
            Button.playFail(player);
            player.kickPlayer(MainService.KICK_BAD_ITEM);
        }
    }

    @AllArgsConstructor
    private static class CorrectWool extends Button {

        private final int data;

        @Override
        public ItemStack getButtonItem(Player player) {
            return new ItemBuilder(CompatibleMaterial.WOOL.getMaterial()).setData(data).setName(MainService.CORRECT_WOOL_NAME).setLore(MainService.CORRECT_WOOL_LORE).setEnchant(MainService.CORRECT_WOOL_GLOW).build();
        }

        @Override
        public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
            CaptchaHandler.CAPTCHA_PASSED.add(player.getUniqueId());

            Button.playSuccess(player);

            ChatUtil.sendMessage(player, MainService.CAPTCHA_PASSED);

            player.closeInventory();
        }
    }
}
