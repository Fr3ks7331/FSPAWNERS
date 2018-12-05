package pl.fr3ks7331.fspawners.utils;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

public class ItemsUtil
{
  public static ItemStack getItemByID(int id, int data, int ilosc)
  {
    return new ItemStack(Material.getMaterial(id), ilosc, (byte)data);
  }
  
  public static void setSpawner(Block block, EntityType ent)
  {
    BlockState blockState = block.getState();
    CreatureSpawner spawner = (CreatureSpawner)blockState;
    spawner.setSpawnedType(ent);
    blockState.update();
  }
}
