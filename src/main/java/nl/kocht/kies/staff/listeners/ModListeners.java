package nl.kocht.kies.staff.listeners;

import nl.kocht.kies.utils.CC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ModListeners implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getWhoClicked() instanceof Player) {
            Player player = (Player) event.getWhoClicked();
            if (player.hasMetadata("modmode")) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (event.getPlayer().hasMetadata("modmode")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(CC.translate("&b&lKies &8» &fU kunt dit niet doen in Mod Mode!"));
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (event.getPlayer().hasMetadata("modmode")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(CC.translate("&b&lKies &8» &fU kunt dit niet doen in Mod Mode!"));
        }
    }

    @EventHandler
    public void onFoodChange(FoodLevelChangeEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (player.hasMetadata("modmode"));
            player.setFoodLevel(40);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player damager = (Player) event.getDamager();
            if (damager.hasMetadata("modmode"));
            event.setCancelled(true);
            damager.sendMessage(CC.translate("&b&lKies &8» &fU kunt dit niet doen in Mod Mode!"));
        }

        if (event.getEntity() instanceof Player) {
            Player victim = (Player) event.getEntity();
            if (victim.hasMetadata("modmode")) {
                event.setCancelled(true);
                victim.sendMessage(CC.translate("&b&lKies &8» &fDeze speler zit in Mod Mode!"));
            }
        }
    }
}
