package pl.fr3ks7331.fspawners.objects.managers;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.entity.Player;

import pl.fr3ks7331.fspawners.objects.User;

public class UserManager
{
	private final Map<UUID, User> users = new ConcurrentHashMap();

	public void register(UUID uuid, String name)
	{
		User user = new User(uuid, name);
		this.users.put(uuid, user);
	}

	public User getUser(UUID uuid)
	{
		return (User)this.users.get(uuid);
	}

	public User getUser(Player player)
	{
		return (User)this.users.get(player.getUniqueId());
	}

	public boolean isUser(UUID uuid)
	{
		return this.users.containsKey(uuid);
	}

	public User getUser(String nick)
	{
		for (User user : this.users.values()) {
			if (user.getNick().equalsIgnoreCase(nick)) {
				return user;
			}
		}
		return null;
	}
}
