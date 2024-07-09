package engine.entities.uIEntityes.levels;

import engine.handler.Handler;

public class Level7Button extends LevelButton{
    private static String level = "./res/maps/Level7.txt";

    public Level7Button(float x, float y, float z, float rX, float rY, float rZ, Handler handler) {
        super(x, y, z, rX, rY, rZ, 0, 6, 1, 6, 64, 32, handler, 4, level);
        setAdjusters(-234f, -192f, 160f, 192f);
    }

    public Level7Button(float x, float y, float z, Handler handler) {
        super(x, y, z, 0, 6, 1, 6, 64, 32, handler, 4, level);
        setAdjusters(-234f, -192f, 160f, 192f);
    }
}
