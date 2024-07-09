package engine.entities.uIEntityes;

import engine.handler.Handler;
import engine.scenes.LevelSelectScene;

public class PlayButton extends Button{
    public PlayButton(float x, float y, float z, float rX, float rY, float rZ, Handler handler) {
        super(x, y, z, rX, rY, rZ, 0, 0, 1, 0, 64f, 32f, handler, 2);
        setAdjusters(192f, 234f, 160f, 192f);
    }

    public PlayButton(float x, float y, float z, Handler handler) {
        super(x, y, z, 0, 0, 1, 0, 64f, 32f, handler, 2);
        setAdjusters(192f, 234f, 160f, 192f);
    }

    @Override
    protected void doAction() {
        super.doAction();
        handler.getGame().changeScene(new LevelSelectScene(handler));
    }
}
