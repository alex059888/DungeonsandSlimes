package engine.entities;

import engine.entities.tiles.Tile;
import engine.gfx.Camera;
import engine.gfx.meshes.Mesh;
import engine.handler.Handler;
import engine.math.Transform;
import org.joml.Vector3f;

public abstract class Entity {
    protected Handler handler;
    protected Mesh mesh;

    protected int dpt = 0, cDpt = 0;

    protected int id;

    protected final int texID;
    public Transform transform;

    protected Camera camera;

    public Entity(float x, float y, float z, float rX, float rY, float rZ, Handler handler, int texID, int id) {
        transform = new Transform(new Vector3f(x,y,z), new Vector3f(rX, rY, rZ),1);
        this.handler = handler;
        this.texID = texID;
        camera = new Camera(this);
    }

    public Entity(float x, float y, float z, Handler handler, int texID, int id) {
        transform = new Transform(new Vector3f(x,y,z), new Vector3f(0,0,0),1);
        this.handler = handler;
        this.texID = texID;
        camera = new Camera(this);
    }

    public void setMesh(Mesh mesh) {
        this.mesh = mesh;
    }

    public void setScale(float scale) {
        transform.scale = scale;
    }

    public abstract void tick();

    public abstract void render();

    protected abstract void genMesh();

    public void setPosition(float x, float y, float z) {
        transform.position.x = x;
        transform.position.y = y;
        transform.position.z = z;
    }

    public void setRotation(float rX, float rY, float rZ) {
        transform.rotation.x = rX;
        transform.rotation.y = rY;
        transform.rotation.z = rZ;
    }

    public void move(int x, int y, int z) {
        transform.position.x += x;
        transform.position.y += y;
        transform.position.z += z;
    }

    public Mesh getMesh() {
        return mesh;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public int getTexID() {
        return texID;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public int getDpt() {
        return dpt;
    }

    public void setDpt(int dpt) {
        this.dpt = dpt;
    }

    public int getcDpt() {
        return cDpt;
    }

    public void setcDpt(int cDpt) {
        this.cDpt = cDpt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract void onContact();
}
