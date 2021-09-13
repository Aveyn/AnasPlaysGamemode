package nl.kocht.kies.timer;

import nl.kocht.kies.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TimerHandler implements Listener {

    public static void openTijdGUI(Player player) {
        Inventory inventory = Bukkit.createInventory(player, 9, CC.translate("&b&lTijd Kiezer"));

        ItemStack empty = new ItemStack(Material.GLASS, 1, (byte)0);
        ItemMeta emptyMeta = empty.getItemMeta();
        empty.setItemMeta(emptyMeta);

        ItemStack plus1 = new ItemStack(Material.WOOL, 1, (byte)5);
        ItemMeta plus1meta = plus1.getItemMeta();
        plus1meta.setDisplayName(CC.translate("&a+1 Seconden"));
        plus1.setItemMeta(plus1meta);

        ItemStack min1 = new ItemStack(Material.WOOL, 1, (byte)14);
        ItemMeta min1meta = min1.getItemMeta();
        min1meta.setDisplayName(CC.translate("&c-1 Seconden"));
        min1.setItemMeta(min1meta);

        ItemStack confirm = new ItemStack(Material.WOOL, 1, (byte)14);
        ItemMeta confirmMeta = confirm.getItemMeta();
        confirmMeta.setDisplayName(CC.translate("&a&lConfirm"));
        confirm.setItemMeta(confirmMeta);

        inventory.setItem(0, plus1);
        inventory.setItem(1, empty);
        inventory.setItem(2, empty);
        inventory.setItem(3, empty);
        inventory.setItem(4, confirm);
        inventory.setItem(5, empty);
        inventory.setItem(6, empty);
        inventory.setItem(7, empty);
        inventory.setItem(8, min1);

        player.openInventory(inventory);

    }
}
