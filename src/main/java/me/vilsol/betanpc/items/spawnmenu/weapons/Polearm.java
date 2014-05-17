package me.vilsol.betanpc.items.spawnmenu.weapons;

import java.util.Arrays;

import me.vilsol.betanpc.enums.ItemTier;
import me.vilsol.betanpc.enums.ItemType;
import me.vilsol.betanpc.enums.SpawnStage;
import me.vilsol.betanpc.workers.ItemSpawnWorker;
import me.vilsol.menuengine.engine.BonusItem;
import me.vilsol.menuengine.engine.DynamicMenuModel;
import me.vilsol.menuengine.engine.MenuItem;
import me.vilsol.menuengine.enums.ClickType;
import me.vilsol.menuengine.utils.Builder;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Polearm implements MenuItem, BonusItem {

	private ItemTier tier;
	
	@Override
	public void setBonusData(Object o) {
		tier = (ItemTier) o;
	}

	@Override
	public void registerItem() {
		MenuItem.items.put(this.getClass(), this);
	}

	@Override
	public void execute(Player plr, ClickType click) {
		((ItemSpawnWorker) DynamicMenuModel.getMenu(plr)).type = ItemType.POLEARM;
		((ItemSpawnWorker) DynamicMenuModel.getMenu(plr)).stage = SpawnStage.RARITY_CHOICE;
		DynamicMenuModel.getMenu(plr).showToPlayer(plr);
	}

	@Override
	public ItemStack getItem() {
		return new Builder(tier.getMaterialFromType(ItemType.POLEARM)).setName(tier.getTierColor() + "Get Random " + tier.name() + " Polearm").setLore(Arrays.asList(ChatColor.GRAY + "Spawn Random " + tier.name() + " Polearm")).getItem();
	}
	
}