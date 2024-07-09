package engine.entities.uIEntityes.levels;

import engine.handler.Handler;

public class Level8Button extends LevelButton{
    private static String level = "./res/maps/Level8.txt";

    public Level8Button(float x, float y, float z, float rX, float rY, float rZ, Handler handler) {
        super(x, y, z, rX, rY, rZ, 0, 7, 1, 7, 64, 32, handler, 4, level);
        setAdjusters(-234f, -192f, 112f, 144f);
    }

    public Level8Button(float x, float y, float z, Handler handler) {
        super(x, y, z, 0, 7, 1, 7, 64, 32, handler, 4, level);
        setAdjusters(-234f, -192f, 112f, 144f);
    }
}
