package engine.entities.uIEntityes;

import engine.handler.Handler;

public class TextBarr extends UIEntity{
    public TextBarr(float x, float y, float z, float rX, float rY, float rZ, Handler handler) {
        super(x, y, z, rX, rY, rZ, 0, 3, 64f, 16f, handler, 8);
    }

    public TextBarr(float x, float y, float z, Handler handler) {
        super(x, y, z, 0, 2, 64f, 16f, handler, 8);
    }
}
