package me.fishcute.noooooo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import net.fabricmc.loader.api.FabricLoader;

import java.io.*;
import java.nio.file.Path;

public class Config {
    public static void attemptLoadConfig() {
        Path configFilePath = FabricLoader.getInstance().getConfigDir().resolve("noooooo_config.json");
        File configFile = configFilePath.toFile();
        if (configFile.exists()) {
            try {
                ConfigData data = Config.loadConfigFile(configFile);
                NooooooMod.CONFIG = new Config(data);
                Config.writeConfigFile(configFile, data);
            } catch (Exception ex) {
                NooooooMod.LOGGER.error("Something went wrong while loading the config file, using default config file");
            }
        } else {
            try {
                Config.writeConfigFile(configFile, new ConfigData());
            } catch (Exception ex) {
                NooooooMod.LOGGER.error("Something went wrong while creating a default config. Please report this to the mod author");
            }
        }

    }
    private String soundEffect = "noooooo:noooo";
    private float soundVolume = 500;
    private float soundPitch = 1;
    public Config(ConfigData confileFileFormat) {
        soundEffect = confileFileFormat.soundEffect;
        soundVolume = confileFileFormat.soundVolume;
        soundPitch = confileFileFormat.soundPitch;
}

    public Config() {
        this(new ConfigData());
    }

    public String getSoundEffect() {
        return this.soundEffect;
    }
    public float getSoundPitch() {
        return this.soundPitch;
    }
    public float getSoundVolume() {
        return this.soundVolume;
    }

    public static ConfigData loadConfigFile(File configFile) throws IOException {
        FileReader reader = null;
        try {
            Gson gson = new Gson();
            reader = new FileReader(configFile);
            return gson.fromJson(reader, ConfigData.class);
        }
        finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public static void writeConfigFile(File configFile, ConfigData data) throws IOException {
        FileWriter writer = null;
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            writer = new FileWriter(configFile);
            writer.write(gson.toJson(data));
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

public static class ConfigData implements Serializable {
    @Expose
    private String soundEffect = "noooooo:noooo";
    @Expose
    private float soundVolume = 500;
    @Expose
    private float soundPitch = 1;
}

}
