package fr.xelasflame.vanillaplus;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Gems {
    public static ArrayList<Gems> gems_list = new ArrayList<>();
    public static ArrayList<PotionEffectType> gems_effect = new ArrayList<>();
    private static int index =0;

    private String name;
    private ChatColor color;
    private PotionEffectType potion;
    private List<String> lore;
    private int amplifier;
    private ItemStack item;


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

}
