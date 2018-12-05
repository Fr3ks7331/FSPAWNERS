package pl.fr3ks7331.fspawners.listeners.inventory;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import pl.fr3ks7331.fspawners.Main;
import pl.fr3ks7331.fspawners.objects.managers.UserManager;

import java.util.UUID;

public class AsyncPlayerPreLoginListener
        implements Listener
{
    @EventHandler
    private void onPlayerPreLoginEvent(AsyncPlayerPreLoginEvent event)
    {
        UserManager userManager = Main.getUserManager();
        UUID uuid = event.getUniqueId();
        if (!userManager.isUser(uuid))
        {
            userManager.register(uuid, event.getName());
            return;
        }
    }
}

