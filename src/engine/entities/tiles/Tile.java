package engine.entities.tiles;

import engine.entities.Entity;
import engine.entities.tiles.Terain.flors.FlorTile;
import engine.entities.tiles.Terain.flors.OakPlanksFlor;
import engine.entities.tiles.Terain.flors.SandStoneTileFlor;
import engine.entities.tiles.Terain.flors.StoneTileFlor;
import engine.entities.tiles.Terain.walls.StoneBrickWall;
import engine.entities.tiles.Terain.walls.WallTile;
import engine.gfx.meshes.Mesh;
import engine.handler.Handler;
import org.joml.Vector3f;

import java.util.List;


public abstract class Tile extends Entity {
    public static float TILESIZE = 32f;
    private TileType tileType;

    protected int tx, ty;

    public Tile(float x, float y, float z, float rX, float rY, float rZ, Handler handler, int texID, int tx, int ty, TileType tileType, int id) {
        super(x, y, z, rX, rY, rZ, handler, texID, id);
        this.tileType = tileType;
        this.tx = tx;
        this.ty = ty;
    }

    public Tile(Tile tile) {
        super(tile.transform.position.x,tile.transform.position.y,tile.transform.position.z,
                tile.transform.position.x,tile.transform.position.y,tile.transform.position.z,
                tile.getHandler(), tile.getTexID(), tile.getId());
        this.tx = tile.getTx();
        this.ty = tile.getTy();
        this.tileType = tile.getTileType();
        mesh = tile.getMesh();
    }

    @Override
    public void render() {
        if (mesh == null)
            genMesh();
        handler.getDefaultShader().setTexture("tex",texID);
        handler.getDefaultShader().setTransform(transform.getTransformation());
        mesh.render();
    }

    @Override
    public void tick() {
    }

    public Tile getOrg() {
        return this;
    }

    protected abstract void genMesh();

    public static List<Tile> tiles = List.of(
            new StoneBrickWall(0),
            new StoneTileFlor(1),
            new SandStoneTileFlor(2),
            new OakPlanksFlor(3)
        );

    public static Tile getTile(int id) {
        if (tiles.get(id).getTileType() == TileType.WALL) {
            return new WallTile(tiles.get(id));
        } else {
            return new FlorTile(tiles.get(id));
        }
    }

    public Tile setParams(float x, float y, float z, float rz, Handler handler) {
        transform.position = new Vector3f(x,y,z);
        transform.rotation.z = rz;
        setHandler(handler);
        fullUpdate();
        return this;
    }

    public int getTx() {
        return tx;
    }

    public int getTy() {
        return ty;
    }

    public int getId() {
        return id;
    }

    public TileType getTileType() {
        return tileType;
    }

    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }

    public void update() {
        genMesh();
    }

    public void fullUpdate() {
        int x = (int) (transform.position.x), y = (int) (transform.position.y);
        for(int i = x-1; i <= x+1; i++) {
            for(int j = y-1; j <= y+1; j++) {
                if(i >= 0 && j >= 0 && j < handler.getWorld().getMapHeight() && i < handler.getWorld().getMapWidth() && handler.getWorld().getTile(i,j) != null)
                    handler.getScene().getEventManager().addToUpdList(handler.getWorld().getTile(i,j));
            }
        }
    }

    @Override
    public Mesh getMesh() {
        return super.getMesh();
    }
}
