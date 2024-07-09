package engine.math;

import engine.entities.tiles.Tile;
import org.joml.Matrix4f;
import org.joml.Vector3f;

public class Transform {

    public Vector3f position, rotation;
    public float scale;

    public Transform(Vector3f position, Vector3f rotation, float scale) {
        this.position = position;
        this.rotation = rotation;
        this.scale = scale;
    }

    public Transform() {
        position = new Vector3f(0,0,0);
        rotation = new Vector3f(0,0,0);
        scale = 1;
    }

    public Transform(Transform transform) {
        position = transform.position;
        rotation = transform.rotation;
        scale = transform.scale;
    }

    public Matrix4f getTransformation() {
        Matrix4f transform = new Matrix4f();
        transform.identity();

        Vector3f v = new Vector3f(position).mul(Tile.TILESIZE,Tile.TILESIZE,1);

        transform.rotationXYZ(rotation.x, rotation.y, rotation.z);
        transform.translate(v);
        transform.scale(scale);

        return transform;
    }
}
