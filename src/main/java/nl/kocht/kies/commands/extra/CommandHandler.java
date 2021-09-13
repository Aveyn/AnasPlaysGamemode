package nl.kocht.kies.commands.extra;

import nl.kocht.kies.commands.Help;
import nl.kocht.kies.staff.commands.ModModeCommand;

public class CommandHandler {

    public CommandHandler() {
        new Help();
        new ModModeCommand();
    }
}


