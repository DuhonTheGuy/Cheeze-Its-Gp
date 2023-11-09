package com.cheesegp;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("Cheese Coins Config")
public interface CheeseGpConfig extends Config
{
	@ConfigItem(
		keyName = "cheesegp",
		name = "Cheese Coins",
		description = "Names your coins after your favorite cheesy snack (or whatever your heart desires)."
	)
	default String snack()
	{
		return "Cheez-Its";
	}
}
