package fr.xelasflame.vanillaplus;

import fr.xelasflame.vanillaplus.Listener.*;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

public final class VanillaPlus extends JavaPlugin {
public static VanillaPlus instance ;

    @Override
    public void onEnable() {
        instance = this;
        instance.getLogger().warning("Plugin VanillaPlus is now enable");
        ItemManager.init();
        RecipeManager.init();
        EnchantMax.init();
        this.getServer().getPluginManager().registerEvents(new HammerEvent(), this);
        this.getServer().getPluginManager().registerEvents(new SleepEvent(), this);
        this.getServer().getPluginManager().registerEvents(new SpawnerEvent(), this);
        this.getServer().getPluginManager().registerEvents(new ItemEvent(), this);
        this.getServer().getPluginManager().registerEvents(new EnchantMax(), this);
        for(Player player : this.getServer().getOnlinePlayers()) {
            RecipeManager.updaterecipe(player);
            player.sendMessage("Le plugin VanillaPlus viens d'être activé, n'oubliez pas de déco-reco pour récupérer les recettes customisées");
        }
        getCommand("vp").setExecutor(new CommandManager());


    }

    @Override
    public void onDisable() {
        instance.getLogger().warning("Plugin VanillaPlus is now disable");

    }
}
