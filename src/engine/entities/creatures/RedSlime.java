package engine.entities.creatures;

import engine.handler.Handler;

public class RedSlime extends Enemy{
    public RedSlime(Creature creature) {
        super(creature);
    }

    public RedSlime(float x, float y, float z, float rX, float rY, float rZ, Handler handler, int id) {
        super(x, y, z, rX, rY, rZ, handler, 0, 13, 15, id);
        setDpt(20);
        xVal = 1;
    }

    public RedSlime(float x, float y, float z, Handler handler, int id) {
        super(x, y, z, handler, 0, 13, 15, id);
        setDpt(20);
        xVal = 1;
    }
}
