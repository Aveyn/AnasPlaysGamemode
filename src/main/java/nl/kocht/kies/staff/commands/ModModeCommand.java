package nl.kocht.kies.staff.commands;

import nl.kocht.kies.Kies;
import nl.kocht.kies.commands.extra.CommandBase;
import nl.kocht.kies.staff.ModHandler;
import nl.kocht.kies.utils.CC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ModModeCommand extends CommandBase {

    public ModModeCommand() {
        super("mod");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] args) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(CC.translate(Kies.getInstance().getMessagesYML().getConfig().getString("MESSAGES.ONLY-PLAYERS")));
            return true;
        }
        Player player = (Player) commandSender;
        if (!player.hasPermission("kies.modmode")) {
            player.sendMessage(Kies.getInstance().getMessagesYML().getConfig().getString("MESSAGES.NO-PERMISSIONS"));
            return true;
        }
        ModHandler.toggleModMode(player, true);
        return true;
    }
}
