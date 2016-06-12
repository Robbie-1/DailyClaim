package dev.vrobbie.dailyclaim;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.sql.Timestamp;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class DailyClaimHandler {

	/**
	 * [*] VIP:
	 * 		- 10 melon
	 * 		- 10 torches
	 * 		- 10 bones
	 * 		- 2 armour pieces
	 * 		- 5 pump seeds/sugar canes
	 * 		- 6 red/white mushrooms each
	 * 		- 3 cactus
	 * 		- 5 bread
	 * 		- 6 wheat
	 * 		- give chain armour instead of leather
	 * 		- 2 of each, in terms of armour (instead of 1 of each)
	 */

	private Player player;
	private Date lastClaimTime = null;
	private Timestamp currentTime = null;
	private static final int MS_IN_24HOUR = 86400000;

	public DailyClaimHandler(CommandSender p, Timestamp currentTime) {
		this.player = (Player) p;
		this.currentTime = currentTime;
	}

	public void handleClaim(Player pl) {
		PermissionUser user = PermissionsEx.getUser(player.getName());
		List < String > groups = user.getParentIdentifiers("Spawn");
		
		if (groups.contains("Mod") || groups.contains("Admin") || groups.contains("Head-Builder") || groups.contains("Owner")) {
			player.sendMessage(ChatColor.GRAY+"Unable to claim daily rewards: you're a staff member.");
			return;
		}

		if (!user.has("dailyclaim.claim")) { //permission
			player.sendMessage(ChatColor.DARK_RED + "Error: You do not have permission to use this command.");
			return;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

		if (!canClaim(player)) {
			player.sendMessage(ChatColor.DARK_RED + "Sorry, but you are not yet able to claim your daily rewards.\n" + "You will be able to claim again at " + sdf.format(lastClaimTime));
			return;
		}

		if (lastClaimTime == null) {
			//TODO: check if player has inventory space before add.
			for (int i = 0; i < 4; i++) {
				player.getInventory().addItem(Rewards.dailyRewards[i]);
			}
			player.sendMessage(ChatColor.AQUA + "You also receive a set of bonus rewards!");
			Bukkit.broadcastMessage(ChatColor.GRAY+"[Server]: "+player.getName()+" has just claimed their set of daily rewards!");
		}

		/**
		 * TODO: Spawn saplings, enchanted weaponry, enchanted golden apples with "player.getInventory.addItem(itemId, amount)"
		 * 		-> as well as their other daily rewards
		 */

		if (groups.contains("Player")) {

			for (int i = 4; i < 8; i++) {
				player.getInventory().addItem(Rewards.dailyRewards[i]);
			}

			player.sendMessage(ChatColor.GREEN + "Daily rewards claimed successfully!");
			player.sendMessage(ChatColor.GOLD + "Upgrade today to claim even MORE daily rewards! [/buy]");

			//updates latest claim time
			lastClaimTime = new Date(System.currentTimeMillis());

			saveData(new File("plugins" + File.separator + "DailyClaim" + File.separator + "data" + File.separator + pl.getPlayer().getName() + ".yml"));

		} else if (groups.contains("VIP")) {
			for (int i = 8; i < 12; i++) {
				player.getInventory().addItem(Rewards.dailyRewards[i]);
			}

			player.sendMessage(ChatColor.GREEN + "Daily rewards claimed successfully!");
			player.sendMessage(ChatColor.GOLD + "Upgrade today to claim even MORE daily rewards! [/buy]");

			//updates latest claim time
			lastClaimTime = new Date(System.currentTimeMillis());

			saveData(new File("plugins" + File.separator + "DailyClaim" + File.separator + "data" + File.separator + pl.getPlayer().getName() + ".yml"));

		} else if (groups.contains("Noble")) {
			for (int i = 12; i < 19; i++) {
				player.getInventory().addItem(Rewards.dailyRewards[i]);
			}

			player.sendMessage(ChatColor.GREEN + "Daily rewards claimed successfully!");
			player.sendMessage(ChatColor.GOLD + "Upgrade today to claim even MORE daily rewards! [/buy]");

			//updates latest claim time
			lastClaimTime = new Date(System.currentTimeMillis());

			saveData(new File("plugins" + File.separator + "DailyClaim" + File.separator + "data" + File.separator + pl.getPlayer().getName() + ".yml"));

		} else if (groups.contains("Hero")) {
			for (int i = 19; i < 27; i++) {
				player.getInventory().addItem(Rewards.dailyRewards[i]);
			}

			player.sendMessage(ChatColor.GREEN + "Daily rewards claimed successfully!");
			player.sendMessage(ChatColor.GOLD + "Upgrade today to claim even MORE daily rewards! [/buy]");

			//updates latest claim time
			lastClaimTime = new Date(System.currentTimeMillis());

			saveData(new File("plugins" + File.separator + "DailyClaim" + File.separator + "data" + File.separator + pl.getPlayer().getName() + ".yml"));

		} else if (groups.contains("Elite")) {
			for (int i = 27; i < 40; i++) {
				player.getInventory().addItem(Rewards.dailyRewards[i]);
			}

			player.sendMessage(ChatColor.GREEN + "Daily rewards claimed successfully!");
			player.sendMessage(ChatColor.GOLD + "Upgrade today to claim even MORE daily rewards! [/buy]");

			//updates latest claim time
			lastClaimTime = new Date(System.currentTimeMillis());

			saveData(new File("plugins" + File.separator + "DailyClaim" + File.separator + "data" + File.separator + pl.getPlayer().getName() + ".yml"));

		} else if (groups.contains("Legend")) {
			for (int i = 40; i < 50; i++) {
				player.getInventory().addItem(Rewards.dailyRewards[i]);
			}
			
			ItemStack stoneAxe = new ItemStack(Material.STONE_AXE, 1);
			ItemStack stonePickaxe = new ItemStack(Material.STONE_PICKAXE, 1);
			ItemStack stoneSpade = new ItemStack(Material.STONE_SPADE, 1);
			ItemStack stoneSword = new ItemStack(Material.STONE_SWORD, 1);
			
			stoneAxe.addEnchantment(Enchantment.DIG_SPEED, 1);
			stonePickaxe.addEnchantment(Enchantment.DIG_SPEED, 1);
			stoneSpade.addEnchantment(Enchantment.DIG_SPEED, 1);
			stoneSword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
			
			player.getInventory().addItem(stoneAxe, stonePickaxe, stoneSpade, stoneSword);

			player.sendMessage(ChatColor.GREEN + "Daily rewards claimed successfully!");
			player.sendMessage(ChatColor.GOLD + "Upgrade today to claim even MORE daily rewards! [/buy]");

			//updates latest claim time
			lastClaimTime = new Date(System.currentTimeMillis());

			saveData(new File("plugins" + File.separator + "DailyClaim" + File.separator + "data" + File.separator + pl.getPlayer().getName() + ".yml"));

		} else if (groups.contains("Supreme")) {
			for (int i = 50; i < 61; i++) {
				player.getInventory().addItem(Rewards.dailyRewards[i]);
			}
			
			ItemStack ironAxe = new ItemStack(Material.IRON_AXE, 1);
			ItemStack ironPickaxe = new ItemStack(Material.IRON_PICKAXE, 1);
			ItemStack ironSpade = new ItemStack(Material.IRON_SPADE, 1);
			ItemStack ironSword = new ItemStack(Material.IRON_SWORD, 1);
			
			Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
			enchantments.put(Enchantment.DIG_SPEED, 2); //efficiency 2
			enchantments.put(Enchantment.DURABILITY, 2); //unbreaking 2
			
			ironAxe.addEnchantments(enchantments);
			ironPickaxe.addEnchantments(enchantments);
			ironSpade.addEnchantments(enchantments);
			ironSword.addEnchantment(Enchantment.DAMAGE_ALL, 2);
			
			player.getInventory().addItem(ironAxe, ironPickaxe, ironSpade, ironSword);

			player.sendMessage(ChatColor.GREEN + "Daily rewards claimed successfully!");
			player.sendMessage(ChatColor.GOLD + "Upgrade today to claim even MORE daily rewards! [/buy]");

			//updates latest claim time
			lastClaimTime = new Date(System.currentTimeMillis());

			saveData(new File("plugins" + File.separator + "DailyClaim" + File.separator + "data" + File.separator + pl.getPlayer().getName() + ".yml"));

		} else if (groups.contains("God")) {
			for (int i = 61; i < 74; i++) {
				player.getInventory().addItem(Rewards.dailyRewards[i]);
			}
			
			ItemStack goldAxe = new ItemStack(Material.GOLD_AXE, 1);
			ItemStack goldPickaxe = new ItemStack(Material.GOLD_PICKAXE, 1);
			ItemStack goldSpade = new ItemStack(Material.GOLD_SPADE, 1);
			ItemStack goldSword = new ItemStack(Material.GOLD_SWORD, 1);
			
			Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
			enchantments.put(Enchantment.DIG_SPEED, 3); //efficiency 3
			enchantments.put(Enchantment.DURABILITY, 3); //unbreaking 3
			
			goldAxe.addEnchantments(enchantments);
			goldPickaxe.addEnchantments(enchantments);
			goldSpade.addEnchantments(enchantments);
			goldSword.addEnchantment(Enchantment.DAMAGE_ALL, 3);
			
			player.getInventory().addItem(goldAxe, goldPickaxe, goldSpade, goldSword);

			player.sendMessage(ChatColor.GREEN + "Daily rewards claimed successfully!");
			player.sendMessage(ChatColor.GOLD + "Upgrade today to claim even MORE daily rewards! [/buy]");

			//updates latest claim time
			lastClaimTime = new Date(System.currentTimeMillis());

			saveData(new File("plugins" + File.separator + "DailyClaim" + File.separator + "data" + File.separator + pl.getPlayer().getName() + ".yml"));

		} else if (groups.contains("SkyGod")) {
			for (int i = 74; i < 87; i++) {
				player.getInventory().addItem(Rewards.dailyRewards[i]);
			}
			
			ItemStack diamondAxe = new ItemStack(Material.DIAMOND_AXE, 1);
			ItemStack diamondPickaxe = new ItemStack(Material.DIAMOND_PICKAXE, 1);
			ItemStack diamondSpade = new ItemStack(Material.DIAMOND_SPADE, 1);
			ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD, 1);
			
			Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
			enchantments.put(Enchantment.DIG_SPEED, 3); //efficiency 3
			enchantments.put(Enchantment.DURABILITY, 3); //unbreaking 3
			
			diamondAxe.addEnchantments(enchantments);
			diamondPickaxe.addEnchantments(enchantments);
			diamondSpade.addEnchantments(enchantments);
			diamondSword.addEnchantment(Enchantment.DAMAGE_ALL, 3);
			
			player.getInventory().addItem(diamondAxe, diamondPickaxe, diamondSpade, diamondSword);
			
			player.sendMessage(ChatColor.GREEN + "Daily rewards claimed successfully!");
			player.sendMessage(ChatColor.GOLD + "Upgrade today to claim even MORE daily rewards! [/buy]");

			//updates latest claim time
			lastClaimTime = new Date(System.currentTimeMillis());

			saveData(new File("plugins" + File.separator + "DailyClaim" + File.separator + "data" + File.separator + pl.getPlayer().getName() + ".yml"));

		} else if (groups.contains("Overlord")) {
			for (int i = 87; i < 100; i++) {
				player.getInventory().addItem(Rewards.dailyRewards[i]);
			}
			
			ItemStack diamondAxe = new ItemStack(Material.DIAMOND_AXE, 1);
			ItemStack diamondPickaxe = new ItemStack(Material.DIAMOND_PICKAXE, 1);
			ItemStack diamondSpade = new ItemStack(Material.DIAMOND_SPADE, 1);
			ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD, 1);
			
			Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();
			enchantments.put(Enchantment.DIG_SPEED, 3); //efficiency 3
			enchantments.put(Enchantment.DURABILITY, 3); //unbreaking 3
			
			diamondAxe.addEnchantments(enchantments);
			diamondPickaxe.addEnchantments(enchantments);
			diamondSpade.addEnchantments(enchantments);
			diamondSword.addEnchantment(Enchantment.DAMAGE_ALL, 3);
			
			player.getInventory().addItem(diamondAxe, diamondPickaxe, diamondSpade, diamondSword);

			player.sendMessage(ChatColor.GREEN + "Daily rewards claimed successfully!");
			player.sendMessage(ChatColor.GREEN + "Thankyou for supporting SkyBlock!! <3 <3");

			//updates latest claim time
			lastClaimTime = new Date(System.currentTimeMillis());

			saveData(new File("plugins" + File.separator + "DailyClaim" + File.separator + "data" + File.separator + pl.getPlayer().getName() + ".yml"));
			
		} else {
			player.sendMessage(ChatColor.RED+"Unable to claim daily rewards based on your rank, please, inform a staff member of this issue.");
			return;
		}
		lastClaimTime = new Date(System.currentTimeMillis());
		saveData(new File("plugins" + File.separator + "DailyClaim" + File.separator + "data" + File.separator + pl.getPlayer().getName() + ".yml"));
	}

	public boolean canClaim(Player pl) {

		//loads program data from player file.
		loadData(new File("plugins" + File.separator + "DailyClaim" + File.separator + "data" + File.separator + pl.getPlayer().getName() + ".yml"));

		if (lastClaimTime == null) {
			pl.sendMessage(ChatColor.YELLOW + "Congratulations on claiming your first set of daily rewards!");
			//player has not claimed before, so return true.
			//give additional/bonus rewards as it is player's first claim of daily rewards
			return true;
		}

		if (currentTime.getTime() > (lastClaimTime.getTime() + MS_IN_24HOUR)) {
			//can claim
			return true;
		} else {
			//cannot claim
			return false;
		}
	}

	public void loadData(File playerFile) {
		FileConfiguration config = YamlConfiguration.loadConfiguration(playerFile);
		if (config.get("Player.lastClaimTime").equals("null")) {
			//new player, no last claim timestamp, no need to load a last claim time timestamp value.
			lastClaimTime = null;
			return;
		} else {
			lastClaimTime = (Date) config.get("Player.lastClaimTime");
		}
	}

	public void saveData(File playerFile) {
		FileConfiguration config = YamlConfiguration.loadConfiguration(playerFile);
		config.set("Player.lastClaimTime", lastClaimTime); //Updates value in player file.
		try {
			config.save(playerFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}