package engine.entities.uIEntityes.levels;

import engine.handler.Handler;

public class Level1Button extends LevelButton{
    private static String level = "./res/maps/Level1.txt";

    public Level1Button(float x, float y, float z, float rX, float rY, float rZ, Handler handler) {
        super(x, y, z, rX, rY, rZ, 0, 0, 1, 0, 64, 32, handler, 4, level);
        setAdjusters(192f, 234f, 160f, 192f);
    }

    public Level1Button(float x, float y, float z, Handler handler) {
        super(x, y, z, 0, 0, 1, 0, 64, 32, handler, 4, level);
        setAdjusters(192f, 234f, 160f, 192f);
    }
}
