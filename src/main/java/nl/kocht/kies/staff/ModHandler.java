package nl.kocht.kies.staff;

import lombok.AllArgsConstructor;
import lombok.Getter;
import nl.kocht.kies.Kies;
import nl.kocht.kies.utils.CC;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ModHandler {

    private static Map<UUID, ModCache> modCacheMap = new HashMap<>();

    public static boolean isModMode(Player player) {
        return player.hasMetadata("modmode");
    }

    public static void toggleModMode(Player player, boolean silent) {
        boolean newState = !isModMode(player);

        if (!silent)
            player.sendMessage(CC.translate("&b&lKies &8» &fMod Mode: " + (newState ? ("&aEnabled") : ("&cDisabled"))));

        if (newState) {
            player.setMetadata("modmode", new FixedMetadataValue(Kies.getInstance(), true));

            ModCache cache = new ModCache(player);
            modCacheMap.put(player.getUniqueId(), cache);

            player.getInventory().clear();
            player.getInventory().setArmorContents(null);

            if (player.hasPermission("kies.gamemode.creative")) {
                player.setGameMode(GameMode.CREATIVE);
            } else {
                    player.setGameMode(GameMode.SURVIVAL);
                    player.setAllowFlight(true);
                    player.setFlying(true);
                }
                player.getInventory().setItem(0, StaffItems.GOED);
                player.getInventory().setItem(1, StaffItems.FOUT);
                player.getInventory().setItem(8, StaffItems.TIMER);

                Bukkit.getPluginManager().callEvent(new ModModeEnterEvent(player));
                player.sendMessage(CC.translate("&b&lKies &8» &fMod mode aangezet!"));
            } else{
                player.removeMetadata("modmode", Kies.getInstance());

                ModCache cache = modCacheMap.remove(player.getUniqueId());
                if (cache != null)
                    cache.restore(player);

                if (player.getGameMode() != GameMode.CREATIVE)
                    player.setAllowFlight(false);
                Bukkit.getPluginManager().callEvent(new ModModeExitEvent(player));
            player.sendMessage(CC.translate("&b&lKies &8» &fMod mode uitgezet!"));
            }
        player.updateInventory();
    }

    @Getter
    @AllArgsConstructor
    protected static class ModCache {
        private ItemStack[] inventory;
        private ItemStack[] armor;
        private GameMode gameMode;

        public ModCache(Player player) {
            this.inventory = player.getInventory().getContents();
            this.armor = player.getInventory().getArmorContents();
            this.gameMode = player.getGameMode();
        }

        public void restore(Player player) {
            player.getInventory().setContents(inventory);
            player.getInventory().setArmorContents(armor);
            player.setGameMode(gameMode);
        }

    }

    public static class StaffItems {
        public static ItemStack GOED = ModHandler.build(Material.WOOL, 1, (byte)5, ChatColor.GREEN + "Goed Antwoord", ChatColor.DARK_GREEN + "Zeg dat het antwoord goed is!");
        public static ItemStack FOUT = ModHandler.build(Material.WOOL, 1, (byte)14, ChatColor.RED + "Fout Antwoord", ChatColor.DARK_RED + "Zeg dat het antwoord fout is!");
        public static ItemStack TIMER = build(Material.WATCH, ChatColor.AQUA + "Timer",  ChatColor.BLUE + "Stel de tijd in!");

        public static ItemStack build(Material type, String displayName, String lore) {
            return ModHandler.build(type, 1, (byte)0, displayName, lore);
        }
    }

    public static ItemStack build(Material type, int amount, byte data, String displayname, String lore) {
        ItemStack stack = new ItemStack(type, amount, (short)1, data);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayname));
        stack.setItemMeta(meta);
        return stack;
    }
}
