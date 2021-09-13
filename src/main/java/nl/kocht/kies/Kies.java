package nl.kocht.kies;

import lombok.Getter;
import lombok.SneakyThrows;
import nl.kocht.kies.commands.extra.CommandHandler;
import nl.kocht.kies.listener.ListenerHandler;
import nl.kocht.kies.utils.CC;
import nl.kocht.kies.utils.YamlDoc;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.ArrayList;

public final class Kies extends JavaPlugin {

    private static Kies instance;
    @Getter private YamlDoc messagesYML;
    @Getter private YamlDoc settingsYML;

    public static Kies getInstance() {
        return instance;
    }

    public void onLoad() {
        instance = this;
        this.saveDefaultConfig();
    }

    @SneakyThrows
    @Override
    public void onEnable() { //TODO: KIJKEN OF DE PLUGIN WERKT!
        registerHandlers();
        registerConfigs();
        ArrayList<String> Msges = new ArrayList();
        Msges.add("&7&m---------------------------------------");
        Msges.add(" ");
        Msges.add("&7[&b&lKies&7] &fhas been &aenabled");
        Msges.add("&7[&b&lKies&7] &fcoded by &bDev&f Team!");
        Msges.add(" ");
        Msges.add("&7&m---------------------------------------");
        CC.translate(Msges).forEach(Bukkit.getServer().getConsoleSender() :: sendMessage);

    }

    @Override
    public void onDisable() {
        ArrayList<String> Msges = new ArrayList();
        Msges.add("&7&m---------------------------------------");
        Msges.add(" ");
        Msges.add("&7[&b&lKies&7] &fhas been &cdisabled!");
        Msges.add("&7[&b&lKies&7] &fcoded by &bDev&f Team!");
        Msges.add(" ");
        Msges.add("&7&m---------------------------------------");
        CC.translate(Msges).forEach(Bukkit.getServer().getConsoleSender() :: sendMessage);
    }

    public void registerHandlers() {
        new ListenerHandler(this);
        new CommandHandler();
    }

    public void registerConfigs() throws IOException {
        messagesYML = new YamlDoc(getDataFolder(), "messages.yml");
        messagesYML.init();
        settingsYML = new YamlDoc(getDataFolder(), "settings.yml");
        settingsYML.init();
    }
}
