package engine.entities.uIEntityes.levels;

import engine.handler.Handler;

public class Level2Button extends LevelButton{
    private static String level = "./res/maps/Level2.txt";

    public Level2Button(float x, float y, float z, float rX, float rY, float rZ, Handler handler) {
        super(x, y, z, rX, rY, rZ, 0, 1, 1, 1, 64, 32, handler, 4, level);
        setAdjusters(192f, 234f, 112f, 144f);
    }

    public Level2Button(float x, float y, float z, Handler handler) {
        super(x, y, z, 0, 1, 1, 1, 64, 32, handler, 4, level);
        setAdjusters(192f, 234f, 112f, 144f);
    }
}
