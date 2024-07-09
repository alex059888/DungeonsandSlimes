package engine.entities.tiles.Terain.usables;

import engine.entities.Entity;
import engine.handler.Handler;
import engine.scenes.MenuScene;

public class Spikes extends UsableTile{
    public Spikes(float x, float y, float z, float rX, float rY, float rZ, Handler handler, int id) {
        super(x, y, z, rX, rY, rZ, handler, 0, 4, 6,4,7, id);
    }

    public Spikes(int id) {
        super(0, 0, 0, 0, 0, 0, null, 0, 4, 6,4,7, id);
    }

    public Spikes(UsableTile tile) {
        super(tile);
    }

    @Override
    public void use(Entity e) {
        super.use(e);
        if (state == 1)
            handler.getGame().changeScene(new MenuScene(handler));
    }

    @Override
    public void tick() {
        if (cDpt > 0) {
            cDpt--;
            return;
        } else
            cDpt = dpt;
        state++;
        if (state > maxState)
            state = 0;

        if (state == 0)
            genMesh();
        if (state == 1)
            genMesh1();
        super.tick();
    }
}
