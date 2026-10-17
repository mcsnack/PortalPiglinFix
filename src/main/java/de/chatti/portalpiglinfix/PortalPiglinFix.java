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
 * Keeps portal-based gold farms working while rejecting portal-spawned
 * zombified piglins whose spawn position is outside a Nether portal block.
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
        if (event.getSpawnReason() != CreatureSpawnEvent.SpawnReason.NETHER_PORTAL) {
            getLogger().info("Observed zombified piglin spawn with reason "
                    + event.getSpawnReason() + " at " + formatLocation(location)
                    + " (block: " + block + "); left unchanged.");
            return;
        }

        // Keep the gold-farm mechanic only when the spawn location is actually
        // inside a portal block.
        if (block == Material.NETHER_PORTAL) {
            getLogger().info("Allowed portal-spawned zombified piglin at "
                    + formatLocation(location) + " (block: " + block + ").");
            return;
        }

        event.setCancelled(true);
        getLogger().info("Blocked portal-spawned zombified piglin in fallback check at "
                + formatLocation(location) + " (block: " + block + ").");
    }

    private String formatLocation(Location location) {
        return location.getWorld().getName() + " "
                + location.getBlockX() + " "
                + location.getBlockY() + " "
                + location.getBlockZ();
    }
}
