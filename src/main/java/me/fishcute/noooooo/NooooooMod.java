/*
 *    MCreator note:
 *
 *    If you lock base mod element files, you can edit this file and the proxy files
 *    and they won't get overwritten. If you change your mod package or modid, you
 *    need to apply these changes to this file MANUALLY.
 *
 *
 *    If you do not lock base mod element files in Workspace settings, this file
 *    will be REGENERATED on each build.
 *
 */
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
