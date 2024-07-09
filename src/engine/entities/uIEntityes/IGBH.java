package engine.entities.uIEntityes;

import engine.handler.Handler;

public class IGBH extends UIEntity {
    public IGBH(float x, float y, float z, float rX, float rY, float rZ, Handler handler) {
        super(x, y, z, rX, rY, rZ, 768, 512,192, 128,  handler, 9);
    }

    public IGBH(float x, float y, float z, Handler handler) {
        super(x, y, z, 768, 512, 192, 128, handler, 9);
    }
}
