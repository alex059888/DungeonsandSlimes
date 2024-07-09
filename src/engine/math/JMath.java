package engine.math;

import org.joml.Math;
import org.joml.Vector2f;
import org.joml.Vector3f;

public class JMath {

    public static Vector3f blockCords(Vector3f position) {
        Vector3f v = new Vector3f(position);
        if (position.x % 1 >= 0.5f) {
            v.x += 1;
        }
        if (position.y % 1 >= 0.5f) {
            v.y += 1;
        }
        if (position.z % 1 >= 0.5f) {
            v.z += 1;
        }
        v.x = (float) Math.floor(v.x);
        v.y = (float) Math.floor(v.y);
        v.z = (float) Math.floor(v.z);
        return v;
    }

    public static float dist2p(Vector3f p1, Vector3f p2) {
        return (float) Math.sqrt(pow2(p2.x - p1.x) + pow2(p2.y - p1.y) + pow2(p2.z - p1.z));
    }

    public static float dist2p(Vector2f p1, Vector2f p2) {
        return (float) Math.sqrt(pow2(p2.x - p1.x) + pow2(p2.y - p1.y));
    }

    public static float pow2(float f) {
        return f * f;
    }

    public static void rotateVector(Vector2f vec, float angleDeg, Vector2f origin) {
        float x = vec.x - origin.x;
        float y = vec.y - origin.y;

        float cos = Math.cos(Math.toRadians(angleDeg)),
                sin = Math.sin(Math.toRadians(angleDeg));

        vec.x = x * cos - y * sin + origin.x;
        vec.y = x * sin + y * cos + origin.y;
    }

    public static boolean compare(float x, float y, float precision) {
        return Math.abs(x - y) <= precision * Math.max(1.0f, Math.max(Math.abs(x), Math.abs(y)));
    }

    public static boolean compare(Vector2f v1, Vector2f v2, float precision) {
        return compare(v1.x, v2.x, precision) && compare(v1.y, v2.y, precision);
    }

    public static boolean compare(float x, float y) {
        return Math.abs(x - y) <= Float.MIN_VALUE * Math.max(1.0f, Math.max(Math.abs(x), Math.abs(y)));
    }

    public static boolean compare(Vector2f v1, Vector2f v2) {
        return compare(v1.x, v2.x) && compare(v1.y, v2.y);
    }
}
