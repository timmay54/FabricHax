package io.github.pranavgade20.fabrichax;

import io.netty.channel.Channel;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class Settings {
    public static HashMap<Integer, Class> toggles;
    public static PlayerEntity player;
    public static ClientWorld world;
    public static Channel channel;
    public static MinecraftClient client;

    public Settings() {
    }

    public static void keyDown(int key) {
        if (toggles.containsKey(key)) {
            try {
                ((Class)toggles.get(key)).getMethod("toggle").invoke(null);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    static {
        toggles = new HashMap<>();
        // TODO: read a config file to load defaults
        toggles.put((int)'C', Criticals.class);
        toggles.put((int)'K', Fly.class);
        toggles.put((int)'I', Instamine.class);
        toggles.put((int)'H', ElytraFly.class);
        toggles.put((int)'U', FreeCam.class);
    }
}