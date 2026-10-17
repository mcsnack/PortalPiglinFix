package de.chatti.portalpiglinfix;

import org.bukkit.Material;
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
        if (event.getEntityType() != org.bukkit.entity.EntityType.ZOMBIFIED_PIGLIN) {
            return;
        }

        if (event.getSpawnReason() != CreatureSpawnEvent.SpawnReason.NETHER_PORTAL) {
            return;
        }

        // The spawn location is the entity's feet position. Keep the gold-farm
        // mechanic only when those feet are actually inside a portal block.
        if (event.getLocation().getBlock().getType() == Material.NETHER_PORTAL) {
            return;
        }

        event.setCancelled(true);
    }
}
