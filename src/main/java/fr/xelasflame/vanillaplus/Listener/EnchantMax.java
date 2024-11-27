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
        if(item1 == null || item2 == null) return;
        ItemStack result = item1.clone();

        if(!item1.getType().equals(item2.getType())){
            if(item2.getType().equals(Material.ENCHANTED_BOOK)){
                EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item2.getItemMeta();
                for(Enchantment enchantment : meta.getStoredEnchants().keySet()){
                    if(item1.containsEnchantment(enchantment)){
                        if(item1.getEnchantmentLevel(enchantment) == meta.getStoredEnchantLevel(enchantment)) {
                            if (enchantments.get(enchantment) > meta.getStoredEnchantLevel(enchantment)) {
                                result.addUnsafeEnchantment(enchantment, meta.getStoredEnchantLevel(enchantment) + 1);

                            } else if (Objects.equals(enchantments.get(enchantment), meta.getStoredEnchantLevel(enchantment))) {

                                result.addUnsafeEnchantment(enchantment, meta.getStoredEnchantLevel(enchantment));
                            }
                            e.setResult(result);
                        }
                       
                    }
                }


            }
            return;
        }
        if(item1.getType().equals(Material.ENCHANTED_BOOK)){
            EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item1.getItemMeta();
            EnchantmentStorageMeta meta2 = (EnchantmentStorageMeta) item2.getItemMeta();
            EnchantmentStorageMeta metaresult = (EnchantmentStorageMeta) result.getItemMeta();
            for(Enchantment enchantment : meta2.getStoredEnchants().keySet()){
                if(meta.hasStoredEnchant(enchantment)){
                    if(meta.getStoredEnchantLevel(enchantment) == meta2.getStoredEnchantLevel(enchantment)) {
                        if (enchantments.get(enchantment) > meta.getStoredEnchantLevel(enchantment)) {
                            metaresult.removeStoredEnchant(enchantment);
                            metaresult.addStoredEnchant(enchantment, meta.getStoredEnchantLevel(enchantment) + 1, true);
                        } else if (Objects.equals(enchantments.get(enchantment), meta.getStoredEnchantLevel(enchantment))) {

                            metaresult.removeStoredEnchant(enchantment);
                            metaresult.addStoredEnchant(enchantment, meta.getStoredEnchantLevel(enchantment), true);
                        }
                        result.setItemMeta(metaresult);
                        e.setResult(result);
                    }

                }


                }

        }
        for(Enchantment enchant : item2.getEnchantments().keySet()){
            if(item1.containsEnchantment(enchant) && enchantments.containsKey(enchant)) {
                if (item1.getEnchantments().get(enchant).equals(item2.getEnchantments().get(enchant))) {
                    if (enchantments.get(enchant) > item1.getEnchantments().get(enchant)) {
                        result.addUnsafeEnchantment(enchant, item1.getEnchantments().get(enchant)+1);
                    }
                    else if(Objects.equals(enchantments.get(enchant), item1.getEnchantments().get(enchant))){

                        result.addUnsafeEnchantment(enchant, item1.getEnchantments().get(enchant));
                    }
                    e.setResult(result);

                }

            }

        }

    }
}
