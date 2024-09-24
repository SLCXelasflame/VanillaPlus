package fr.xelasflame.vanillaplus.Listener;

import fr.xelasflame.vanillaplus.ItemManager;
import fr.xelasflame.vanillaplus.RecipeManager;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;


public class HammerEvent implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        RecipeManager.updaterecipe(event.getPlayer());

    }
    @EventHandler
    public static void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if(ItemManager.isPickaxe(item) && item.getItemMeta().hasCustomModelData()){ // Le hammer est une pioche avec le customModelData 1
            if(item.getItemMeta().getCustomModelData() == 1 ) {
                BlockFace face = player.getTargetBlockFace(5);
                Location loc = event.getBlock().getLocation();
                World world = player.getWorld();
                player.sendMessage("Face " + face.toString());
                if (face == BlockFace.DOWN || face == BlockFace.UP) {
                    loc.setX(loc.getX() - 1);
                    loc.setZ(loc.getZ() - 1);
                    world.getBlockAt(loc).breakNaturally(); //Bas Gauche
                    loc.setX(loc.getX() + 1);
                    world.getBlockAt(loc).breakNaturally(); // Bas
                    loc.setX(loc.getX() + 1);
                    world.getBlockAt(loc).breakNaturally(); // Bas Droite
                    loc.setZ(loc.getZ() + 1);
                    world.getBlockAt(loc).breakNaturally(); // Mid Droite
                    loc.setZ(loc.getZ() + 1);
                    world.getBlockAt(loc).breakNaturally(); // Haut Droite
                    loc.setX(loc.getX() - 1);
                    world.getBlockAt(loc).breakNaturally(); // Haut
                    loc.setX(loc.getX() - 1);
                    world.getBlockAt(loc).breakNaturally(); //Haut Gauche
                    loc.setZ(loc.getZ() - 1);
                    world.getBlockAt(loc).breakNaturally(); // Mid Gauche
                } else if (face == BlockFace.EAST || face == BlockFace.WEST) {
                    loc.setY(loc.getY() - 1);
                    loc.setZ(loc.getZ() - 1);
                    world.getBlockAt(loc).breakNaturally(); //Bas Gauche
                    loc.setZ(loc.getZ() + 1);
                    world.getBlockAt(loc).breakNaturally(); // Bas
                    loc.setZ(loc.getZ() + 1);
                    world.getBlockAt(loc).breakNaturally(); // Bas Droite
                    loc.setY(loc.getY() + 1);
                    world.getBlockAt(loc).breakNaturally(); // Mid Droite
                    loc.setY(loc.getY() + 1);
                    world.getBlockAt(loc).breakNaturally(); // Haut Droite
                    loc.setZ(loc.getZ() - 1);
                    world.getBlockAt(loc).breakNaturally(); // Haut
                    loc.setZ(loc.getZ() - 1);
                    world.getBlockAt(loc).breakNaturally(); //Haut Gauche
                    loc.setY(loc.getY() - 1);
                    world.getBlockAt(loc).breakNaturally(); // Mid Gauche
                } else {
                    loc.setY(loc.getY() - 1);
                    loc.setX(loc.getX() - 1);
                    world.getBlockAt(loc).breakNaturally(); //Bas Gauche
                    loc.setX(loc.getX() + 1);
                    world.getBlockAt(loc).breakNaturally(); // Bas
                    loc.setX(loc.getX() + 1);
                    world.getBlockAt(loc).breakNaturally(); // Bas Droite
                    loc.setY(loc.getY() + 1);
                    world.getBlockAt(loc).breakNaturally(); // Mid Droite
                    loc.setY(loc.getY() + 1);
                    world.getBlockAt(loc).breakNaturally(); // Haut Droite
                    loc.setX(loc.getX() - 1);
                    world.getBlockAt(loc).breakNaturally(); // Haut
                    loc.setX(loc.getX() - 1);
                    world.getBlockAt(loc).breakNaturally(); //Haut Gauche
                    loc.setY(loc.getY() - 1);
                    world.getBlockAt(loc).breakNaturally(); // Mid Gauche
                }

            }
        }
    }

    @EventHandler
    public static void onEnchant(EnchantItemEvent event){
        ItemStack item = event.getItem();
        if(item.getItemMeta().hasCustomModelData()) {
            if (ItemManager.isPickaxe(item) && item.getItemMeta().getCustomModelData() == 1) {
                if (event.getEnchantsToAdd().containsKey(Enchantment.FORTUNE)) {
                    event.getEnchantsToAdd().remove(Enchantment.FORTUNE);
                    event.getEnchanter().sendMessage("Vous ne pouvez enchanter cet objet avec l'enchantement fortune");
                }
            }
        }
    }

    @EventHandler
    public void onPrepareAnvil(PrepareAnvilEvent event) {
        ItemStack leftItem = event.getInventory().getItem(0);
        ItemStack resultItem = event.getInventory().getItem(2);
        if(leftItem == null || !leftItem.hasItemMeta() ||!leftItem.getItemMeta().hasCustomModelData()) {return;}
        if(leftItem.getItemMeta().hasCustomModelData()) {
            if (ItemManager.isPickaxe(leftItem) && leftItem.getItemMeta().getCustomModelData() == 1) {
                if (resultItem.containsEnchantment(Enchantment.FORTUNE)) {
                    resultItem.removeEnchantment(Enchantment.FORTUNE);
                    event.setResult(resultItem);

                }
            }
        }
    }
}
