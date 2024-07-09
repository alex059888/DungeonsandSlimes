package engine.entities.uIEntityes.levels;

import engine.handler.Handler;

public class Level6Button extends LevelButton{
    private static String level = "./res/maps/Level6.txt";

    public Level6Button(float x, float y, float z, float rX, float rY, float rZ, Handler handler) {
        super(x, y, z, rX, rY, rZ, 0, 5, 1, 5, 64, 32, handler, 4, level);
        setAdjusters(-32f, 32f, 64f, 96f);
    }

    public Level6Button(float x, float y, float z, Handler handler) {
        super(x, y, z, 0, 5, 1, 5, 64, 32, handler, 4, level);
        setAdjusters(-32f, 32f, 64f, 96f);
    }
}
