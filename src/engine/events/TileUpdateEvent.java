package engine.events;

import engine.entities.tiles.Tile;
import engine.entities.tiles.TileType;

import java.util.ArrayList;
import java.util.List;

public class TileUpdateEvent implements Event{
    private List<Tile> tiles;

    public TileUpdateEvent() {
        this.tiles = new ArrayList<>();
    }

    @Override
    public void tick() {
        for (Tile t : tiles) {
            t.update();
        }
        for (int i = tiles.size()-1; i >=0;i--) {
            if (tiles.get(i).getTileType() != TileType.USABLE)
                tiles.remove(i);
        }
    }

    public void addToUpdList(Tile tile) {
        if (tile != null)
            tiles.add(tile);
    }

    public void removeTileFromUpdList(Tile tile) {
        if(tile != null)
            tiles.remove(tile);
    }
}
