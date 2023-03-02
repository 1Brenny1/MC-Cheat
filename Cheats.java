// Minecraft Hacked Client Code

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

public class Cheats {
    
    // Flight
    
    public static void enableFlight() {
        MinecraftClient.getInstance().player.abilities.allowFlying = true;
        MinecraftClient.getInstance().player.abilities.flying = true;
    }
    
    public static void disableFlight() {
        MinecraftClient.getInstance().player.abilities.allowFlying = false;
        MinecraftClient.getInstance().player.abilities.flying = false;
    }
    
    // Boat Flight
    
    public static void enableBoatFlight() {
        MinecraftClient.getInstance().player.getVehicle().getEntity().abilities.allowFlying = true;
        MinecraftClient.getInstance().player.getVehicle().getEntity().abilities.flying = true;
    }
    
    public static void disableBoatFlight() {
        MinecraftClient.getInstance().player.getVehicle().getEntity().abilities.allowFlying = false;
        MinecraftClient.getInstance().player.getVehicle().getEntity().abilities.flying = false;
    }
    
    // Reach
    
    public static void setReach(float value) {
        MinecraftClient.getInstance().options.reachDistance = value;
    }
    
    // Speed
    
    public static void setSpeed(float value) {
        MinecraftClient.getInstance().player.abilities.setWalkSpeed(value);
    }
    
    // Killaura
    
    public static void enableKillaura() {
        PlayerEntity target = MinecraftClient.getInstance().world.getClosestPlayer(MinecraftClient.getInstance().player, 5.0);
        MinecraftClient.getInstance().interactionManager.attackEntity(MinecraftClient.getInstance().player, target);
    }
    
    public static void disableKillaura() {
        // Killaura automatically disables after each attack
    }
    
    // Player Move
    
    public static void movePlayer(double x, double y, double z) {
        MinecraftClient.getInstance().getNetworkHandler().sendPacket(new PlayerMoveC2SPacket.PositionAndOnGround(x, y, z, true));
    }
}
