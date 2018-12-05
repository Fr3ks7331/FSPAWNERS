package pl.fr3ks7331.fspawners.listeners.inventory;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import pl.fr3ks7331.fspawners.Main;
import pl.fr3ks7331.fspawners.objects.User;
import pl.fr3ks7331.fspawners.utils.ChatUtil;
import pl.fr3ks7331.fspawners.utils.ItemsUtil;

public class InventoryClickListener implements Listener {
	
	@EventHandler
	public void InventoryClick(InventoryClickEvent e) {
		if(e.isCancelled()) {
			return;
		}
		Player p = (Player)e.getWhoClicked();
		String title = e.getInventory().getName();
		ItemStack item = e.getCurrentItem();

		User user = Main.userManager.getUser(p);
		if ((title == null) || (item == null) || (item.getType() == Material.AIR) || (e.getSlotType().equals(InventoryType.SlotType.OUTSIDE))) {
			return;
		}
		if (title.equalsIgnoreCase(ChatUtil.fixColors("&a&lZmiana spawneru"))) {
			if (user.getSpawnerLocation() == null) {
				p.sendMessage(ChatUtil.fixColors("&cBlad, sprobuj ponownie!"));
				return;
			}
			e.setCancelled(true);
			p.updateInventory();
			Block spawner = user.getSpawnerLocation().getBlock();
			if ((spawner == null) || (spawner.getType() != Material.MOB_SPAWNER)) {
				p.sendMessage(ChatUtil.fixColors("&cBlad, sprobuj ponownie!"));
				return;
			}
			
			if(item.getType() == Material.IRON_INGOT){
				ItemsUtil.setSpawner(spawner, EntityType.IRON_GOLEM);
			} else if (item.getDurability() == 50) {
				ItemsUtil.setSpawner(spawner, EntityType.CREEPER);
		    } else if (item.getDurability() == 51) {
		        ItemsUtil.setSpawner(spawner, EntityType.SKELETON);
		    } else if (item.getDurability() == 52) {
		        ItemsUtil.setSpawner(spawner, EntityType.SPIDER);
		    } else if (item.getDurability() == 54) {
		        ItemsUtil.setSpawner(spawner, EntityType.ZOMBIE);
		    } else if (item.getDurability() == 57) {
				ItemsUtil.setSpawner(spawner, EntityType.SLIME);
			} else if (item.getDurability() == 55) {
		        ItemsUtil.setSpawner(spawner, EntityType.PIG_ZOMBIE);
		    } else if (item.getDurability() == 58) {
		        ItemsUtil.setSpawner(spawner, EntityType.ENDERMAN);
		    } else if (item.getDurability() == 59) {
		        ItemsUtil.setSpawner(spawner, EntityType.CAVE_SPIDER);
		    } else if (item.getDurability() == 91) {
		        ItemsUtil.setSpawner(spawner, EntityType.SHEEP);
		    } else if (item.getDurability() == 92) {
		        ItemsUtil.setSpawner(spawner, EntityType.COW);
		    } else if (item.getDurability() == 93) {
		        ItemsUtil.setSpawner(spawner, EntityType.CHICKEN);
		    }
		}
	}

}
