package engine.scenes;

import engine.events.EventManager;
import engine.handler.Handler;
import engine.scenes.worlds.World;

public abstract class Scene {
    protected Handler handler;

    protected World world;

    protected EventManager eventManager;

    public Scene(Handler handler) {
        this.handler = handler;

        handler.changeSceneScene(this);
    }

    public abstract void tick();

    public abstract void render();

    public World getWorld() {
        return world;
    }

    public EventManager getEventManager() {
        return eventManager;
    }
}
