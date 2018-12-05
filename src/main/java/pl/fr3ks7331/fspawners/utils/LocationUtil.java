package pl.fr3ks7331.fspawners.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;



public class LocationUtil
{

 
  public static ArrayList<Block> getBlocks(Block start, int radius)
  {
    ArrayList<Block> blocks = new ArrayList();
    for (double x = start.getLocation().getX() - radius; x <= start.getLocation().getX() + radius; x += 1.0D) {
      for (double y = start.getLocation().getY() - radius; y <= start.getLocation().getY() + radius; y += 1.0D) {
        for (double z = start.getLocation().getZ() - radius; z <= start.getLocation().getZ() + radius; z += 1.0D)
        {
          Location loc = new Location(start.getWorld(), x, y, z);
          blocks.add(loc.getBlock());
        }
      }
    }
    return blocks;
  }
}
