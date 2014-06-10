package net.creeperhost.chtweaks;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import net.creeperhost.chtweaks.reference.ModInfo;
import net.minecraft.init.Blocks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
public class CHTweaks {
	public static final Logger logger = LogManager.getLogger(ModInfo.NAME);

	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		logger.info(ModInfo.NAME + " loaded!");
	}
}
