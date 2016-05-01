package nl.LumiaAntiInvis;


import nl.LumiaAntiInvis.Potion1_9.PotionType;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

public class PotionListener implements Listener
{

	Main plugin = Main.get();

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onDrink(PlayerInteractEvent e)
	{
		Action a = e.getAction();
		Player p = e.getPlayer();
		if ((a != Action.RIGHT_CLICK_AIR) && (a != Action.RIGHT_CLICK_BLOCK))
		{
			return;
		}

		ItemStack itemInHand = p.getInventory().getItemInMainHand();
		if (itemInHand.getType() != Material.POTION)
		{
			return;
		}

		Potion1_9 potion = Potion1_9.fromItemStack(itemInHand);

		if (potion.getType() != PotionType.INVISIBILITY)
		{
			return;
		}

		e.setCancelled(true);
		ItemStack setAir = new ItemStack(Material.AIR);

		p.getInventory().setItemInMainHand(setAir);
		p.updateInventory();

		p.sendMessage(ChatColor.YELLOW + "Invisibility Potions have been disabled on the server!");

	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onLingering(PlayerInteractEvent e)
	{
		Action a = e.getAction();
		Player p = e.getPlayer();
		if ((a != Action.RIGHT_CLICK_AIR) && (a != Action.RIGHT_CLICK_BLOCK))
		{
			return;
		}
		ItemStack itemInHand = p.getInventory().getItemInMainHand();
		if (itemInHand.getType() != Material.LINGERING_POTION)
		{
			return;
		}
		Potion1_9 potion = Potion1_9.fromItemStack(itemInHand);
		if(potion.getType() != PotionType.INVISIBILITY){
			return;
		}
		e.setCancelled(true);
		ItemStack setAir = new ItemStack(Material.AIR);
		
		p.getInventory().setItemInMainHand(setAir);
		p.updateInventory();
		
		p.sendMessage(ChatColor.YELLOW + "Invisibility Potions have been disabled on the server!");
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onDrinkPotion(PlayerItemConsumeEvent e)
	{

		Player p = e.getPlayer();
		ItemStack i = e.getItem();

		if (i.getType() != Material.POTION)
		{
			return;
		}
		Potion1_9 pot = Potion1_9.fromItemStack(i);
		if (pot.getType() != PotionType.INVISIBILITY)
		{
			return;
		}

		e.setCancelled(true);
		ItemStack setAir = new ItemStack(Material.AIR);

		p.getInventory().setItemInMainHand(setAir);
		p.updateInventory();

		p.sendMessage(ChatColor.YELLOW + "Invisibility Potions have been disabled on the server!");

	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void hitSplashPotion(PotionSplashEvent e)
	{
		if (Potion1_9.fromItemStack(e.getEntity().getItem()) == null)
		{
			return;
		}

		if (Potion1_9.fromItemStack(e.getEntity().getItem()).getType() == PotionType.INVISIBILITY)
		{
			if (e.getEntity().getShooter() instanceof Player)
			{
				Player p = (Player) e.getEntity().getShooter();

				p.sendMessage(ChatColor.YELLOW + "Invisibility Potions have been disabled on the server!");
				e.setCancelled(true);
				e.getEntity().getLocation().getWorld().dropItem(e.getEntity().getLocation(), e.getPotion().getItem());

			}
		}
	}

	@EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	public void onDispense(BlockDispenseEvent e)
	{
		ItemStack i = e.getItem();
		Material t = i.getType();
		if (t != Material.POTION)
		{
			return;
		}
		Potion1_9 p = Potion1_9.fromItemStack(i);

		if (p.getType() != PotionType.INVISIBILITY)
		{
			return;
		}

		e.setCancelled(true);
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onLingerUse(PlayerInteractEvent e)
	{

		Action a = e.getAction();
		Player p = e.getPlayer();
		if ((a != Action.RIGHT_CLICK_AIR) && (a != Action.RIGHT_CLICK_BLOCK))
		{
			return;
		}

		ItemStack itemInHand = p.getInventory().getItemInMainHand();
		if (itemInHand.getType() != Material.LINGERING_POTION)
		{
			return;
		}

		Potion1_9 potion = Potion1_9.fromItemStack(itemInHand);

		if (potion.getType() != PotionType.INVISIBILITY)
		{
			return;
		}

		e.setCancelled(true);
		ItemStack setAir = new ItemStack(Material.AIR);

		p.getInventory().setItemInMainHand(setAir);
		p.updateInventory();

		p.sendMessage(ChatColor.YELLOW + "Invisibility Potions have been disabled on the server!");

	}

}
