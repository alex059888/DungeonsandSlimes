package engine.gfx.textures;

import org.joml.Vector2f;

public class MenuScreenTexture extends Texture{
    public MenuScreenTexture(int id) {
        super("./res/textures/MenuScreen.png", new Vector2f(768f,512f), id);
    }
}
