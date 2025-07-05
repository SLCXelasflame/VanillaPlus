package fr.xelasflame.vanillaplus.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class EnchantMax implements Listener {
    private static HashMap<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();

    public static void init(){
        enchantments.put(Enchantment.FORTUNE, 5);
        enchantments.put(Enchantment.EFFICIENCY, 7);
        enchantments.put(Enchantment.SHARPNESS, 7);
        enchantments.put(Enchantment.PROTECTION, 7);
        enchantments.put(Enchantment.POWER, 7);
        enchantments.put(Enchantment.PROJECTILE_PROTECTION, 7);
        enchantments.put(Enchantment.BLAST_PROTECTION, 7);
        enchantments.put(Enchantment.FIRE_PROTECTION, 7);
    }

    @EventHandler
    public void onAnvil(PrepareAnvilEvent e){
        ItemStack item1 = e.getInventory().getFirstItem();
        ItemStack item2 = e.getInventory().getSecondItem();
        if(item1 == null || item2 == null || e.getResult() == null) return;
        ItemStack result = e.getResult().clone();
        Map<Enchantment, Integer> enchants1 = item1.getEnchantments();
        Map<Enchantment, Integer> enchants2 = item2.getEnchantments();
        if(item1.getType().equals(Material.ENCHANTED_BOOK)){
            enchants1 = ((EnchantmentStorageMeta) item1.getItemMeta()).getStoredEnchants();
        }
        if(item2.getType().equals(Material.ENCHANTED_BOOK)){
            enchants2 = ((EnchantmentStorageMeta) item2.getItemMeta()).getStoredEnchants();
        }
        Map<Enchantment, Integer> finalEnchants = enchants1;
        enchants2.forEach((enchantment, value)->{
            if(enchantments.containsKey(enchantment)){
                if(finalEnchants.containsKey(enchantment)){
                    if(Objects.equals(finalEnchants.get(enchantment), value)){
                        if(enchantments.get(enchantment) > value){
                            value ++;
                        }
                        else value = finalEnchants.get(enchantment);


                    }
                    else{
                        value = Integer.max(value, finalEnchants.get(enchantment));
                    }


                }
                if(result.getType().equals(Material.ENCHANTED_BOOK)){
                    EnchantmentStorageMeta meta = (EnchantmentStorageMeta) result.getItemMeta();
                    meta.removeStoredEnchant(enchantment);
                    meta.addStoredEnchant(enchantment, value, true);
                    result.setItemMeta(meta);

                }
                else{
                    result.removeEnchantment(enchantment);
                    result.addUnsafeEnchantment(enchantment, value);

                }
            }

        });
        e.setResult(result);

    }
}
