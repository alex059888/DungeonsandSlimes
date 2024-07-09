package engine.entities.uIEntityes;

import engine.gfx.meshes.Mesh;
import engine.gfx.textures.Texture;
import engine.handler.Handler;
import engine.io.MouseListener;
import org.joml.Vector2f;

import static engine.gfx.textures.Texture.getTexCord;

public class Button extends UIEntity {
    private Mesh mesh2;
    protected float tx2, ty2;

    private boolean onPoint = false, meshA2 = false;
    protected float adjXL = 0, adjXR = 0, adjYU = 0, adjYD = 0;

    public Button(float x, float y, float z, float rX, float rY, float rZ, float tx, float ty, float tx2, float ty2, float sizeX, float sizeY, Handler handler, int texID) {
        super(x, y, z, rX, rY, rZ, tx, ty, sizeX, sizeY, handler, texID);
        this.tx2 = tx2;
        this.ty2 = ty2;
    }

    public Button(float x, float y, float z, float tx, float ty, float tx2, float ty2, float sizeX, float sizeY, Handler handler, int texID) {
        super(x, y, z, tx, ty, sizeX, sizeY, handler, texID);
        this.tx2 = tx2;
        this.ty2 = ty2;
    }

    @Override
    public void tick() {
        Vector2f v = new Vector2f(MouseListener.getX() + handler.getCamera().getEntity().transform.position.x - handler.getWidth() / 2,
                MouseListener.getY() + handler.getCamera().getEntity().transform.position.y - handler.getHeight() / 2);
        if (v.x > (transform.position.x - sizeX / 2 * transform.scale - adjXL) * ((float) handler.getWidth() / handler.getDefaultWidth()) &&
                v.x < (transform.position.x + sizeX / 2 * transform.scale - adjXR) * ((float) handler.getWidth() / handler.getDefaultWidth()) &&
                v.y > (transform.position.y - sizeY / 2 * transform.scale - adjYU) * ((float) handler.getHeight() / handler.getDefaultHeight()) &&
                v.y < (transform.position.y + sizeY / 2 * transform.scale - adjYD) * ((float) handler.getHeight() / handler.getDefaultHeight())) {
            if (MouseListener.mouseButtonDown(0))
                doAction();
            onPoint = true;
        } else
            onPoint = false;
        if (onPoint && !meshA2) {
            genMesh2();
            meshA2 = true;
        } else if (!onPoint && meshA2) {
            genMesh();
            meshA2 = false;
        }
    }

    @Override
    public void render() {
        super.render();
    }

    protected void doAction() {
    }

    protected void genMesh2() {
        vboS = new float[]{
                sizeX / 2.0f, -sizeY / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(tx2+1, Texture.getTexture(texID).getTexSize().x, sizeX),
                getTexCord(ty2+1, Texture.getTexture(texID).getTexSize().y, sizeY),
                -sizeX / 2.0f, -sizeY / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(tx2, Texture.getTexture(texID).getTexSize().x, sizeX),
                getTexCord(ty2+1, Texture.getTexture(texID).getTexSize().y, sizeY),
                -sizeX / 2.0f, sizeY / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(tx2, Texture.getTexture(texID).getTexSize().x, sizeX),
                getTexCord(ty2, Texture.getTexture(texID).getTexSize().y, sizeY),
                sizeX / 2.0f, sizeY / 2.0f, 0, 1, 1, 1, 1,
                getTexCord(tx2+1, Texture.getTexture(texID).getTexSize().x, sizeX),
                getTexCord(ty2, Texture.getTexture(texID).getTexSize().y, sizeY)
        };
        mesh = new Mesh(vboS, eboS);
    }

    protected void setAdjusters(float adjXL, float adjXR, float adjYU, float adjYD) {
        this.adjXL = adjXL;
        this.adjXR = adjXR;
        this.adjYU = adjYU;
        this.adjYD = adjYD;
    }
}
