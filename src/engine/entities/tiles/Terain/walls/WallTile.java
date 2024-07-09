package engine.entities.tiles.Terain.walls;

import engine.entities.tiles.Tile;
import engine.entities.tiles.TileType;
import engine.gfx.meshes.Mesh;
import engine.gfx.textures.Texture;
import engine.handler.Handler;
import org.joml.Vector2i;

import static engine.gfx.textures.Texture.getTexCord;

public class WallTile extends Tile {

    private int wallTexId;

    public WallTile(Tile tile) {
        super(tile);
    }

    public WallTile(float x, float y, float z, float rX, float rY, float rZ, Handler handler, int texID, int wallTexId, int id) {
        super(x, y, z, rX, rY, rZ, handler, texID, 0, 0, TileType.WALL, id);
        this.wallTexId = wallTexId;
    }

    protected void genMesh() {
        int x = (int) (transform.position.x), y = (int) (transform.position.y);
        boolean u = false, r = false, d = false, l = false;
        boolean ul = false, ur = false, dl = false, dr = false;

        if (handler.getWorld().getTile(x + 1, y).getTileType() != TileType.WALL) {
            l = true;
        }
        if (handler.getWorld().getTile(x - 1, y).getTileType() != TileType.WALL) {
            r = true;
        }
        if (handler.getWorld().getTile(x, y + 1).getTileType() != TileType.WALL) {
            u = true;
        }
        if (handler.getWorld().getTile(x, y - 1).getTileType() != TileType.WALL) {
            d = true;
        }
        if (handler.getWorld().getTile(x + 1, y + 1).getTileType() != TileType.WALL) {
            ul = true;
        }
        if (handler.getWorld().getTile(x - 1, y + 1).getTileType() != TileType.WALL) {
            ur = true;
        }
        if (handler.getWorld().getTile(x + 1, y - 1).getTileType() != TileType.WALL) {
            dl = true;
        }
        if (handler.getWorld().getTile(x - 1, y - 1).getTileType() != TileType.WALL) {
            dr = true;
        }

        Vector2i vi = WallTexSettings.getWallSetting(wallTexId).getFullWall();

        float a = 1.0f;

        if (!u && !d && !l && !r && !ul && !dl && !ur && !dr)
            a = 0;

        //Wall left
        if (!u && !d && l && !r && !ur && !dr) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallLeft();
        }
        //Wall right
        if (!u && !d && !l && r && !ul && !dl) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallRight();
        }
        //Wall up
        if (u && !d && !l && !r && !dr && !dl) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallUp();
        }
        //Wall down
        if (!u && d && !l && !r && !ul && !ur) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallDown();
        }

        //------------2 side walls
        //Wall left up
        if (u && !d && l && !r && !dr) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallUL();
        }
        //Wall right up
        if (u && !d && !l && r && !dl) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallUR();
        }
        //Wall left down
        if (!u && d && l && !r && !ur) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallDL();
        }
        //Wall right down
        if (!u && d && !l && r && !ul) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallDR();
        }
        //Wall up down
        if (u && d && !l && !r) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallUD();
        }
        //Wall left right
        if (!u && !d && l && r) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallLR();
        }

        //------------2 side walls
        //Wall left up right
        if (u && !d && l && r) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallRUL();
        }
        //Wall down right up
        if (u && d && !l && r) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallURD();
        }
        //Wall left down right
        if (!u && d && l && r) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallRDL();
        }
        //Wall up left down
        if (u && d && l && !r) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallDLU();
        }

        //Corner all
        if (!u && !d && !l && !r && ul && dl && ur && dr) {
            vi = WallTexSettings.getWallSetting(wallTexId).getCornerAll();
        }

        //Corner up left
        if (!u && !d && !l && !r && ul && !dl && !ur && !dr) {
            vi = WallTexSettings.getWallSetting(wallTexId).getCornerUL();
        }
        //Corner up right
        if (!u && !d && !l && !r && !ul && !dl && ur && !dr) {
            vi = WallTexSettings.getWallSetting(wallTexId).getCornerUR();
        }
        //Corner down left
        if (!u && !d && !l && !r && !ul && dl && !ur && !dr) {
            vi = WallTexSettings.getWallSetting(wallTexId).getCornerDL();
        }
        //Corner down right
        if (!u && !d && !l && !r && !ul && !dl && !ur && dr) {
            vi = WallTexSettings.getWallSetting(wallTexId).getCornerDR();
        }

        //Corner up
        if (!u && !d && !l && !r && ul && !dl && ur && !dr) {
            vi = WallTexSettings.getWallSetting(wallTexId).getCornerU();
        }
        //Corner down
        if (!u && !d && !l && !r && !ul && dl && !ur && dr) {
            vi = WallTexSettings.getWallSetting(wallTexId).getCornerD();
        }
        //Corner left
        if (!u && !d && !l && !r && ul && dl && !ur && !dr) {
            vi = WallTexSettings.getWallSetting(wallTexId).getCornerL();
        }
        //Corner right
        if (!u && !d && !l && !r && !ul && !dl && ur && dr) {
            vi = WallTexSettings.getWallSetting(wallTexId).getCornerR();
        }
        //Corner up left right down
        if (!u && !d && !l && !r && ul && !dl && !ur && dr) {
            vi = WallTexSettings.getWallSetting(wallTexId).getCornerULDR();
        }
        //Corner up right down left
        if (!u && !d && !l && !r && !ul && dl && ur && !dr) {
            vi = WallTexSettings.getWallSetting(wallTexId).getCornerURDL();
        }

        //Corner up left down
        if (!u && !d && !l && !r && ul && dl && !ur && dr) {
            vi = WallTexSettings.getWallSetting(wallTexId).getCornerULD();
        }
        //Corner up right down
        if (!u && !d && !l && !r && !ul && dl && ur && dr) {
            vi = WallTexSettings.getWallSetting(wallTexId).getCornerURD();
        }
        //Corner right up left
        if (!u && !d && !l && !r && ul && dl && ur && !dr) {
            vi = WallTexSettings.getWallSetting(wallTexId).getCornerLUR();
        }
        //Corner right down left
        if (!u && !d && !l && !r && ul && !dl && ur && dr) {
            vi = WallTexSettings.getWallSetting(wallTexId).getCornerLDR();
        }

        //Wall Corner
        //Down left
        if (!u && d && !l && !r && ul && !ur) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallDcornerL();
        }
        //Down right
        if (!u && d && !l && !r && !ul && ur) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallDcornerR();
        }
        //Down both
        if (!u && d && !l && !r && ul && ur) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallDcornerLR();
        }

        //Up left
        if (u && !d && !l && !r && dl && !dr) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallUcornerL();
        }
        //Up right
        if (u && !d && !l && !r && !dl && dr) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallUcornerR();
        }
        //Up both
        if (u && !d && !l && !r && dl && dr) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallUcornerLR();
        }

        //Left up
        if (!u && !d && l && !r && ur && !dr) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallLcornerU();
        }
        //Left down
        if (!u && !d && l && !r && !ur && dr) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallLcornerD();
        }
        //Left both
        if (!u && !d && l && !r && ur && dr) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallLcornerUD();
        }

        //Right up
        if (!u && !d && !l && r && ul && !dl) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallRcornerU();
        }
        //Right down
        if (!u && !d && !l && r && !ul && dl) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallRcornerD();
        }
        //Right both
        if (!u && !d && !l && r && ul && dl) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallRcornerUD();
        }

        //Right Up
        if (u && !d && !l && r && dl) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallURcorner();
        }
        //Left Up
        if (u && !d && l && !r && dr) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallULcorner();
        }
        //Left Down
        if (!u && d && l && !r && ur) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallDLcorner();
        }
        //Right Down
        if (!u && d && !l && r && ul) {
            vi = WallTexSettings.getWallSetting(wallTexId).getWallDRcorner();
        }

        tx = vi.x;
        ty = vi.y;

        float[] v = new float[]{-TILESIZE / 2.0f, -TILESIZE / 2.0f, 0, 1, 1, 1, a,
                getTexCord(tx + 1, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(ty + 1, Texture.getTexture(texID).getTexSize().y, TILESIZE),
                TILESIZE / 2.0f, -TILESIZE / 2.0f, 0, 1, 1, 1, a,
                getTexCord(tx, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(ty + 1, Texture.getTexture(texID).getTexSize().y, TILESIZE),
                TILESIZE / 2.0f, TILESIZE / 2.0f, 0, 1, 1, 1, a,
                getTexCord(tx, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(ty, Texture.getTexture(texID).getTexSize().y, TILESIZE),
                -TILESIZE / 2.0f, TILESIZE / 2.0f, 0, 1, 1, 1, a,
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
                -TILESIZE / 2.0f, -TILESIZE / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(WallTexSettings.getWallSetting(wallTexId).getFullWall().x + 1, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(WallTexSettings.getWallSetting(wallTexId).getFullWall().y + 1, Texture.getTexture(texID).getTexSize().y, TILESIZE),
                TILESIZE / 2.0f, -TILESIZE / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(WallTexSettings.getWallSetting(wallTexId).getFullWall().x, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(WallTexSettings.getWallSetting(wallTexId).getFullWall().y + 1, Texture.getTexture(texID).getTexSize().y, TILESIZE),
                TILESIZE / 2.0f, TILESIZE / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(WallTexSettings.getWallSetting(wallTexId).getFullWall().x, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(WallTexSettings.getWallSetting(wallTexId).getFullWall().y, Texture.getTexture(texID).getTexSize().y, TILESIZE),
                -TILESIZE / 2.0f, TILESIZE / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(WallTexSettings.getWallSetting(wallTexId).getFullWall().x + 1, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(WallTexSettings.getWallSetting(wallTexId).getFullWall().y, Texture.getTexture(texID).getTexSize().y, TILESIZE)
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
