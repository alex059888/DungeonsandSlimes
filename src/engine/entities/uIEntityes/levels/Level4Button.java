package engine.entities.uIEntityes.levels;

import engine.handler.Handler;

public class Level4Button extends LevelButton{
    private static String level = "./res/maps/Level4.txt";

    public Level4Button(float x, float y, float z, float rX, float rY, float rZ, Handler handler) {
        super(x, y, z, rX, rY, rZ, 0, 3, 1, 3, 64, 32, handler, 4, level);
        setAdjusters(-32f, 32f, 160f, 192f);
    }

    public Level4Button(float x, float y, float z, Handler handler) {
        super(x, y, z, 0, 3, 1, 3, 64, 32, handler, 4, level);
        setAdjusters(-32f, 32f, 160f, 192f);
    }
}
