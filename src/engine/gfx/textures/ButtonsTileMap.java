package engine.gfx.textures;

import org.joml.Vector2f;

public class ButtonsTileMap extends Texture{
    public ButtonsTileMap(int id) {
        super("./res/textures/MenuButtons.png", new Vector2f(256f,96f), id);
    }
}
