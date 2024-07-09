package engine.entities.tiles.Terain.flors;

import engine.entities.tiles.Tile;
import engine.entities.tiles.TileType;
import engine.gfx.meshes.Mesh;
import engine.gfx.textures.Texture;
import engine.handler.Handler;

import static engine.gfx.textures.Texture.getTexCord;

public class FlorTile extends Tile {

    public FlorTile(Tile tile) {
        super(tile);
    }

    public FlorTile(float x, float y, float z, float rX, float rY, float rZ, Handler handler, int texID, int tx, int ty, int id) {
        super(x, y, z, rX, rY, rZ, handler, texID, tx, ty, TileType.FLOR, id);
    }

    protected void genMesh() {
        int x = (int) (transform.position.x), y = (int) (transform.position.y);
        boolean u = false, r = false, d = false, l = false;
        boolean ul = false, ur = false, dl = false, dr = false;

        if (handler.getWorld().getTile(x - 1, y).getTileType() == TileType.WALL) {
            l = true;
        }
        if (handler.getWorld().getTile(x + 1, y).getTileType() == TileType.WALL) {
            r = true;
        }
        if (handler.getWorld().getTile(x, y + 1).getTileType() == TileType.WALL) {
            u = true;
        }
        if (handler.getWorld().getTile(x, y - 1).getTileType() == TileType.WALL) {
            d = true;
        }

        if (!u && !r) {
            if (handler.getWorld().getTile(x + 1, y + 1).getTileType() == TileType.WALL) {
                ur = true;
            }
        }
        if (!u && !l) {
            if (handler.getWorld().getTile(x - 1, y + 1).getTileType() == TileType.WALL) {
                ul = true;
            }
        }
        if (!d && !r) {
            if (handler.getWorld().getTile(x + 1, y - 1).getTileType() == TileType.WALL) {
                dr = true;
            }
        }
        if (!d && !l) {
            if (handler.getWorld().getTile(x - 1, y - 1).getTileType() == TileType.WALL) {
                dl = true;
            }
        }

        float urf = 0, ulf = 0, drf = 0, dlf = 0;

        if (u) {
            urf += 0.2f;
            ulf += 0.2f;
        }

        if (d) {
            drf += 0.2f;
            dlf += 0.2f;
        }

        if (l) {
            ulf += 0.2f;
            dlf += 0.2f;
        }

        if (r) {
            urf += 0.2f;
            drf += 0.2f;
        }

        if (ur)
            urf += 0.2f;
        if (dr)
            drf += 0.2f;
        if (ul)
            ulf += 0.2f;
        if (dl)
            dlf += 0.2f;

        float[] v = new float[]{
                -TILESIZE/2.0f, -TILESIZE/2.0f, 0, 1 - dlf, 1 - dlf, 1 - dlf, 1,
                getTexCord(tx + 1, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(ty + 1, Texture.getTexture(texID).getTexSize().y, TILESIZE),
                TILESIZE/2.0f, -TILESIZE/2.0f, 0, 1 - drf, 1 - drf, 1 - drf, 1,
                getTexCord(tx, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(ty + 1, Texture.getTexture(texID).getTexSize().y, TILESIZE),
                TILESIZE/2.0f, TILESIZE/2.0f, 0, 1 - urf, 1 - urf, 1 - urf, 1,
                getTexCord(tx, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(ty, Texture.getTexture(texID).getTexSize().y, TILESIZE),
                -TILESIZE/2.0f, TILESIZE/2.0f, 0, 1 - ulf, 1 - ulf, 1 - ulf, 1,
                getTexCord(tx + 1, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(ty, Texture.getTexture(texID).getTexSize().y, TILESIZE)
        };
        int[] e = new int[]{
                0, 1, 2, 2, 3, 0
        };
        mesh = new Mesh(v, e);
    }

    public Tile getOrg() {
        float[] v = new float[]{
                -TILESIZE/2.0f, -TILESIZE/2.0f, 0, 1, 1, 1, 1,
                getTexCord(tx + 1, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(ty + 1, Texture.getTexture(texID).getTexSize().y, TILESIZE),
                TILESIZE/2.0f, -TILESIZE/2.0f, 0, 1, 1, 1, 1,
                getTexCord(tx, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(ty + 1, Texture.getTexture(texID).getTexSize().y, TILESIZE),
                TILESIZE/2.0f, TILESIZE/2.0f, 0, 1, 1, 1, 1,
                getTexCord(tx, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(ty, Texture.getTexture(texID).getTexSize().y, TILESIZE),
                -TILESIZE/2.0f, TILESIZE/2.0f, 0, 1, 1, 1, 1,
                getTexCord(tx + 1, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(ty, Texture.getTexture(texID).getTexSize().y, TILESIZE)
        };
        int[] e = new int[]{
                0, 1, 2, 2, 3, 0
        };
        mesh = new Mesh(v, e);
        return this;
    }

    @Override
    public void onContact() {}
}
