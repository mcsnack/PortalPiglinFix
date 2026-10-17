# Changelog

## v0.1.2

- Cancel Zombified Piglin reinforcement spawns outside Nether portal blocks, in addition to portal spawns.
- Keep natural spawns and other spawn reasons unchanged.
- Log only blocked spawns to avoid flooding the server log.

## v0.1.1

- Log every zombified piglin's spawn reason, exact coordinates, and block type to diagnose behavior on a live server.
- Log whether portal-spawned zombified piglins are allowed or blocked.

## v0.1

- Allow portal-spawned zombified piglins only when the spawn position is inside a Nether portal block.
- Preserve portal-based gold farm spawns.
- Do not affect natural spawns, lightning conversions, or other entities.
