package engine.entities.uIEntityes.levels;

import engine.handler.Handler;

public class Level3Button extends LevelButton{
    private static String level = "./res/maps/Level3.txt";

    public Level3Button(float x, float y, float z, float rX, float rY, float rZ, Handler handler) {
        super(x, y, z, rX, rY, rZ, 0, 2, 1, 2, 64, 32, handler, 4, level);
        setAdjusters(192f, 234f, 64f, 96f);
    }

    public Level3Button(float x, float y, float z, Handler handler) {
        super(x, y, z, 0, 2, 1, 2, 64, 32, handler, 4, level);
        setAdjusters(192f, 234f, 64f, 96f);
    }
}
