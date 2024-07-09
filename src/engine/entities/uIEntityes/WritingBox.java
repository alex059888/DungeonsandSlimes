package engine.entities.uIEntityes;

import engine.handler.Handler;

public class WritingBox extends UIEntity{
    public WritingBox(float x, float y, float z, float rX, float rY, float rZ, Handler handler) {
        super(x, y, z, rX, rY, rZ, 0, 0, 64, 16, handler, 8);
    }

    public WritingBox(float x, float y, float z, Handler handler) {
        super(x, y, z, 0, 0, 64, 16, handler, 8);
    }
}
