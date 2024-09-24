package fr.xelasflame.vanillaplus.Listener;

import fr.xelasflame.vanillaplus.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.BundleMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class ItemEvent implements Listener {

    @EventHandler // Parachute
    public void onFall(PlayerMoveEvent e) {
        ItemStack item = e.getPlayer().getInventory().getItemInMainHand();
        if(item.hasItemMeta() && item.getItemMeta().hasCustomModelData() && item.getItemMeta().getCustomModelData() == 1 && item.getType().equals(Material.STICK)) {

            if (e.getFrom().getY() > e.getTo().getY()) {
                e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 5, 5, false, false, false));
            }

        }
    }

    @EventHandler
    public void OnInv(InventoryClickEvent e) {
        Inventory inv = e.getInventory();
        ItemStack item = e.getCurrentItem();
        ItemStack item2 = e.getCursor();
        if(item == null || item2 == null) {return;}
        if(e.getClick() == ClickType.RIGHT || e.getClick() == ClickType.SHIFT_RIGHT) {
            if(item2.getType().equals(Material.BUNDLE) || item.getType().equals(Material.BUNDLE)) {
                e.setCancelled(true);}

        }

    }

    @EventHandler // portable crafter
    public void onClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if(item.getItemMeta() != null && item.getType().equals(Material.STICK)&& item.getItemMeta().hasCustomModelData() && item.getItemMeta().getCustomModelData() == 2){
            if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
                player.openWorkbench(null, true);
            }
        }

    }


    @EventHandler
    public void onClick2(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if(item == null || item.getType() == Material.AIR){return;}
        if(item.getType().equals(Material.BUNDLE) && item.getItemMeta().hasCustomModelData()){
            if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
                e.setCancelled(true);
                ItemMeta meta =  item.getItemMeta();
                BundleMeta bundleMeta = (BundleMeta) meta;
                Inventory inv = Bukkit.createInventory(player, 9*meta.getCustomModelData(), meta.getDisplayName());
                for (ItemStack elt : bundleMeta.getItems()){
                    if(elt != null){
                        inv.addItem(elt);
                    }
                }

                player.openInventory(inv);
            }
        }
}

    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        Player player = (Player) e.getPlayer();
        Inventory inv = e.getInventory();

        if (e.getView().getTitle().contains("BackPack Tier") || e.getView().getTitle().contains("Gems Bag")) {
            ItemStack item = player.getInventory().getItemInMainHand();
            if (item == null || item.getType() == Material.AIR) {
                return;
            }
            if (item.getType() == Material.BUNDLE && item.hasItemMeta() && item.getItemMeta().hasCustomModelData() && item.getItemMeta().getCustomModelData() == 4) {

                BundleMeta bundlemeta = (BundleMeta) item.getItemMeta();
                bundlemeta.setItems(null);
                    for (ItemStack elt : inv.getContents()){
                        if(elt != null){
                            bundlemeta.addItem(elt);
                        }
                    }
                    item.setItemMeta(bundlemeta);
                    player.getInventory().setItemInMainHand(item);
                    ItemManager.applyGemEffect( player, inv);
                    if(!player.getActivePotionEffects().isEmpty()) {
                        player.sendMessage("§6§lUne étrange sensation te parcours le corp... Tu sens une puissance monter en toi...");
                    }


            }
        }
    }
    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        if (e.getView().getTitle().contains("BackPack Tier")) {
            ItemStack item = e.getCurrentItem();

            if (item != null && item.getType().equals(Material.BUNDLE) && item.hasItemMeta() && item.getItemMeta().hasCustomModelData()) {
                e.setCancelled(true);
                e.getWhoClicked().sendMessage("Vous ne pouvez pas mettre de sac dans un sac ce n'est pas des poupées russes");
            }
        }
    }

    @EventHandler
    public void onInvClick2(InventoryClickEvent e) {
        if (e.getView().getTitle().contains("Gems Bag")) {
            ItemStack item = e.getCurrentItem();

            if (item != null && !item.getType().equals(Material.EMERALD) && !item.hasItemMeta() && !item.getItemMeta().hasCustomModelData()) {
                e.setCancelled(true);
                e.getWhoClicked().sendMessage("Vous ne pouvez mettre que des gems dans ce sac");
            }
        }
    }
    @EventHandler
    public void onClose2(InventoryCloseEvent e){
        Player player = (Player) e.getPlayer();
        boolean text = false;
        if(e.getInventory().getHolder() instanceof Chest) {
            for (ItemStack items : player.getInventory()) {
                if (items.getType().equals(Material.BUNDLE) && items.getItemMeta().getCustomModelData() == 4) {
                    ItemMeta meta = items.getItemMeta();
                    BundleMeta bundleMeta = (BundleMeta) meta;
                    Inventory inv = Bukkit.createInventory(player, 9 * meta.getCustomModelData(), meta.getDisplayName());
                    for (ItemStack elt : bundleMeta.getItems()) {
                        if (elt != null) {
                            inv.addItem(elt);
                        }
                    }
                    ItemManager.applyGemEffect(player, inv);
                    break;
                }

            }
        }
    }
    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        ItemStack droppedItem = event.getItemDrop().getItemStack();
        if (droppedItem.getType().equals(Material.BUNDLE)) {
            if(droppedItem.hasItemMeta() && droppedItem.getItemMeta().hasCustomModelData() && droppedItem.getItemMeta().getCustomModelData() == 4){
                player.clearActivePotionEffects();


            }

        }
    }



    }