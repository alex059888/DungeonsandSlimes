package engine.entities.uIEntityes.levels;

import engine.handler.Handler;

public class Level5Button extends LevelButton{
    private static String level = "./res/maps/Level5.txt";

    public Level5Button(float x, float y, float z, float rX, float rY, float rZ, Handler handler) {
        super(x, y, z, rX, rY, rZ, 0, 4, 1, 4, 64, 32, handler, 4, level);
        setAdjusters(-32f, 32f, 112f, 144f);
    }

    public Level5Button(float x, float y, float z, Handler handler) {
        super(x, y, z, 0, 4, 1, 4, 64, 32, handler, 4, level);
        setAdjusters(-32f, 32f, 112f, 144f);
    }
}
