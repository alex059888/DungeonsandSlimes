package engine.entities.uIEntityes.levels;

import engine.handler.Handler;

public class Level9Button extends LevelButton{
    private static String level = "./res/maps/Level9.txt";

    public Level9Button(float x, float y, float z, float rX, float rY, float rZ, Handler handler) {
        super(x, y, z, rX, rY, rZ, 0, 8, 1, 8, 64, 32, handler, 4, level);
        setAdjusters(-234f, -192f, 64f, 96f);
    }

    public Level9Button(float x, float y, float z, Handler handler) {
        super(x, y, z, 0, 8, 1, 8, 64, 32, handler, 4, level);
        setAdjusters(-234f, -192f, 64f, 96f);
    }
}
