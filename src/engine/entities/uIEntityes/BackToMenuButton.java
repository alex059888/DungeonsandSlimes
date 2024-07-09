package engine.entities.uIEntityes;

import engine.handler.Handler;
import engine.scenes.MenuScene;

public class BackToMenuButton extends Button{
    public BackToMenuButton(float x, float y, float z, float rX, float rY, float rZ, Handler handler) {
        super(x, y, z, rX, rY, rZ, 0, 3, 1, 3, 64f, 32f, handler, 2);
        setAdjusters(192f, 234f, -160f, -192f);
    }

    public BackToMenuButton(float x, float y, float z, Handler handler) {
        super(x, y, z, 0, 2, 1, 2, 64f, 32f, handler, 2);
        setAdjusters(192f, 234f, -192f, -160f);
    }

    @Override
    protected void doAction() {
        super.doAction();
        handler.getGame().changeScene(new MenuScene(handler));
    }
}
