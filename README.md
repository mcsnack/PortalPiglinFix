# PortalPiglinFix

**Paper plugin for Minecraft Java 26.3** · **Release:** `v0.1`

PortalPiglinFix keeps portal-based gold farms working while rejecting zombified piglin portal-spawn attempts whose spawn position is outside a Nether portal block.

## English

### What it does

- Allows zombified piglins spawned with the `NETHER_PORTAL` reason when their feet are inside a `NETHER_PORTAL` block.
- Cancels those portal-spawn events when the spawn block is outside the portal.
- Leaves natural spawns, lightning conversions, piglin zombification, and unrelated entities alone.

The plugin checks the spawn reason and the block at the entity's spawn position. It does not remove piglins that already exist.

### Requirements

- Paper for Minecraft Java Edition 26.3 or newer
- Java 25 or newer

### Install

1. Download `PortalPiglinFix-0.1.0.jar` from the [v0.1 release](https://github.com/mcsnack/PortalPiglinFix/releases/tag/v0.1).
2. Stop the Paper server.
3. Put the JAR in the server's `plugins` folder.
4. Start the server.

Keep Paper's `enable-zombie-pigmen-portal-spawns` setting enabled. Turning it off disables portal spawns entirely and will break portal-based gold farms.

### Build from source

With Java 25+ and Gradle installed, run:

```sh
gradle build
```

The JAR is written to `build/libs/PortalPiglinFix-0.1.0.jar`.

### Limitations

This first release has no commands or configuration. It applies globally to portal-spawned zombified piglins.

## Deutsch

### Was das Plugin macht

- Zombifizierte Piglins, die mit dem Spawn-Grund `NETHER_PORTAL` entstehen, bleiben erlaubt, wenn ihre Füße in einem `NETHER_PORTAL`-Block stehen.
- Portal-Spawns außerhalb eines Netherportalblocks werden abgebrochen.
- Natürliche Spawns, Umwandlungen durch Blitze, die Zombifizierung von Piglins und andere Kreaturen bleiben unbeeinflusst.

Das Plugin prüft den Spawn-Grund und den Block an der Spawnposition. Bereits vorhandene Piglins werden nicht entfernt.

### Voraussetzungen

- Paper für Minecraft Java Edition 26.3 oder neuer
- Java 25 oder neuer

### Installation

1. `PortalPiglinFix-0.1.0.jar` aus dem [Release v0.1](https://github.com/mcsnack/PortalPiglinFix/releases/tag/v0.1) herunterladen.
2. Den Paper-Server stoppen.
3. Die JAR-Datei in den Serverordner `plugins` legen.
4. Den Server starten.

Die Paper-Einstellung `enable-zombie-pigmen-portal-spawns` muss aktiviert bleiben. Wird sie ausgeschaltet, werden Portal-Spawns vollständig deaktiviert und Portal-Goldfarmen funktionieren nicht mehr.

### Aus dem Quellcode bauen

Mit Java 25+ und installiertem Gradle diesen Befehl ausführen:

```sh
gradle build
```

Die JAR-Datei liegt danach unter `build/libs/PortalPiglinFix-0.1.0.jar`.

### Einschränkungen

Diese erste Version hat keine Befehle und keine Konfiguration. Sie wirkt global auf Zombifizierte Piglins, die durch Netherportale gespawnt werden.
