package engine.entities.creatures;

import engine.gfx.meshes.Mesh;
import engine.gfx.textures.Texture;
import engine.handler.Handler;
import engine.scenes.MenuScene;

import static engine.entities.tiles.Tile.TILESIZE;
import static engine.gfx.textures.Texture.getTexCord;

public class Goal extends Creature{
    public Goal(Creature creature) {
        super(creature);
    }

    public Goal(float x, float y, float z, float rX, float rY, float rZ, Handler handler, int id) {
        super(x, y, z, rX, rY, rZ, handler, 0, id);
    }

    public Goal(float x, float y, float z, Handler handler, int id) {
        super(x, y, z, handler, 0, id);
    }

    @Override
    protected void genMesh() {
        vboS = new float[]{
                -TILESIZE / 2.0f, -TILESIZE / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(8, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(8, Texture.getTexture(texID).getTexSize().y, TILESIZE),
                TILESIZE / 2.0f, -TILESIZE / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(7, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(8, Texture.getTexture(texID).getTexSize().y, TILESIZE),
                TILESIZE / 2.0f, TILESIZE / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(7, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(7, Texture.getTexture(texID).getTexSize().y, TILESIZE),
                -TILESIZE / 2.0f, TILESIZE / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(8, Texture.getTexture(texID).getTexSize().x, TILESIZE),
                getTexCord(7, Texture.getTexture(texID).getTexSize().y, TILESIZE)
        };
        mesh = new Mesh(vboS, eboS);
    }

    @Override
    public void onContact() {
        handler.getGame().levelsUnlocked++;
        handler.getGame().changeScene(new MenuScene(handler));
    }
}
