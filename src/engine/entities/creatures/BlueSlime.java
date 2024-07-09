package engine.entities.creatures;

import engine.handler.Handler;

public class BlueSlime extends Enemy{
    public BlueSlime(Creature creature) {
        super(creature);
    }

    public BlueSlime(float x, float y, float z, float rX, float rY, float rZ, Handler handler, int id) {
        super(x, y, z, rX, rY, rZ, handler, 0, 14, 15, id);
        setDpt(20);
        yVal = 1;
    }

    public BlueSlime(float x, float y, float z, Handler handler, int id) {
        super(x, y, z, handler, 0, 14, 15, id);
        setDpt(20);
        yVal = 1;
    }
}
