package fr.xelasflame.vanillaplus;

import fr.xelasflame.vanillaplus.Listener.HammerEvent;
import fr.xelasflame.vanillaplus.Listener.ItemEvent;
import fr.xelasflame.vanillaplus.Listener.SleepEvent;
import fr.xelasflame.vanillaplus.Listener.SpawnerEvent;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class VanillaPlus extends JavaPlugin {
public static VanillaPlus instance ;
    @Override
    public void onEnable() {
        System.out.println("Plugin VanillaPlus is enabled");
        ItemManager.init();
        RecipeManager.init();
        instance = this;
        this.getServer().getPluginManager().registerEvents(new HammerEvent(), this);
        this.getServer().getPluginManager().registerEvents(new SleepEvent(), this);
        this.getServer().getPluginManager().registerEvents(new SpawnerEvent(), this);
        this.getServer().getPluginManager().registerEvents(new ItemEvent(), this);
        for(Player player : this.getServer().getOnlinePlayers()) {
            RecipeManager.updaterecipe(player);
        }
        getCommand("vp").setExecutor(new CommandManager());
    }

    @Override
    public void onDisable() {
        System.out.println("Plugin VanillaPlus is disabled");
    }
}
