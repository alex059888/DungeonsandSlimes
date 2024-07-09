package engine.entities;

import engine.entities.creatures.Creature;
import engine.entities.creatures.Player;
import engine.handler.Handler;

import java.util.ArrayList;
import java.util.List;

public class EntityManager {
    private List<Entity> entities;
    private Handler handler;

    public EntityManager(Handler handler) {
        entities = new ArrayList<>();
        this.handler = handler;
    }

    public EntityManager(List<Entity> entities, Handler handler) {
        this.entities = entities;
        this.handler = handler;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public Entity getEntity(int id) {
        return entities.get(id);
    }

    public Entity getEntity(int x, int y) {
        for (Entity e : entities) {
            if ((int) e.transform.position.x == x && (int) e.transform.position.y == y)
                return e;
        }
        return null;
    }

    public Entity getEntity(int x, int y, Entity self) {
        for (Entity e : entities) {
            if (!e.equals(self))
                if ((int) e.transform.position.x == x && (int) e.transform.position.y == y)
                    return e;
        }
        return null;
    }

    public Entity getEntity(int x, int y, int selfId) {
        for (Entity e : entities) {
            if (e.getId() != selfId)
                if ((int) e.transform.position.x == x && (int) e.transform.position.y == y)
                    return e;
        }
        return null;
    }

    public void addEntity(Creature e) {
        entities.add(e);
    }

    public void removeEntity(Entity e) {
        if (e != null)
            entities.remove(e);
    }

    public void removeEntity(int id) {
        entities.remove(id);
    }

    public void tick() {
        for (Entity e : entities) {
            e.tick();
        }
    }

    public void render() {
        for (Entity e : entities) {
            e.render();
        }
    }
}
