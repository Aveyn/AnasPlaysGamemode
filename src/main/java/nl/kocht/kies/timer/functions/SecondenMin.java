package nl.kocht.kies.timer.functions;

import nl.kocht.kies.Kies;
import nl.kocht.kies.utils.CC;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SecondenMin implements Listener {


    @EventHandler
    public void minInteractEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (!(player instanceof Player)) {
            player.sendMessage(CC.translate(Kies.getInstance().getMessagesYML().getConfig().getString("MESSAGES.ONLY-PLAYERS")));
            return;
        }

        if (player.getInventory().getItemInMainHand().equals(watch()));
        if (player.getInventory().contains(new ItemStack(Material.WATCH)));
        player.getInventory().removeItem().get(watch());
        player.sendMessage(CC.translate("&b&lKies &8» &fminInteractEvent"));

    }

    private Object watch() {
        ItemStack watch = new ItemStack(Material.WATCH);
        ItemMeta watchmeta = watch.getItemMeta();
        watchmeta.setDisplayName(CC.translate("&bTimer"));
        watch.setItemMeta(watchmeta);
        return true;
    }
}