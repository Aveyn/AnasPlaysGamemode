package nl.kocht.kies.listener;

import nl.kocht.kies.listener.listeners.PlayerListener;
import nl.kocht.kies.staff.listeners.ModListeners;
import nl.kocht.kies.timer.TimerHandler;
import nl.kocht.kies.timer.functions.SecondenAdd;
import nl.kocht.kies.timer.functions.SecondenMin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class ListenerHandler {

    public ListenerHandler(Plugin plugin) {
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new ModListeners(), plugin);
        pm.registerEvents(new PlayerListener(), plugin);

        pm.registerEvents(new TimerHandler(), plugin);
        pm.registerEvents(new SecondenAdd(), plugin);
        pm.registerEvents(new SecondenMin(), plugin);
    }
}
