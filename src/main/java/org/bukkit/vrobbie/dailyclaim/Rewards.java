package org.bukkit.vrobbie.dailyclaim;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Rewards {
	
	/**
	 * 	0); //normal
		1); //birch
		2); //spurce
		3); //jungle
		4 = acacia
		5 = dark oak
		
		1 = enchanted golden apple
	 */
	
	public static ItemStack[] dailyRewards = {
			/* Bonus stacks */
			new ItemStack(Material.DIRT, 5, (short) 0), 		//[0]
			new ItemStack(Material.COBBLESTONE, 5, (short) 0), 
			new ItemStack(Material.APPLE, 2, (short) 0),		
			new ItemStack(Material.BREAD, 2, (short) 0),		//[3]
			
			/* Player stacks */
			new ItemStack(Material.BREAD, 1, (short) 0),		//[4]
			new ItemStack(Material.APPLE, 2, (short) 0),
			new ItemStack(Material.SAPLING, 1, (short) 0),
			new ItemStack(Material.DIRT, 5, (short) 0),			//[7]
			
			/* VIP stacks */
			new ItemStack(Material.BREAD, 3, (short) 0),		//[8]
			new ItemStack(Material.APPLE, 3, (short) 0),
			new ItemStack(Material.SAPLING, 2, (short) 0),
			new ItemStack(Material.DIRT, 10, (short) 0),		//[11]
			
			/* Noble stacks */
			new ItemStack(Material.BREAD, 5, (short) 0),		//[12]
			new ItemStack(Material.APPLE, 5, (short) 0),
			new ItemStack(Material.SAPLING, 3, (short) 0), //oak sapling
			new ItemStack(Material.SAPLING, 1, (short) 2), //spruce sapling
			new ItemStack(Material.DIRT, 15, (short) 0),
			new ItemStack(Material.COBBLESTONE, 5, (short) 0),
			new ItemStack(Material.IRON_INGOT, 1, (short) 0),	//[18]
			
			/* Hero stacks */
			new ItemStack(Material.BREAD, 7, (short) 0),		//[19]
			new ItemStack(Material.APPLE, 7, (short) 0),
			new ItemStack(Material.SAPLING, 3, (short) 0), //oak sapling
			new ItemStack(Material.SAPLING, 2, (short) 2), //spruce sapling
			new ItemStack(Material.SAPLING, 1, (short) 1), //birch sapling
			new ItemStack(Material.DIRT, 20, (short) 0),
			new ItemStack(Material.COBBLESTONE, 10, (short) 0),
			new ItemStack(Material.IRON_INGOT, 2, (short) 0),	//[26]
			
			/* Elite stacks */
			new ItemStack(Material.BREAD, 10, (short) 0),		//[27]
			new ItemStack(Material.APPLE, 10, (short) 0),
			new ItemStack(Material.SAPLING, 5, (short) 0), //oak sapling
			new ItemStack(Material.SAPLING, 3, (short) 2), //spruce sapling
			new ItemStack(Material.SAPLING, 3, (short) 1), //birch sapling
			new ItemStack(Material.SAPLING, 3, (short) 3), //jungle sapling
			new ItemStack(Material.DIRT, 25, (short) 0),
			new ItemStack(Material.COBBLESTONE, 15, (short) 0),
			new ItemStack(Material.IRON_INGOT, 3, (short) 0),
			new ItemStack(Material.IRON_AXE, 1, (short) 0),
			new ItemStack(Material.IRON_PICKAXE, 1, (short) 0),
			new ItemStack(Material.IRON_SPADE, 1, (short) 0),
			new ItemStack(Material.IRON_SWORD, 1, (short) 0),	//[39]
			
			/* Legend stacks */
			new ItemStack(Material.BREAD, 15, (short) 0),		//[40]
			new ItemStack(Material.APPLE, 15, (short) 0),
			new ItemStack(Material.SAPLING, 7, (short) 0), //oak sapling
			new ItemStack(Material.SAPLING, 4, (short) 2), //spruce sapling
			new ItemStack(Material.SAPLING, 4, (short) 1), //birch sapling
			new ItemStack(Material.SAPLING, 3, (short) 3), //jungle sapling
			new ItemStack(Material.SAPLING, 1, (short) 4), //acacia sapling
			new ItemStack(Material.DIRT, 30, (short) 0),
			new ItemStack(Material.COBBLESTONE, 20, (short) 0),
			new ItemStack(Material.IRON_INGOT, 4, (short) 0),	//[49]
			
			/* Supreme stacks */
			new ItemStack(Material.BREAD, 20, (short) 0),		//[50]
			new ItemStack(Material.APPLE, 5, (short) 1),	//(enchanted) golden apple
			new ItemStack(Material.SAPLING, 10, (short) 0), //oak sapling
			new ItemStack(Material.SAPLING, 5, (short) 2), //spruce sapling
			new ItemStack(Material.SAPLING, 5, (short) 1), //birch sapling
			new ItemStack(Material.SAPLING, 5, (short) 3), //jungle sapling
			new ItemStack(Material.SAPLING, 5, (short) 4), //acacia sapling
			new ItemStack(Material.SAPLING, 5, (short) 5), //dark oak sapling
			new ItemStack(Material.DIRT, 35, (short) 0),
			new ItemStack(Material.COBBLESTONE, 25, (short) 0),
			new ItemStack(Material.IRON_INGOT, 7, (short) 0),	//[60]
			
			/* God stacks */
			new ItemStack(Material.BREAD, 25, (short) 0),		//[61]
			new ItemStack(Material.APPLE, 7, (short) 1),	//(enchanted) golden apple
			new ItemStack(Material.SAPLING, 12, (short) 0), //oak sapling
			new ItemStack(Material.SAPLING, 7, (short) 2), //spruce sapling
			new ItemStack(Material.SAPLING, 7, (short) 1), //birch sapling
			new ItemStack(Material.SAPLING, 7, (short) 3), //jungle sapling
			new ItemStack(Material.SAPLING, 7, (short) 4), //acacia sapling
			new ItemStack(Material.SAPLING, 7, (short) 5), //dark oak sapling
			new ItemStack(Material.DIRT, 50, (short) 0),
			new ItemStack(Material.COBBLESTONE, 35, (short) 0),
			new ItemStack(Material.IRON_INGOT, 12, (short) 0),
			new ItemStack(Material.GOLD_INGOT, 3, (short) 0),
			new ItemStack(Material.DIAMOND, 1, (short) 0),		//[73]
			
			/* SkyGod stacks */
			new ItemStack(Material.BREAD, 40, (short) 0),		//[74]
			new ItemStack(Material.APPLE, 10, (short) 1),	//(enchanted) golden apple
			new ItemStack(Material.SAPLING, 15, (short) 0), //oak sapling
			new ItemStack(Material.SAPLING, 10, (short) 2), //spruce sapling
			new ItemStack(Material.SAPLING, 10, (short) 1), //birch sapling
			new ItemStack(Material.SAPLING, 10, (short) 3), //jungle sapling
			new ItemStack(Material.SAPLING, 10, (short) 4), //acacia sapling
			new ItemStack(Material.SAPLING, 10, (short) 5), //dark oak sapling
			new ItemStack(Material.DIRT, 64, (short) 0),
			new ItemStack(Material.COBBLESTONE, 50, (short) 0),
			new ItemStack(Material.IRON_INGOT, 20, (short) 0),
			new ItemStack(Material.GOLD_INGOT, 10, (short) 0),
			new ItemStack(Material.DIAMOND, 2, (short) 0),		//[86]
			
			/* Overlord stacks */
			new ItemStack(Material.BREAD, 50, (short) 0),		//[87]
			new ItemStack(Material.APPLE, 12, (short) 1),	//(enchanted) golden apple
			new ItemStack(Material.SAPLING, 20, (short) 0), //oak sapling
			new ItemStack(Material.SAPLING, 13, (short) 2), //spruce sapling
			new ItemStack(Material.SAPLING, 13, (short) 1), //birch sapling
			new ItemStack(Material.SAPLING, 13, (short) 3), //jungle sapling
			new ItemStack(Material.SAPLING, 13, (short) 4), //acacia sapling
			new ItemStack(Material.SAPLING, 13, (short) 5), //dark oak sapling
			new ItemStack(Material.DIRT, 64, (short) 0),
			new ItemStack(Material.COBBLESTONE, 64, (short) 0),
			new ItemStack(Material.IRON_INGOT, 35, (short) 0),
			new ItemStack(Material.GOLD_INGOT, 25, (short) 0),
			new ItemStack(Material.DIAMOND, 5, (short) 0),		//[99]
		};

}
