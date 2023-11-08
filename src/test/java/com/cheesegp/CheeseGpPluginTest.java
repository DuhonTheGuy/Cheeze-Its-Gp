package com.cheesegp;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class CheeseGpPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(CheeseGpPlugin.class);
		RuneLite.main(args);
	}
}