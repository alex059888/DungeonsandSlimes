package engine.entities.uIEntityes;

import engine.handler.Handler;

public class LevelSelectMenuBackground extends UIEntity {
    public LevelSelectMenuBackground(float x, float y, float z, float rX, float rY, float rZ, Handler handler) {
        super(x, y, z, rX, rY, rZ, 192, 128, 768, 512, handler, 10);
    }

    public LevelSelectMenuBackground(float x, float y, float z, Handler handler) {
        super(x, y, z, 192, 128, 768, 512, handler, 10);
    }
}
