package com.cheesegp;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.ClientTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.api.MenuAction;

import java.util.Objects;

import static net.runelite.api.MenuAction.GROUND_ITEM_FIRST_OPTION;
import static net.runelite.api.MenuAction.GROUND_ITEM_SECOND_OPTION;
import static net.runelite.api.MenuAction.GROUND_ITEM_THIRD_OPTION;
import static net.runelite.api.MenuAction.GROUND_ITEM_FOURTH_OPTION;
import static net.runelite.api.MenuAction.GROUND_ITEM_FIFTH_OPTION;
import static net.runelite.api.MenuAction.EXAMINE_ITEM_GROUND;

@Slf4j
@PluginDescriptor(
	name = "Cheese Coins",
	description = "Names your coins after your favorite cheesy snack",
	tags = {"joke", "menu entry", "meme", "cheese", "coins"}
)
public class CheeseGpPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private CheeseGpConfig config;

	@Subscribe
	public void onClientTick(ClientTick clientTick) {
		if (client.isMenuOpen()) {
			return;
		}

		MenuEntry[] menuEntries = client.getMenuEntries();
		for (MenuEntry entry : menuEntries) {
			int ID = entry.getItemId();
			MenuAction type = entry.getType();
			int Identifier = entry.getIdentifier();


			if (ID == 995){
				entry.setTarget("<col=ffe608>" + config.snack() + "</col>");
			}
			if ((type == GROUND_ITEM_THIRD_OPTION || type == GROUND_ITEM_SECOND_OPTION || type == GROUND_ITEM_FIRST_OPTION || type == GROUND_ITEM_FOURTH_OPTION || type == GROUND_ITEM_FIFTH_OPTION || type == EXAMINE_ITEM_GROUND) && Identifier == 995){
				entry.setTarget("<col=ffe608>" + config.snack());

			}
		}

	}

	@Provides
	CheeseGpConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CheeseGpConfig.class);
	}
}
