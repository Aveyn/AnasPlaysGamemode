package nl.kocht.kies.commands;

import nl.kocht.kies.Kies;
import nl.kocht.kies.commands.extra.CommandBase;
import nl.kocht.kies.utils.CC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Help extends CommandBase {

    public Help() {
        super("kieshelp");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] args) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(CC.translate(Kies.getInstance().getMessagesYML().getConfig().getString("MESSAGES.ONLY.PLAYERS")));
            return true;
        }

        if (args.length < 1) {
            sendHelpMessage(((Player) commandSender).getPlayer());
        }
        return false;
    }

    public void sendHelpMessage(Player player) {
        player.sendMessage(CC.translate("&7&m---------------------------------------"));
        player.sendMessage(CC.translate(" "));
        player.sendMessage(CC.translate("&b&l/kies start &8» &fStart het event"));
        player.sendMessage(CC.translate("&b&l/kies stop &8» &fStopt het event"));
        player.sendMessage(CC.translate("&b&l/kies reset &8» &fReset het event"));
        player.sendMessage(CC.translate(" "));
        player.sendMessage(CC.translate("&7&m---------------------------------------"));
    }
}
