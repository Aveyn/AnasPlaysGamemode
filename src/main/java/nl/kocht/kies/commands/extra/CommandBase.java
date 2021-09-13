package nl.kocht.kies.commands.extra;

import nl.kocht.kies.Kies;
import org.bukkit.command.CommandExecutor;

public abstract class CommandBase implements CommandExecutor {

    public CommandBase (String name){
        Kies.getInstance().getCommand(name).setExecutor(this);
    }
}
