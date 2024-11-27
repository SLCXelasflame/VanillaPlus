package fr.xelasflame.vanillaplus;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Gems {
    public static ArrayList<Gems> gems_list = new ArrayList<>();
    public static ArrayList<PotionEffectType> gems_effect = new ArrayList<>();
    private static int index =1;

    private String name;
    private ChatColor color;
    private PotionEffectType potion;
    private List<String> lore;
    private int amplifier;
    private ItemStack item;
    private static final NamespacedKey IS_GEMS = new NamespacedKey(JavaPlugin.getProvidingPlugin(VanillaPlus.class), "is_gems");


    public Gems(String name, ChatColor color, List<String> lore, PotionEffectType potion, int amplifier){
        this.name = name;
        this.color = color;
        this.potion = potion;
        this.amplifier = amplifier;
        this.lore = lore;
        item = new ItemStack(Material.EMERALD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color + name);
        meta.setCustomModelData(index++);
        meta.setLore(lore);
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(IS_GEMS, PersistentDataType.BYTE, (byte) 1);
        item.setItemMeta(meta);
        gems_list.add(this);
        gems_effect.add(potion);
    }


    public String getName(){
        return name;
    }

    public ChatColor getColor(){
        return color;
    }
    public List<String> getlore(){
        return lore;
    }
    public void setPotion(Player player){
        player.addPotionEffect(new PotionEffect(potion, PotionEffect.INFINITE_DURATION, amplifier, true, false, false));
    }

    public ItemStack getItem(){
        return item;
    }
    public String toString(){
        return color+ " " + name + " : " + potion.getName() + " " + amplifier;
    }
    public static boolean isGems(ItemStack item) {
        if (item == null || !item.hasItemMeta()) return false;
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer container = meta.getPersistentDataContainer();
        return container.has(IS_GEMS, PersistentDataType.BYTE);
    }
}
