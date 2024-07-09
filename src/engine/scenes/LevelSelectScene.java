package engine.scenes;

import engine.entities.BlancEntity;
import engine.entities.uIEntityes.BackToMenuButton;
import engine.entities.uIEntityes.Button;
import engine.entities.uIEntityes.LevelSelectMenuBackground;
import engine.entities.uIEntityes.UIEntity;
import engine.entities.uIEntityes.levels.*;
import engine.gfx.Camera;
import engine.gfx.shaders.DefaultShader;
import engine.gfx.shaders.Shader;
import engine.handler.Handler;

import static org.lwjgl.opengl.GL13.GL_TEXTURE0;
import static org.lwjgl.opengl.GL13.glActiveTexture;

public class LevelSelectScene extends Scene{
    private DefaultShader defaultShader;
    private BlancEntity posEntity;
    private Button backButton, lvl1,lvl2,lvl3,lvl4,lvl5,lvl6,lvl7,lvl8,lvl9, editorLvl;
    private UIEntity background;

    private int tBBP;

    public LevelSelectScene(Handler handler) {
        super(handler);

        tBBP = 8;

        defaultShader = new DefaultShader();
        handler.setDefaultShader(defaultShader);

        backButton = new BackToMenuButton(-7f, -5.3f, -0.1f,handler);
        backButton.setScale(2);
        background = new LevelSelectMenuBackground(0,0,-0.2f,handler);
        background.setScale(2.3f);
        lvl1 = new Level1Button(-7f,5.3f,-0.1f,handler);
        lvl1.setScale(2);
        lvl2 = new Level2Button(-7f,3.8f,-0.1f,handler);
        lvl2.setScale(2);
        lvl3 = new Level3Button(-7f,2.3f,-0.1f,handler);
        lvl3.setScale(2);

        lvl4 = new Level4Button(0f,5.3f,-0.1f,handler);
        lvl4.setScale(2);
        lvl5 = new Level5Button(0f,3.8f,-0.1f,handler);
        lvl5.setScale(2);
        lvl6 = new Level6Button(0f,2.3f,-0.1f,handler);
        lvl6.setScale(2);

        lvl7 = new Level7Button(7f,5.3f,-0.1f,handler);
        lvl7.setScale(2);
        lvl8 = new Level8Button(7f,3.8f,-0.1f,handler);
        lvl8.setScale(2);
        lvl9 = new Level9Button(7f,2.3f,-0.1f,handler);
        lvl9.setScale(2);

        editorLvl = new EditedLevelPlayButton(7f, -5.3f, -0.1f,handler);
        editorLvl.setScale(2);

        posEntity = new BlancEntity(0,0,0,handler);
        handler.setCamera(new Camera(posEntity));
    }

    @Override
    public void tick() {
        if (tBBP > 0) {
            tBBP--;
            return;
        }

        background.tick();
        backButton.tick();
        lvl1.tick();
        if (handler.getGame().levelsUnlocked > 1)
        lvl2.tick();
        if (handler.getGame().levelsUnlocked > 2)
        lvl3.tick();
        if (handler.getGame().levelsUnlocked > 3)
        lvl4.tick();
        if (handler.getGame().levelsUnlocked > 4)
        lvl5.tick();
        if (handler.getGame().levelsUnlocked > 5)
        lvl6.tick();
        if (handler.getGame().levelsUnlocked > 6)
        lvl7.tick();
        if (handler.getGame().levelsUnlocked > 7)
        lvl8.tick();
        if (handler.getGame().levelsUnlocked > 8)
        lvl9.tick();
        editorLvl.tick();
    }

    @Override
    public void render() {
        defaultShader.bind();
        defaultShader.setTexture("tex", 0);
        glActiveTexture(GL_TEXTURE0);
        handler.getDefaultShader().setProjection(Camera.getOrthographicMatrix());
        handler.getDefaultShader().setView(handler.getCamera().getView());
        background.render();
        backButton.render();
        lvl1.render();
        lvl2.render();
        lvl3.render();
        lvl4.render();
        lvl5.render();
        lvl6.render();
        lvl7.render();
        lvl8.render();
        lvl9.render();
        editorLvl.render();
        Shader.unbind();
    }
}
