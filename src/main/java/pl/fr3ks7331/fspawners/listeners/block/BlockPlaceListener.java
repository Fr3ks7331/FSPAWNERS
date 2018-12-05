package pl.fr3ks7331.fspawners.listeners.block;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import pl.fr3ks7331.fspawners.Main;
import pl.fr3ks7331.fspawners.objects.User;
import pl.fr3ks7331.fspawners.utils.ChatUtil;
import pl.fr3ks7331.fspawners.utils.LocationUtil;
import pl.fr3ks7331.fspawners.utils.SpawnerUtil;

public class BlockPlaceListener implements Listener {


	@EventHandler(priority=EventPriority.LOW)
	public void BlockPlace(BlockPlaceEvent e) {
		if(e.isCancelled()) {
			return;
		}
		Block block = e.getBlock();
		Player p = e.getPlayer();

		User user = Main.userManager.getUser(p);

		
		ArrayList<Block> blocks = LocationUtil.getBlocks(block, 1);
		blocks.remove(block);
		if(block.getType() == Material.MOB_SPAWNER) {
			for(Block b : blocks ) {
				if(b.getType() == Material.MOB_SPAWNER) {
					p.sendMessage(ChatUtil.fixColors("&7Odstep pomiedzy spawnerami powinien wynosic 1 kratke."));
					e.setCancelled(true);
					return;
				}
			}
			user.setSpawnerLocation(block.getLocation());
			SpawnerUtil.openMenu(p);
		}
	}
	
}
