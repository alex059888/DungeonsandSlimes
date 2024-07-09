package engine.entities.uIEntityes.levels;

import engine.handler.Handler;

public class EditedLevelPlayButton extends LevelButton {
    private static String level = "./res/maps/savedMap.txt";
    public EditedLevelPlayButton(float x, float y, float z, float rX, float rY, float rZ, Handler handler) {
        super(x, y, z, rX, rY, rZ, 0, 0, 1, 0, 64f, 32f, handler, 2, level);
        setAdjusters(-234f, -192f, -160f, -192f);
    }

    public EditedLevelPlayButton(float x, float y, float z, Handler handler) {
        super(x, y, z, 0, 0, 1, 0, 64f, 32f, handler, 2, level);
        setAdjusters(-234f, -192f, -192f, -160f);
    }
}
