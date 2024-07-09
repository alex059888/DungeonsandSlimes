package engine.entities.creatures;

import engine.entities.Entity;
import engine.entities.tiles.TileType;
import engine.gfx.meshes.Mesh;
import engine.gfx.textures.Texture;
import engine.handler.Handler;
import engine.io.KeyListener;

import static engine.entities.tiles.Tile.TILESIZE;
import static engine.gfx.textures.Texture.getTexCord;
import static org.lwjgl.glfw.GLFW.*;

public class Player extends Creature {

    public Player(Creature player) {
        super(player);
        setDpt(5);
    }

    public Player(float x, float y, float z, float rX, float rY, float rZ, Handler handler, int id) {
        super(x, y, z, rX, rY, rZ, handler, 0, id);
        setDpt(5);
    }

    public Player(float x, float y, float z, Handler handler, int id) {
        super(x, y, z, handler, 0, id);
        setDpt(5);
    }

    protected void genMesh() {
        vboS = new float[]{
                -TILESIZE / 2.0f, -TILESIZE / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(16, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(16, Texture.getTexture(texID).getTexSize().y, TILESIZE),
                TILESIZE / 2.0f, -TILESIZE / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(15, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(16, Texture.getTexture(texID).getTexSize().y, TILESIZE),
                TILESIZE / 2.0f, TILESIZE / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(15, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(15, Texture.getTexture(texID).getTexSize().y, TILESIZE),
                -TILESIZE / 2.0f, TILESIZE / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(16, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(15, Texture.getTexture(texID).getTexSize().y, TILESIZE)
        };
        mesh = new Mesh(vboS, eboS);
    }

    @Override
    public void tick() {
        super.tick();
        controls();
        if (dpt > 0) {
            if (cDpt > 0) {
                cDpt--;
                return;
            }
        }
        movement();
    }

    @Override
    public void render() {
        super.render();
    }

    private void movement() {
        int xM = 0, yM = 0;

        if (KeyListener.isKeyPressed(GLFW_KEY_A)) {
            xM -= 1;
        }
        if (KeyListener.isKeyPressed(GLFW_KEY_D)) {
            xM += 1;
        }
        if (KeyListener.isKeyPressed(GLFW_KEY_S)) {
            yM -= 1;
        }
        if (KeyListener.isKeyPressed(GLFW_KEY_W)) {
            yM += 1;
        }
        if (handler.getWorld().getTile((int) (transform.position.x) + xM,
                (int) (transform.position.y) + yM).getTileType() == TileType.FLOR &&
                handler.getWorld().getTile((int) (transform.position.x) + xM,
                        (int) (transform.position.y)).getTileType() == TileType.FLOR &&
                handler.getWorld().getTile((int) (transform.position.x),
                        (int) (transform.position.y) + yM).getTileType() == TileType.FLOR) {
            move(xM, yM, 0);
            cDpt = dpt;
        } else if (handler.getWorld().getTile((int) (transform.position.x),
                (int) (transform.position.y) + yM).getTileType() == TileType.FLOR) {
            move(0, yM, 0);
            cDpt = dpt;
        } else if (handler.getWorld().getTile((int) (transform.position.x) + xM,
                (int) (transform.position.y)).getTileType() == TileType.FLOR) {
            move(xM, 0, 0);
            cDpt = dpt;
        }
    }

    private void controls() {
        for (Entity e:handler.getWorld().getEntityManager().getEntities()) {
            if (!e.equals(this))
                if ((int)e.transform.position.x == (int) transform.position.x && (int)e.transform.position.y == (int)transform.position.y)
                    e.onContact();
        }
    }

    @Override
    public void onContact() {
    }
}
