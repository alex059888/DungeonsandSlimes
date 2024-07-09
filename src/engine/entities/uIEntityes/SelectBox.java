package engine.entities.uIEntityes;

import engine.handler.Handler;

public class SelectBox extends UIEntity{
    public SelectBox(float x, float y, float z, float rX, float rY, float rZ, Handler handler) {
        super(x, y, z, rX, rY, rZ, 0, 0, 48, 48, handler, 7);
    }

    public SelectBox(float x, float y, float z, Handler handler) {
        super(x, y, z, 0, 0, 48, 48, handler, 7);
    }
}
