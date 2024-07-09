package engine.entities.uIEntityes.levels;

import engine.entities.creatures.Creature;
import engine.entities.creatures.Player;
import engine.entities.tiles.Terain.usables.UsableTile;
import engine.entities.tiles.Tile;
import engine.entities.uIEntityes.Button;
import engine.handler.Handler;
import engine.scenes.LevelScene;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LevelButton extends Button {
    private String level;

    public LevelButton(float x, float y, float z, float rX, float rY, float rZ, float tx, float ty, float tx2, float ty2, float sizeX, float sizeY, Handler handler, int texID, String level) {
        super(x, y, z, rX, rY, rZ, tx, ty, tx2, ty2, sizeX, sizeY, handler, texID);
        this.level = level;
    }

    public LevelButton(float x, float y, float z, float tx, float ty, float tx2, float ty2, float sizeX, float sizeY, Handler handler, int texID, String level) {
        super(x, y, z, tx, ty, tx2, ty2, sizeX, sizeY, handler, texID);
        this.level = level;
    }

    @Override
    public void doAction() {
        super.doAction();

        try {
            File file = new File(level);
            Scanner reader = new Scanner(file);

            handler.getGame().changeScene(new LevelScene(handler));

            handler.getWorld().setMapWidth(reader.nextInt());
            handler.getWorld().setMapHeight(reader.nextInt());

            handler.getWorld().setTiles(new Tile[handler.getWorld().getMapWidth()][handler.getWorld().getMapHeight()]);

            for (int j = 0; j < handler.getWorld().getMapHeight(); j++) {
                for (int i = 0; i < handler.getWorld().getMapWidth(); i++) {
                    handler.getWorld().setTile(i, j, Tile.getTile(reader.nextInt()).setParams(i, j, -1f, 0, handler));
                }
            }

            int j = reader.nextInt();
            for (int i = 0; i < j; i++) {
                if (reader.hasNextLine()) {
                    int x = (int) reader.nextFloat(), y = (int) reader.nextFloat();
                    int id = reader.nextInt();
                    handler.getWorld().addUsableTile(UsableTile.getUsableTile(id).setParams(x,y,-0.7f,handler));
                }
            }

            j = reader.nextInt();
            for (int i = 0; i < j; i++) {
                if (reader.hasNextLine()) {
                    int x = reader.nextInt(), y = reader.nextInt();
                    int id = reader.nextInt();
                    if (id == 0) {
                        handler.getWorld().getEntityManager().addEntity(new Player(x, y, 0, handler, id));
                        handler.setCamera(handler.getWorld().getEntityManager().getEntity(handler.getWorld().getEntityManager().getEntities().size()-1).getCamera());
                    } else {
                        handler.getWorld().getEntityManager().addEntity(Creature.getCreature(id).setParams(x, y, -0.6f, handler));
                    }
                }
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
