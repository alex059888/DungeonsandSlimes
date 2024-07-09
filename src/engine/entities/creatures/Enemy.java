package engine.entities.creatures;

import engine.entities.Entity;
import engine.entities.tiles.TileType;
import engine.gfx.meshes.Mesh;
import engine.gfx.textures.Texture;
import engine.handler.Handler;
import engine.scenes.MenuScene;
import org.joml.Random;
import org.joml.Vector2i;

import static engine.entities.tiles.Tile.TILESIZE;
import static engine.gfx.textures.Texture.getTexCord;

public class Enemy extends Creature {
    protected boolean up = false, right = false;

    private Entity enemy;

    public Enemy(Creature creature) {
        super(creature);
    }

    public Enemy(float x, float y, float z, float rX, float rY, float rZ, Handler handler, int texID, int tx, int ty, int id) {
        super(x, y, z, rX, rY, rZ, handler, texID, id);
        this.tx = tx;
        this.ty = ty;
    }

    public Enemy(float x, float y, float z, Handler handler, int texID, int tx, int ty, int id) {
        super(x, y, z, handler, texID, id);
        this.tx = tx;
        this.ty = ty;
    }

    @Override
    protected void genMesh() {
        vboS = new float[]{
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
        mesh = new Mesh(vboS, eboS);
    }

    @Override
    public void tick() {
        super.tick();
        if (cDpt > 0) {
            cDpt--;
        } else {
            cDpt = dpt;
            for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
                if (e.getId() == 0)
                    enemy = e;
            }
            if (enemy != null) {
                Vector2i v = getNextMoveToPos();
                move(v.x, v.y, 0);
            }
        }
    }

    protected Vector2i getNextMoveToPos() {
        int y = 0, x = 0;
        if (up) {
            if (handler.getWorld().getTile((int)transform.position.x, (int)transform.position.y+1).getTileType() == TileType.FLOR) {
                y+=yVal;
            } else {
                up = !up;
            }
        } else {
            if (handler.getWorld().getTile((int)transform.position.x, (int)transform.position.y-1).getTileType() == TileType.FLOR) {
                y-=yVal;
            } else {
                up = !up;
            }
        }
        if (right) {
            if (handler.getWorld().getTile((int)transform.position.x+1, (int)transform.position.y).getTileType() == TileType.FLOR) {
                x+=xVal;
            } else {
                right = !right;
            }
        } else {
            if (handler.getWorld().getTile((int)transform.position.x-1, (int)transform.position.y).getTileType() == TileType.FLOR) {
                x-=xVal;
            } else {
                right = !right;
            }
        }
        if (handler.getWorld().getTile((int)transform.position.x + x, (int)transform.position.y + y).getTileType() == TileType.FLOR)
            return new Vector2i(x,y);
        else {
            Random random = new Random();
            int c = random.nextInt(2);
            if (c == 1)
                return new Vector2i(0, y);
            else
                return new Vector2i(x,0);
        }
    }

    @Override
    public void onContact() {
        if (handler.getGame().levelsUnlocked > 1) handler.getGame().levelsUnlocked--;
        handler.getGame().changeScene(new MenuScene(handler));
    }
}
