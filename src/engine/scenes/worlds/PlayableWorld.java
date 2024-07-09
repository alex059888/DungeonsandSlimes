package engine.scenes.worlds;

import engine.entities.tiles.Terain.usables.UsableTile;
import engine.entities.uIEntityes.BackToMenuButton;
import engine.entities.uIEntityes.Button;
import engine.entities.uIEntityes.IGBH;
import engine.entities.uIEntityes.UIEntity;
import engine.gfx.textures.Texture;
import engine.handler.Handler;
import engine.io.KeyListener;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_ESCAPE;

public class PlayableWorld extends World{

    private int delayBetweenMods = 0;
    private boolean menuMode = false;
    private UIEntity background;
    private Button backButton;

    public PlayableWorld(int mapWidth, int mapHeight, Handler handler) {
        super(mapWidth,mapHeight,handler);
    }

    public void tick() {
        if(!menuMode) {
            for (int i = 0; i < mapWidth; i++) {
                for (int j = 0; j < mapHeight; j++) {
                    tiles[i][j].tick();
                }
            }

            if (usableTiles.size() > 0)
                for (UsableTile t : usableTiles) {
                    t.tick();
                }
            entityManager.tick();

            if (KeyListener.isKeyPressed(GLFW_KEY_ESCAPE) && delayBetweenMods == 0) {
                menuMode = true;
                delayBetweenMods = 10;
            } else {
                if (delayBetweenMods > 0) delayBetweenMods--;
            }
        } else {
            menuTick();
        }
    }

    public void render() {
        Texture.getTexture(0).bind();
        for(int i = 0; i < mapWidth;i++) {
            for(int j = 0; j < mapHeight; j++) {
                tiles[i][j].render();
            }
        }

        if(usableTiles.size() > 0)
            for (UsableTile t : usableTiles) {
                t.render();
            }
        entityManager.render();

        if (menuMode) {
            if (background == null) {
                background = new IGBH(handler.getCamera().getPos().x, handler.getCamera().getPos().y, handler.getCamera().getPos().z - 0.1f, handler);
                background.setScale(4);
            }
            background.render();
            if (backButton == null) {
                backButton = new BackToMenuButton(handler.getCamera().getPos().x-7f, handler.getCamera().getPos().y-5.3f, handler.getCamera().getPos().z - 0f, handler);
                backButton.setScale(3.5f);
            }
            backButton.render();
        }
    }

    private void menuTick() {
        background = new IGBH(handler.getCamera().getPos().x,handler.getCamera().getPos().y,handler.getCamera().getPos().z-0.1f,handler);
        background.setScale(4);

        backButton = new BackToMenuButton(handler.getCamera().getPos().x-7f, handler.getCamera().getPos().y-5.3f, handler.getCamera().getPos().z - 0f, handler);
        backButton.setScale(3.5f);

        backButton.tick();

        if (delayBetweenMods > 0){
            delayBetweenMods--;
        }

        if (KeyListener.isKeyPressed(GLFW_KEY_ESCAPE) && delayBetweenMods == 0) {
            menuMode = false;
            delayBetweenMods = 10;
        }
    }
}
