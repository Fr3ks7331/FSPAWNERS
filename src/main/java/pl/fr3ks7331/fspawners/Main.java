package pl.fr3ks7331.fspawners;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.fr3ks7331.fspawners.objects.managers.UserManager;
import pl.fr3ks7331.fspawners.listeners.block.BlockPlaceListener;
import pl.fr3ks7331.fspawners.listeners.inventory.AsyncPlayerPreLoginListener;
import pl.fr3ks7331.fspawners.listeners.inventory.InventoryClickListener;
import pl.fr3ks7331.fspawners.listeners.player.PlayerInteractListener;

public class Main extends JavaPlugin {

    private static Main instance;
    public static final UserManager userManager = new UserManager();


    public void onEnable() {
        instance = this;

        registerEvents();
    }

    public void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
        Bukkit.getPluginManager().registerEvents(new BlockPlaceListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new AsyncPlayerPreLoginListener(), this);
    }

    public static Main getInst() {
        return instance;
    }

    public static UserManager getUserManager() {
    return userManager;
}
}