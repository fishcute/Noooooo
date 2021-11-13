package me.fishcute.noooooo;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import java.util.logging.LogManager;
import java.util.logging.Logger;

/*
    Literally everything happens in this one class. Why? Because I can.
 */

@Mod(Noooooo.MODID)
public class Noooooo
{
    public static final String MODID = "noooooo";
    public static boolean shouldPlay = true;


    public Noooooo() {


        MinecraftForge.EVENT_BUS.register(Noooooo.class);

        SPEC = BUILDER.build();

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT,SPEC);

    }

    @SubscribeEvent
    public static void playNoooooo(TickEvent.ClientTickEvent event) {
        if (Minecraft.getInstance().player == null || soundEffect.get().equals("none")) return;
        if (shouldPlay && Minecraft.getInstance().player.isDeadOrDying()) {
            shouldPlay = false;
            Minecraft.getInstance().player.playSound(new SoundEvent(new ResourceLocation(soundEffect.get())),soundVolume.get().floatValue(),soundPitch.get().floatValue());
        }
        else if (!shouldPlay && !Minecraft.getInstance().player.isDeadOrDying()) {
            shouldPlay = true;
        }
    }

    public static ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static ForgeConfigSpec SPEC;

    public static ForgeConfigSpec.ConfigValue<String> soundEffect;
    public static ForgeConfigSpec.ConfigValue<Double> soundVolume;
    public static ForgeConfigSpec.ConfigValue<Double> soundPitch;

    static {
        BUILDER.comment("Allows you to change the sound effect played on death. Set to \"none\" to disable mod\n\n Example: If you set this to \"minecraft:entity.wither.death\", the wither death sound will be played upon your eventual demise");
        soundEffect = BUILDER.define("soundEffect", "noooooo:noooo");
        BUILDER.comment("Change the volume of the death sound");
        soundVolume = BUILDER.define("soundVolume", 1D);
        BUILDER.comment("Change the pitch of the death sound");
        soundPitch = BUILDER.define("soundPitch", 1D);
    }
}
