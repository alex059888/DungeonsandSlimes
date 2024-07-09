package engine.events;

import engine.entities.tiles.Tile;

public class EventManager {
    private TileUpdateEvent tileUpdateEvent;

    public EventManager() {
        tileUpdateEvent = new TileUpdateEvent();
    }

    public void tick() {
        tileUpdateEvent.tick();
    }

    public void addToUpdList(Tile tile) {
        tileUpdateEvent.addToUpdList(tile);
    }

    public void removeFromUpdList(Tile tile) {
        tileUpdateEvent.removeTileFromUpdList(tile);
    }
}
