package pl.fr3ks7331.fspawners.objects;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;


public class User {

	private UUID uuid;
	private String name;
	private Location spawner;
	private long lastSpawnerChange;

	public User(UUID uuid, String name){
		this.uuid = uuid;
		this.name = name;
		this.spawner = spawner;
		this.lastSpawnerChange = 3000L;

	}

	public String getNick() { return this.name; }


	public Location getSpawnerLocation() { return this.spawner; }

	public void setSpawnerLocation(Location spawner) { this.spawner = spawner; }

	public UUID getUUID(){ return this.uuid; }

	public Player getPlayer(){ return Bukkit.getPlayer(this.uuid); }

	public String getName() { return this.name; }

	public boolean canChangeSpawner() { return System.currentTimeMillis() > this.lastSpawnerChange + TimeUnit.SECONDS.toMillis(30L); }

	public long getLastSpawnerChange() { return this.lastSpawnerChange; }

	public long getTimeLeft() { return this.lastSpawnerChange + TimeUnit.SECONDS.toMillis(30L) - System.currentTimeMillis(); }



}
