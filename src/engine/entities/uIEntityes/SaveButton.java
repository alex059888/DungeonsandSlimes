package engine.entities.uIEntityes;

import engine.entities.Entity;
import engine.entities.EntityManager;
import engine.entities.tiles.Terain.usables.UsableTile;
import engine.handler.Handler;
import engine.scenes.worlds.EditableWorld;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveButton extends Button {
    private EditableWorld world;

    public SaveButton(float x, float y, float z, float rX, float rY, float rZ, Handler handler, EditableWorld world) {
        super(x, y, z, rX, rY, rZ, 2, 0, 3, 0, 64f, 32f, handler, 2);
        setAdjusters(192f, 234f, 16f, -16f);
        this.world = world;
    }

    public SaveButton(float x, float y, float z, Handler handler, EditableWorld world) {
        super(x, y, z, 2, 0, 3, 0, 64f, 32f, handler, 2);
        setAdjusters(192f, 234f, 16f, -16f);
        this.world = world;
    }

    @Override
    protected void doAction() {
        super.doAction();
        if (!world.playerExists()) {
            System.err.println("Player does not exist!");
            return;
        }
        try {
            File myObj = new File(world.getSaveFilePath());
            if (myObj.delete()) {
                System.out.println("Deleted the file: " + myObj.getName() + " " + myObj.getAbsolutePath());
            } else {
                System.out.println("Failed to delete the file." + myObj.getAbsolutePath());
            }
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName() + " " + myObj.getAbsolutePath());
            } else {
                System.out.println("File already exists." + myObj.getAbsolutePath());
            }

            //write the save
            try {
                FileWriter myWriter = new FileWriter(myObj);
                myWriter.write(world.getMapWidth() + " " + world.getMapHeight());
                myWriter.write('\n');
                for (int j = 0; j < world.getMapHeight(); j++) {
                    for (int i = 0; i < world.getMapWidth(); i++) {
                        myWriter.write(world.getTile(i,j).getId() + " ");
                    }
                    myWriter.write('\n');
                }

                myWriter.write(world.getUsableTiles().size() + " "  + '\n');

                for (UsableTile t : world.getUsableTiles())
                    myWriter.write( (int) t.transform.position.x + " " + (int) t.transform.position.y + "" + t.getId() + '\n');

                myWriter.write(world.getEntityManager().getEntities().size() + "" + '\n');

                for (Entity e : world.getEntityManager().getEntities())
                    myWriter.write( (int) e.transform.position.x + " " + (int) e.transform.position.y + " " + e.getId() + '\n');

                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        } catch (IOException e) {
            System.err.println("An error creating the save file occurred.");
            e.printStackTrace();
        }
    }
}
