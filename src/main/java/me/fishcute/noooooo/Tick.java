package me.fishcute.noooooo;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class Tick {
    static boolean ran = false;
    public static void tick() {
        if (client().player.isDead()) {
            if (ran!=true&&!NooooooMod.CONFIG.getSoundEffect().equals("none"))
                no();
            ran = true;
        }
        else ran = false;
    }
    public static void no() {
        ClientPlayerEntity p = client().player;
        client().player.clientWorld.playSound(p, new BlockPos((int) p.getX(), (int) p.getY(), (int) p.getZ()), new SoundEvent(new Identifier(NooooooMod.CONFIG.getSoundEffect())),
                SoundCategory.MASTER, NooooooMod.CONFIG.getSoundVolume(), NooooooMod.CONFIG.getSoundPitch());

    }
    public static MinecraftClient client() {
        return MinecraftClient.getInstance();
    }
}
