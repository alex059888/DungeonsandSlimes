package engine.entities.uIEntityes;

import engine.handler.Handler;

public class InGameMenuBackground extends UIEntity{
    public InGameMenuBackground(float x, float y, float z, float rX, float rY, float rZ, Handler handler) {
        super(x, y, z, rX, rY, rZ, 0, 0, 768, 512, handler, 6);
    }

    public InGameMenuBackground(float x, float y, float z, Handler handler) {
        super(x, y, z, 0, 0, 768, 512, handler, 6);
    }
}
