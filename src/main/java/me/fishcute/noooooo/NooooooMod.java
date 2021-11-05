package me.fishcute.noooooo;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.sound.SoundEvent;

import net.fabricmc.api.ModInitializer;

public class NooooooMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();
	public static Config CONFIG = new Config();
	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Noooooo. Deaths are now more dramatic");
		Config.attemptLoadConfig();
	}
}
