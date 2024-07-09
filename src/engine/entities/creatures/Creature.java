package engine.entities.creatures;

import engine.entities.Entity;
import engine.gfx.textures.Texture;
import engine.handler.Handler;
import org.joml.Vector3f;

import java.util.List;

public abstract class Creature extends Entity {
    protected int tx, ty;

    protected float height = 0, camHeight = 0;

    protected int xVal = 0, yVal = 0;

    protected float[] vboS;

    protected final int[] eboS = {
            0, 1, 2, 2, 3, 0
    };

    public static List<Creature> creatures = List.of(
            new Player(0,0,0,null,0),
            new BlueSlime(0,0,0,null,1),
            new GreenSlime(0,0,0,null,2),
            new RedSlime(0,0,0,null,3),
            new Goal(0,0,0,null,4)
    );

    public static Creature getCreature(int id) {
        if (id == 0) {
            return new Player(creatures.get(0));
        } else if (id == 4) {
            return new Goal(creatures.get(4));
        } else {
            return new Enemy(creatures.get(id));
        }
    }

    public Creature setParams(int x, int y, Handler handler) {
        transform.position.x = x;
        transform.position.y = y;
        this.handler = handler;
        return this;
    }

    public Creature setParams(int x, int y, float z, Handler handler) {
        transform.position.x = x;
        transform.position.y = y;
        transform.position.z = z;
        this.handler = handler;
        return this;
    }

    public Vector3f cameraRotation;

    public  Creature(Creature creature) {
        super(creature.transform.position.x,creature.transform.position.y,creature.transform.position.z,
                creature.transform.rotation.x,creature.transform.rotation.y,creature.transform.rotation.z,
                creature.getHandler(),creature.getTexID(), creature.getId());
        dpt = creature.getDpt();
        xVal = creature.xVal;
        yVal = creature.yVal;
        tx = creature.tx;
        ty = creature.ty;
        genMesh();
    }

    public Creature(float x, float y, float z, float rX, float rY, float rZ, Handler handler, int texID, int id) {
        super(x, y, z, rX, rY, rZ, handler, texID, id);
        cameraRotation = new Vector3f(0, 0, 0);
        genMesh();
    }

    public Creature(float x, float y, float z, Handler handler, int texID, int id) {
        super(x, y, z, handler, texID, id);
        cameraRotation = new Vector3f(0, 0, 0);
        genMesh();
    }

    @Override
    public void tick() {
        mesh.tick();
    }

    @Override
    public void render() {
        Texture.getTexture(texID).bind();
        handler.getDefaultShader().setTransform(transform.getTransformation());
        mesh.render();
    }

    protected abstract void genMesh();

    public abstract void onContact();

    public void rotateCamera(float x, float y, float z) {
        cameraRotation.x -= x * handler.getTimeSinceLastTickPerFps();
        cameraRotation.y -= y * handler.getTimeSinceLastTickPerFps();
        cameraRotation.z -= z * handler.getTimeSinceLastTickPerFps();
    }

    public Vector3f getCameraRotation() {
        return cameraRotation;
    }

    public void setCameraRotation(Vector3f cameraRotation) {
        this.cameraRotation = cameraRotation;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getCamHeight() {
        return camHeight;
    }

    public void setCamHeight(float camHeight) {
        this.camHeight = camHeight;
    }
}
