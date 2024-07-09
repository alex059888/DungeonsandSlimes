package engine.scenes;

import engine.events.EventManager;
import engine.gfx.Camera;
import engine.gfx.shaders.DefaultShader;
import engine.gfx.shaders.Shader;
import engine.handler.Handler;
import engine.scenes.worlds.PlayableWorld;
import engine.scenes.worlds.World;

import static org.lwjgl.opengl.GL13.GL_TEXTURE0;
import static org.lwjgl.opengl.GL13.glActiveTexture;

public class LevelScene extends Scene{
    private Shader defaultShader;

    public LevelScene(Handler handler) {
        super(handler);
        defaultShader = new DefaultShader();
        handler.setDefaultShader(defaultShader);
        eventManager = new EventManager();

        world = new PlayableWorld(24, 16, handler);
    }

    @Override
    public void tick() {
        eventManager.tick();
        world.tick();
    }
    @Override
    public void render() {
        defaultShader.bind();
        defaultShader.setTexture("tex", 0);
        glActiveTexture(GL_TEXTURE0);
        handler.getDefaultShader().setProjection(Camera.getOrthographicMatrix());
        handler.getDefaultShader().setView(handler.getCamera().getView());
        world.render();
        Shader.unbind();
    }
}
