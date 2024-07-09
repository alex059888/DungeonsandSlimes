package engine.scenes;

import engine.entities.BlancEntity;
import engine.entities.Entity;
import engine.entities.uIEntityes.*;
import engine.gfx.Camera;
import engine.gfx.shaders.DefaultShader;
import engine.gfx.shaders.Shader;
import engine.handler.Handler;
import engine.io.KeyListener;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_SPACE;
import static org.lwjgl.opengl.GL13.GL_TEXTURE0;
import static org.lwjgl.opengl.GL13.glActiveTexture;

public class MenuScene extends Scene{
    private DefaultShader defaultShader;
    private MenuBackground menuBackground;
    private BlancEntity posEntity;
    private Button playButton, quitButton, editorButton;
    private UITitle title;

    private int tBBP;

    public MenuScene(Handler handler) {
        super(handler);

        tBBP = 8;

        defaultShader = new DefaultShader();
        handler.setDefaultShader(defaultShader);
        menuBackground = new MenuBackground(0,0,-1f,0,0,handler);
        playButton = new PlayButton(-7f,5.3f,-0.1f,handler);
        playButton.setScale(3.3f);
        quitButton = new QuitButton(-7f, -5.3f, -0.1f, handler);
        quitButton.setScale(3.3f);
        editorButton = new EditorButton(-7f, 0, -0.1f, handler);
        editorButton.setScale(3.3f);
        title = new UITitle(4,0,-0.1f,handler);
        title.setScale(3);
        posEntity = new BlancEntity(0,0,0,handler);
        handler.setCamera(new Camera(posEntity));
    }

    @Override
    public void tick() {
        if (tBBP > 0) {
            tBBP--;
            return;
        }

        playButton.tick();
        quitButton.tick();
        editorButton.tick();
    }

    @Override
    public void render() {
        defaultShader.bind();
        defaultShader.setTexture("tex", 0);
        glActiveTexture(GL_TEXTURE0);
        handler.getDefaultShader().setProjection(Camera.getOrthographicMatrix());
        handler.getDefaultShader().setView(handler.getCamera().getView());
        menuBackground.render();
        playButton.render();
        quitButton.render();
        editorButton.render();
        title.render();
        Shader.unbind();
    }
}
