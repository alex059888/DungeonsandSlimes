package engine.entities.uIEntityes;

import engine.handler.Handler;
import engine.scenes.LevelEditorScene;
import engine.scenes.LevelScene;

public class EditorButton extends Button{
    public EditorButton(float x, float y, float z, float rX, float rY, float rZ, Handler handler) {
        super(x, y, z, rX, rY, rZ, 0, 1, 1, 1, 64f, 32f, handler, 2);
        setAdjusters(192f, 234f, -16f, 16);
    }

    public EditorButton(float x, float y, float z, Handler handler) {
        super(x, y, z, 0, 1, 1, 1, 64f, 32f, handler, 2);
        setAdjusters(192f, 234f, -16f, 16f);
    }

    @Override
    protected void doAction() {
        super.doAction();
        handler.getGame().changeScene(new LevelEditorScene(handler));
    }
}
