package me.xdani.rcaptcha.utils.item;

import me.xdani.rcaptcha.utils.ChatUtil;
import me.xdani.rcaptcha.utils.compatibility.material.CompatibleMaterial;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.List;

public class ItemBuilder {
    private final ItemStack itemStack;

    public ItemBuilder setEnchant(boolean enchanted) {
        if (enchanted) {
            ItemMeta meta = this.itemStack.getItemMeta();
            meta.addEnchant(Enchantment.DURABILITY, 1, true);

            this.itemStack.setItemMeta(meta);
            
        }
        return this;
    }

    public ItemStack build() {
        return this.itemStack;
    }

    public ItemBuilder setLore(String ... lore) {
        if (lore != null) {
            ItemMeta meta = this.itemStack.getItemMeta();
            meta.setLore(ChatUtil.translate(Arrays.asList(lore)));
            this.itemStack.setItemMeta(meta);
            
        }
        return this;
    }

    public ItemBuilder setEnchant(boolean enchanted, int level) {
        if (enchanted) {
            ItemMeta meta = this.itemStack.getItemMeta();
            meta.addEnchant(Enchantment.DURABILITY, level, true);
            
            this.itemStack.setItemMeta(meta);
            
        }
        return this;
    }

    public ItemBuilder setAmount(int amount) {
        this.itemStack.setAmount(amount);
        return this;
    }

    public ItemBuilder setData(int data) {
        this.itemStack.setDurability((short)data);
        return this;
    }

    public ItemBuilder setName(String name) {
        if (name != null) {
            name = ChatUtil.translate(name);
            ItemMeta meta = this.itemStack.getItemMeta();
            meta.setDisplayName(name);
            this.itemStack.setItemMeta(meta);
            
        }
        return this;
    }

    public ItemBuilder(String material) {
        this.itemStack = new ItemStack(Material.valueOf(material), 1);
    }

    public ItemBuilder setOwner(String owner) {
        if (this.itemStack.getType() == CompatibleMaterial.HUMAN_SKULL.getMaterial()) {
            SkullMeta meta = (SkullMeta)this.itemStack.getItemMeta();
            meta.setOwner(owner);

            this.itemStack.setItemMeta(meta);
            
        }
        return this;
    }

    public ItemBuilder setEnchant(boolean enchanted, Enchantment enchantment, int level) {
        if (enchanted) {
            ItemMeta meta = this.itemStack.getItemMeta();
            meta.addEnchant(enchantment, level, true);

            this.itemStack.setItemMeta(meta);
            
        }
        return this;
    }


    public ItemBuilder(int id) {
        this.itemStack = new ItemStack(id, 1);
    }

    public ItemBuilder(Material material, int id) {
        this.itemStack = new ItemStack(material, 1, (short)id);
    }

    public ItemBuilder(Material material, int amount, int id) {
        this.itemStack = new ItemStack(material, amount, (short)id);
    }

    public ItemBuilder setLore(List<String> lore) {
        if (lore != null) {
            ItemMeta meta = this.itemStack.getItemMeta();
            meta.setLore(ChatUtil.translate(lore));
            this.itemStack.setItemMeta(meta);
            
        }
        return this;
    }

    public ItemBuilder(ItemStack item) {
        this.itemStack = item.clone();
    }

    public ItemBuilder(Material material) {
        this.itemStack = new ItemStack(material, 1);
    }

    public ItemBuilder setArmorColor(Color color) {
        LeatherArmorMeta meta = (LeatherArmorMeta)this.itemStack.getItemMeta();
        meta.setColor(color);
        this.itemStack.setItemMeta(meta);
        
        return this;
    }
}

