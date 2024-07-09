package engine.entities.uIEntityes;

import engine.handler.Handler;

public class MenuBackground extends UIEntity{
    public MenuBackground(float x, float y, float z, float rX, float rY, float rZ, float tx, float ty, Handler handler) {
        super(x, y, z, rX, rY, rZ, tx, ty, 768, 512, handler, 1);
    }

    public MenuBackground(float x, float y, float z, float tx, float ty, Handler handler) {
        super(x, y, z, tx, ty, 768, 512, handler, 1);
    }
}
