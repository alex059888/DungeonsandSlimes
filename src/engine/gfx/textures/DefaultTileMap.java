package engine.gfx.textures;

import org.joml.Vector2f;

public class DefaultTileMap extends Texture{
    public DefaultTileMap(int id) {
        super("./res/textures/DungeonTileMap.png", new Vector2f(512f,512f), id);
    }
}
