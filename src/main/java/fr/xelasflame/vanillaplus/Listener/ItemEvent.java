package fr.xelasflame.vanillaplus.Listener;

import fr.xelasflame.vanillaplus.Gems;
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
import org.bukkit.event.player.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.BundleMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.time.LocalDate;
import java.util.*;


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
            if (item.getType() == Material.BUNDLE && item.hasItemMeta() && item.getItemMeta().hasCustomModelData() && item.getItemMeta().getCustomModelData() <= 4) {

                BundleMeta bundlemeta = (BundleMeta) item.getItemMeta();
                bundlemeta.setItems(null);
                    for (ItemStack elt : inv.getContents()){
                        if(elt != null){
                            bundlemeta.addItem(elt);
                        }
                    }
                    item.setItemMeta(bundlemeta);
                    player.getInventory().setItemInMainHand(item);
                    if(item.getItemMeta().getCustomModelData() == 4){ItemManager.applyGemEffect( player, inv);
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
            for (ItemStack items : player.getInventory().getContents()) {
                if(items != null) {
                    if (items.getType().equals(Material.BUNDLE) && items.getItemMeta().getCustomModelData() == 4) {
                        ItemMeta meta = items.getItemMeta();
                        BundleMeta bundleMeta = (BundleMeta) meta;
                        Inventory inv = Bukkit.createInventory(player, 9 * 4, meta.getDisplayName());
                        for (ItemStack elt : bundleMeta.getItems()) {
                            if (elt != null) {
                                inv.addItem(elt);
                            }
                        }
                        ItemManager.applyGemEffect(player, inv);
                        break;
                    }
                    else{
                        for(PotionEffectType effect : Gems.gems_effect) {
                            player.removePotionEffect(effect);
                        }
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


    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        LocalDate date = LocalDate.now();
        if(date.getMonthValue() == 12 && date.getDayOfMonth() == 25){
            Bukkit.getWorld(player.getWorld().getUID()).dropItem(player.getLocation(), ItemManager.chrismascup);
        }
    }

    @EventHandler
    public void onEat(PlayerItemConsumeEvent e){
        ItemStack item = e.getItem();
        Player player = e.getPlayer();
        if(item.getType().equals(Material.COOKIE) && item.hasItemMeta() && item.getItemMeta().hasCustomModelData()){
            switch (item.getItemMeta().getCustomModelData()){
                case 1:
                    player.sendMessage("Tu sens le sucre te parcourir les veines... Seul ta chance pourra te sauver");
                    switch ( (int)(Math.random() * 5)){
                        case 0:
                            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5*60*20, 1, true, false));
                            break;
                        case 1:
                            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP_BOOST, 5*60*20, 1, true, false));
                            break;
                        case 2:
                            player.addPotionEffect(new PotionEffect(PotionEffectType.HASTE, 5*60*20, 1, true, false));
                            break;
                        case 3:
                            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 5*60*20, 1, true, false));
                            break;
                        case 4:
                            player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 5*60*20, 1, true, false));
                            break;
                        case 5:
                            player.addPotionEffect(new PotionEffect(PotionEffectType.MINING_FATIGUE, 5*60*20, 1, true, false));
                            break;
                        case 6:
                            player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 5*60*20, 1, true, false));
                            break;
                        case 7:
                            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 5*60*20, 5, true, false));
                            break;


                    }
                    break;

            }
        }
    }

    }