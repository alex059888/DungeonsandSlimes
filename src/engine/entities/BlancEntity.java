package engine.entities;

import engine.handler.Handler;

public class BlancEntity extends Entity{

    public BlancEntity(float x, float y, float z, Handler handler) {
        super(x, y, z, handler, 0, 0);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render() {

    }

    @Override
    protected void genMesh() {

    }

    @Override
    public void onContact() {}
}
