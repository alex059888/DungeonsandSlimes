package engine.entities.tiles.Terain.usables;

import engine.entities.Entity;
import engine.entities.tiles.Tile;
import engine.entities.tiles.TileType;
import engine.gfx.meshes.Mesh;
import engine.gfx.textures.Texture;
import engine.handler.Handler;

import java.util.List;

import static engine.gfx.textures.Texture.getTexCord;

public class UsableTile extends Tile {
    protected int state = 0, maxState = 1;
    protected int tx1, ty1;
    public static List<UsableTile> usableTiles = List.of(
            new Spikes(0)
    );

    public UsableTile(float x, float y, float z, float rX, float rY, float rZ, Handler handler, int texID, int tx, int ty,int tx1,int ty1, int id) {
        super(x, y, z, rX, rY, rZ, handler, texID, tx, ty, TileType.USABLE, id);
        this.tx1 = tx1;
        this.ty1 = ty1;
        dpt = 120;
        genMesh();
    }

    public UsableTile(UsableTile tile) {
        super(tile);
        tx1 = tile.tx1;
        ty1 = tile.ty1;
        dpt = tile.dpt;
        genMesh();
    }

    protected void genMesh() {
        float[] v = new float[]{
                -TILESIZE / 2.0f, -TILESIZE / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(tx + 1, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(ty + 1, Texture.getTexture(texID).getTexSize().y, TILESIZE),
                TILESIZE / 2.0f, -TILESIZE / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(tx, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(ty + 1, Texture.getTexture(texID).getTexSize().y, TILESIZE),
                TILESIZE / 2.0f, TILESIZE / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(tx, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(ty, Texture.getTexture(texID).getTexSize().y, TILESIZE),
                -TILESIZE / 2.0f, TILESIZE / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(tx + 1, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(ty, Texture.getTexture(texID).getTexSize().y, TILESIZE)
        };
        int[] e = new int[]{
                0, 1, 2, 2, 3, 0
        };
        mesh = new Mesh(v, e);
    }

    protected void genMesh1() {
        float[] v = new float[]{
                -TILESIZE / 2.0f, -TILESIZE / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(tx1 + 1, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(ty1 + 1, Texture.getTexture(texID).getTexSize().y, TILESIZE),
                TILESIZE / 2.0f, -TILESIZE / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(tx, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(ty1 + 1, Texture.getTexture(texID).getTexSize().y, TILESIZE),
                TILESIZE / 2.0f, TILESIZE / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(tx1, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(ty1, Texture.getTexture(texID).getTexSize().y, TILESIZE),
                -TILESIZE / 2.0f, TILESIZE / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(tx1 + 1, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(ty1, Texture.getTexture(texID).getTexSize().y, TILESIZE)
        };
        int[] e = new int[]{
                0, 1, 2, 2, 3, 0
        };
        mesh = new Mesh(v, e);
    }

    @Override
    public void tick() {
        super.tick();
    }

    public UsableTile setParams(int x, int y, float z, Handler handler) {
        transform.position.x = x;
        transform.position.y = y;
        transform.position.z = z;
        this.handler = handler;
        return this;
    }

    public void use(Entity e) {}

    public static UsableTile getUsableTile(int id) {
        return new UsableTile(usableTiles.get(id));
    }

    @Override
    public void onContact() {}
}
