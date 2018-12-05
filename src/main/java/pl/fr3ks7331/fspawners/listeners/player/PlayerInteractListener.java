package pl.fr3ks7331.fspawners.listeners.player;

import java.util.concurrent.TimeUnit;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import pl.fr3ks7331.fspawners.Main;
import pl.fr3ks7331.fspawners.objects.User;
import pl.fr3ks7331.fspawners.objects.managers.UserManager;
import pl.fr3ks7331.fspawners.utils.SpawnerUtil;

public class PlayerInteractListener implements Listener {

        @EventHandler
        public void onPlayerInteractEvent(PlayerInteractEvent event) {
            Block block = event.getClickedBlock();
            if (event.getAction() != Action.RIGHT_CLICK_BLOCK) {
                return;
            }
            if (block == null) {
                return;
            }
            if (block.getType() != Material.MOB_SPAWNER) {
                return;
            }
            Player player = event.getPlayer();
            UserManager userManager = Main.getUserManager();
            User user = userManager.getUser(player);
            if (user.canChangeSpawner()) {
                SpawnerUtil.openMenu(player);
            } else {
                player.sendMessage("&cPrzed ponowna zmiana odczekaj: &7" + TimeUnit.MILLISECONDS.toSeconds(user.getTimeLeft()) + " sekund");
                return;
            }
        }

}