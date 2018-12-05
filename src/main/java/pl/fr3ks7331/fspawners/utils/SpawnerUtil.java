package pl.fr3ks7331.fspawners.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpawnerUtil {
	
	public static void openMenu(Player p) {
		
		Inventory inv = Bukkit.createInventory(null, 27, ChatUtil.fixColors("&a&lZmiana spawneru"));
		inv.addItem(new ItemStack[] { ItemsUtil.getItemByID(383, 50, 1) });
		inv.addItem(new ItemStack[] { ItemsUtil.getItemByID(383, 51, 1) });
		inv.addItem(new ItemStack[] { ItemsUtil.getItemByID(383, 52, 1) });
		inv.addItem(new ItemStack[] { ItemsUtil.getItemByID(383, 54, 1) });
		inv.addItem(new ItemStack[] { ItemsUtil.getItemByID(383, 55, 1) });
		inv.addItem(new ItemStack[] { ItemsUtil.getItemByID(383, 57, 1) });
		inv.addItem(new ItemStack[] { ItemsUtil.getItemByID(383, 58, 1) });
		inv.addItem(new ItemStack[] { ItemsUtil.getItemByID(383, 59, 1) });
		inv.addItem(new ItemStack[] { ItemsUtil.getItemByID(383, 91, 1) });
		inv.addItem(new ItemStack[] { ItemsUtil.getItemByID(383, 92, 1) });
		inv.addItem(new ItemStack[] { ItemsUtil.getItemByID(383, 93, 1) });
		inv.addItem(new ItemStack[] { ItemsUtil.getItemByID(383, 96, 1) });
		ItemStack golem = new ItemStack(Material.IRON_CHESTPLATE, 1);
		ItemMeta golem_meta = golem.getItemMeta();
		golem_meta.setDisplayName(ChatUtil.fixColors("&f&lIRON GOLEM"));
		golem.setItemMeta(golem_meta);
		inv.addItem(new ItemStack[] { golem });
		p.openInventory(inv);
	}
}
