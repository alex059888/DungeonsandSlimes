package engine.scenes;

import engine.events.EventManager;
import engine.gfx.Camera;
import engine.gfx.shaders.DefaultShader;
import engine.gfx.shaders.Shader;
import engine.handler.Handler;
import engine.scenes.worlds.EditableWorld;

import static org.lwjgl.opengl.GL13.GL_TEXTURE0;
import static org.lwjgl.opengl.GL13.glActiveTexture;

public class LevelEditorScene extends Scene{

    private Shader defaultShader;

    public LevelEditorScene(Handler handler) {
        super(handler);
        defaultShader = new DefaultShader();
        handler.setDefaultShader(defaultShader);
        eventManager = new EventManager();

        world = new EditableWorld(24, 16, handler);
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
