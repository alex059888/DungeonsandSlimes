package engine.entities.uIEntityes;

import engine.entities.Entity;
import engine.gfx.meshes.Mesh;
import engine.gfx.textures.Texture;
import engine.handler.Handler;

import static engine.gfx.textures.Texture.getTexCord;

public class UIEntity extends Entity {
    protected float tx, ty, sizeX, sizeY;

    protected float[] vboS;

    protected final int[] eboS = {
            0, 1, 2, 2, 3, 0
    };

    public UIEntity(float x, float y, float z, float rX, float rY, float rZ, float tx, float ty, float sizeX, float sizeY, Handler handler, int texID) {
        super(x, y, z, rX, rY, rZ, handler, texID, 0);
        this.tx = tx;
        this.ty = ty;
        this.sizeY = sizeY;
        this.sizeX = sizeX;
        genMesh();
    }

    public UIEntity(float x, float y, float z, float tx, float ty, float sizeX, float sizeY, Handler handler, int texID) {
        super(x, y, z, handler, texID, 0);
        this.tx = tx;
        this.ty = ty;
        this.sizeY = sizeY;
        this.sizeX = sizeX;
        genMesh();
    }

    @Override
    public void tick() {
    }

    @Override
    public void render() {
        Texture.getTexture(texID).bind();
        handler.getDefaultShader().setTransform(transform.getTransformation());
        mesh.render();
    }

    @Override
    protected void genMesh() {
        vboS = new float[]{
                sizeX / 2.0f, -sizeY / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(tx+1, Texture.getTexture(texID).getTexSize().x, sizeX),
                getTexCord(ty+1, Texture.getTexture(texID).getTexSize().y, sizeY),
                -sizeX / 2.0f, -sizeY / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(tx, Texture.getTexture(texID).getTexSize().x, sizeX),
                getTexCord(ty+1, Texture.getTexture(texID).getTexSize().y, sizeY),
                -sizeX / 2.0f, sizeY / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(tx, Texture.getTexture(texID).getTexSize().x, sizeX),
                getTexCord(ty, Texture.getTexture(texID).getTexSize().y, sizeY),
                sizeX / 2.0f, sizeY / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(tx+1, Texture.getTexture(texID).getTexSize().x, sizeX),
                getTexCord(ty, Texture.getTexture(texID).getTexSize().y, sizeY)
        };
        mesh = new Mesh(vboS, eboS);
    }

    @Override
    public void onContact() {}
}
