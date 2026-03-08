package derukaeru.dungeons_rework;

import derukaeru.dungeons_rework.items.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DungeonsRework implements ModInitializer {
	public static final String MOD_ID = "dungeons-rework";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.initialize_items();
		LOGGER.info("Hello Fabric world!");
	}
}