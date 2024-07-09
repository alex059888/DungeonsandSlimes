package engine.gfx;

import engine.entities.BlancEntity;
import engine.entities.Entity;
import engine.entities.tiles.Tile;
import org.joml.Matrix4f;
import org.joml.Vector3f;

public class Camera {
    public static float camWidth = 768, camHeight = 512;
    private static Matrix4f ortho = new Matrix4f().ortho(0,camWidth,0,camHeight,0f,100f);

    private Entity entity;
    private Vector3f lastPos;

    public Camera(Entity entity) {
        this.entity = entity;
    }

    public static Matrix4f getOrthographicMatrix() {
        return ortho;
    }

    public static void setOrtho(Matrix4f m) {
        ortho = m;
    }

    public Matrix4f getView() {
        if (entity == null)
            entity = new BlancEntity(lastPos.x,lastPos.y, lastPos.z, null);
        lastPos = new Vector3f(entity.transform.position);
        Vector3f cp = new Vector3f(entity.transform.position).mul(Tile.TILESIZE, Tile.TILESIZE, 1).add(-camWidth/2,
                -camHeight/2,0);
        Vector3f up = new Vector3f(0,1f,0);
        Vector3f front = new Vector3f(0,0,-1);
        return new Matrix4f().lookAt(cp,
                front.add(cp.x, cp.y,0),
                up);
    }

    public Vector3f getPos() {
        return entity.transform.position;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
}
