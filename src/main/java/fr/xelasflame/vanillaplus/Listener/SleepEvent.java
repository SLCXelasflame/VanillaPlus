package fr.xelasflame.vanillaplus.Listener;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;



public class SleepEvent implements Listener {

    @EventHandler
    public void onSleep(PlayerBedEnterEvent e) {
        e.setCancelled(true);
        e.getPlayer().getWorld().setTime(0);
        e.getPlayer().getWorld().setWeatherDuration(0);
    }



    }



