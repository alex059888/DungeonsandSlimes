package engine.entities.creatures;

import engine.handler.Handler;

public class GreenSlime extends Enemy{
    public GreenSlime(Creature creature) {
        super(creature);
    }

    public GreenSlime(float x, float y, float z, float rX, float rY, float rZ, Handler handler, int id) {
        super(x, y, z, rX, rY, rZ, handler, 0, 12, 15, id);
        setDpt(30);
        xVal = 1;
        yVal = 1;
    }

    public GreenSlime(float x, float y, float z, Handler handler, int id) {
        super(x, y, z, handler, 0, 12, 15, id);
        setDpt(30);
        xVal = 1;
        yVal = 1;
    }
}
