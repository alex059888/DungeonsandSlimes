package engine.scenes.worlds;

import engine.entities.EntityManager;
import engine.entities.tiles.Terain.usables.UsableTile;
import engine.entities.tiles.Tile;
import engine.handler.Handler;

import java.util.ArrayList;
import java.util.List;

public abstract class World {
    protected Handler handler;
    protected Tile[][] tiles;
    protected List<UsableTile> usableTiles;
    protected int mapWidth,mapHeight;

    protected EntityManager entityManager;

    public World(int mapWidth, int mapHeight, Handler handler) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.handler = handler;

        tiles = new Tile[mapWidth][mapHeight];
        usableTiles = new ArrayList<>();
        entityManager = new EntityManager(handler);

        handler.setWorld(this);

        initDefaultMap();
    }

    private void initDefaultMap() {
        for(int i = 0; i < mapWidth;i++) {
            for(int j = 0; j < mapHeight; j++) {
                tiles[i][j] = Tile.getTile(0).setParams(i, j, -1f, 0, handler);
            }
        }
    }

    public abstract void tick();

    public abstract void render();

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Tile getTile(int x, int y) {
        if(x<0 || y < 0 || x>= mapWidth || y >= mapHeight)
            return Tile.getTile(0);
        return tiles[x][y];
    }

    public void setTile(int x, int y, Tile t) {
        if(x >= 0 && y >= 0 && x < mapWidth && y < mapHeight && tiles != null) {
            tiles[x][y] = t;
        }
    }

    public UsableTile getUsableTile(int x, int y) {
        for (UsableTile t: usableTiles) {
            if (t.transform.position.x == x && t.transform.position.y == y)
                return t;
        }
        return null;
    }

    public void removeUsableTile(int x, int y) {
        for (UsableTile t: usableTiles) {
            if (t.transform.position.x == x && t.transform.position.y == y) {
                usableTiles.remove(t);
            }
        }
    }

    public void setUsableTile(int x, int y, UsableTile tile) {
        for (UsableTile t: usableTiles) {
            if (t.transform.position.x == x && t.transform.position.y == y)
                usableTiles.remove(t);
        }
        usableTiles.add(tile);
    }

    public List<UsableTile> getUsableTiles() {
        return usableTiles;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }

    public void setUsableTiles(List<UsableTile> usableTiles) {
        this.usableTiles = usableTiles;
    }

    public void setMapWidth(int mapWidth) {
        this.mapWidth = mapWidth;
    }

    public void setMapHeight(int mapHeight) {
        this.mapHeight = mapHeight;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addUsableTile(UsableTile tile) {
        usableTiles.add(tile);
    }
}
