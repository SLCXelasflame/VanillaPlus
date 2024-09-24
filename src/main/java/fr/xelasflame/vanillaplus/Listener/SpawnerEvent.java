package fr.xelasflame.vanillaplus.Listener;

import fr.xelasflame.vanillaplus.ItemManager;
import org.bukkit.*;

import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import static fr.xelasflame.vanillaplus.VanillaPlus.instance;

public class SpawnerEvent implements Listener {

    @EventHandler
    public static void onBreak(BlockBreakEvent event) {
        if (!event.getBlock().getType().equals(Material.SPAWNER))
            return;
        if (event.getPlayer().getGameMode().equals(GameMode.CREATIVE))
            return;
        if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.AIR))
            return;

        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
        if(ItemManager.isPickaxe(item)){
        event.setExpToDrop(0);
        event.setDropItems(false);
        Location loc = event.getBlock().getLocation();
        World world = event.getBlock().getWorld();
        ItemStack itemSpawner;
        if(((CreatureSpawner)event.getBlock().getState()).getSpawnedType() == null){return;}
        itemSpawner = setType(new ItemStack(Material.SPAWNER), ((CreatureSpawner)event.getBlock().getState()).getSpawnedType());
        ItemMeta meta = itemSpawner.getItemMeta();
        meta.setDisplayName(((CreatureSpawner)event.getBlock().getState()).getSpawnedType().getName());
        itemSpawner.setItemMeta(meta);
        world.dropItemNaturally(loc, itemSpawner);
    }}


    @EventHandler
    public static void onPlace(BlockPlaceEvent event) {
        if (!event.getBlock().getType().equals(Material.SPAWNER))
            return;
        EntityType type = null;
        type = getType(event.getItemInHand());
        if (type == null)
            return;

        CreatureSpawner spawner = (CreatureSpawner) event.getBlock().getState();
        spawner.setSpawnedType(type);

        spawner.setMaxNearbyEntities(6);
        spawner.setMaxSpawnDelay(800);
        spawner.setMinSpawnDelay(200);
        spawner.setRequiredPlayerRange(16);
        spawner.setSpawnCount(4);
        spawner.setSpawnRange(4);
        spawner.update();
    }

    public static EntityType getType(ItemStack itemStack) {

        ItemStack itemStack2 = itemStack.clone();
        NamespacedKey key = new NamespacedKey(instance, "MobType");
        ItemMeta meta = itemStack2.getItemMeta();
        PersistentDataContainer container = meta.getPersistentDataContainer();

        if (!container.has(key, PersistentDataType.STRING))
            return null;

        String mob = container.get(key, PersistentDataType.STRING);

        EntityType entity = null;
        try {
            entity = EntityType.valueOf(mob);
        } catch (Exception ignore) {}

        return entity;
    }

    public static ItemStack setType(ItemStack itemStack, EntityType type) {
        ItemStack itemStack2 = itemStack.clone();
        NamespacedKey key = new NamespacedKey(instance, "MobType");
        ItemMeta meta = itemStack2.getItemMeta();
        meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, type.name());
        itemStack2.setItemMeta(meta);

        return itemStack2;
    }
    }
