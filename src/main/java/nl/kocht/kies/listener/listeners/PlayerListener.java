package nl.kocht.kies.listener.listeners;

import nl.kocht.kies.Kies;
import nl.kocht.kies.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

    public Location getSpawn() {
        World world = Bukkit.getServer().getWorld(Kies.getInstance().getSettingsYML().getConfig().getString("SPAWN.WORLD"));
        double x = Kies.getInstance().getSettingsYML().getConfig().getDouble("SPAWN.X");
        double y = Kies.getInstance().getSettingsYML().getConfig().getDouble("SPAWN.Y");
        double z = Kies.getInstance().getSettingsYML().getConfig().getDouble("SPAWN.Z");
        return new Location(world, x, y, z);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!player.hasPlayedBefore()) {
            player.teleport(getSpawn());
        }

        for (String string : Kies.getInstance().getMessagesYML().getConfig().getStringList("MESSAGES.JOIN-MESSAGE")) {
            player.sendMessage(CC.translate(string).replaceAll("%player%", event.getPlayer().getDisplayName()));
        }
    }
}
