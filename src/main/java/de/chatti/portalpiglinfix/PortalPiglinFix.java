package de.chatti.portalpiglinfix;

import org.bukkit.Material;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Keeps portal-based gold farms working while rejecting portal and
 * reinforcement-spawned zombified piglins outside Nether portal blocks.
 */
public final class PortalPiglinFix extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("Portal spawns inside Nether portal blocks are allowed; outside spawns are blocked.");
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (event.getEntityType() != EntityType.ZOMBIFIED_PIGLIN) {
            return;
        }

        Location location = event.getLocation();
        Material block = location.getBlock().getType();
        CreatureSpawnEvent.SpawnReason reason = event.getSpawnReason();
        if (reason != CreatureSpawnEvent.SpawnReason.NETHER_PORTAL
                && reason != CreatureSpawnEvent.SpawnReason.REINFORCEMENTS) {
            return;
        }

        if (block == Material.NETHER_PORTAL) {
            return;
        }

        event.setCancelled(true);
        getLogger().info("Blocked zombified piglin spawn with reason " + reason
                + " outside a Nether portal at " + formatLocation(location)
                + " (block: " + block + ").");
    }

    private String formatLocation(Location location) {
        return location.getWorld().getName() + " "
                + location.getBlockX() + " "
                + location.getBlockY() + " "
                + location.getBlockZ();
    }
}
