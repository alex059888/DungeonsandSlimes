package engine.scenes.worlds;

import engine.entities.BlancEntity;
import engine.entities.Entity;
import engine.entities.creatures.Creature;
import engine.entities.creatures.Player;
import engine.entities.tiles.Terain.usables.UsableTile;
import engine.entities.tiles.Tile;
import engine.entities.tiles.TileType;
import engine.entities.uIEntityes.*;
import engine.gfx.Camera;
import engine.gfx.textures.Texture;
import engine.handler.Handler;
import engine.io.KeyListener;
import engine.io.MouseListener;
import org.joml.Vector3f;

import static engine.entities.tiles.Tile.TILESIZE;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_W;

public class EditableWorld extends World {
    private int dpt = 3, cDpt = 0, scroll = 0;
    private int entitySelected, tileSelected, usableTileSelected;

    private Tile selectedTile;
    private Creature selectedCreature;

    private UsableTile uTileSelected;

    private BlancEntity camPosEntity;

    private Player cp;

    private SelectBox selectBox1;

    private boolean mD = false;

    //for the menu
    private boolean menuMode = false;

    private int delayBetweenMods = 0;

    private InGameMenuBackground inGameMenuBackground;

    private BackToMenuButton backToMenuButton;

    private SaveButton saveButton;

    private String saveFilePath;

    private WritingBox writingBox;

    //menu

    public EditableWorld(int mapWidth, int mapHeight, Handler handler) {
        super(mapWidth, mapHeight, handler);
        camPosEntity = new BlancEntity(0, 0, 1, handler);

        entitySelected = 0;
        tileSelected = 0;
        usableTileSelected = 0;

        selectedTile = Tile.getTile(tileSelected).setParams(0, 0, 0, 0, handler).getOrg();
        selectedTile.setScale(2);
        selectedCreature = Creature.getCreature(entitySelected).setParams(0, 0, handler);
        selectedCreature.setScale(2);
        uTileSelected = UsableTile.getUsableTile(usableTileSelected).setParams(0, 0, 0, handler);
        uTileSelected.setScale(2);
        selectBox1 = new SelectBox(0, 0, 0, handler);
        selectBox1.setScale(1.7f);
        writingBox = new WritingBox(-7f, 5.3f, 0.1f, handler);
        writingBox.setScale(3);

        inGameMenuBackground = new InGameMenuBackground(0, 0, 0, handler);
        inGameMenuBackground.setScale(4);
        backToMenuButton = new BackToMenuButton(-7f, -5.3f, 0.1f, handler);
        backToMenuButton.setScale(3.3f);
        saveButton = new SaveButton(-7f, 0, 0.1f, handler, this);
        saveButton.setScale(3.3f);

        saveFilePath = "./res/maps/savedMap.txt";

        handler.getCamera().setEntity(camPosEntity);
    }

    public void tick() {
        if (!menuMode) {

            camControls();

            if (scroll == 0)
                if (selectedTile != null && camPosEntity != null) {
                    selectedTile.transform.position = new Vector3f(camPosEntity.transform.position).add(9, 6, 0);
                    selectBox1.transform.position = new Vector3f(selectedTile.transform.position).add(0, 0, -0.1f);
                }
            if (scroll == 1)
                if (selectedCreature != null && camPosEntity != null) {
                    selectedCreature.transform.position = new Vector3f(camPosEntity.transform.position).add(9, 6, 0);
                    selectBox1.transform.position = new Vector3f(selectedCreature.transform.position).add(0, 0, -0.1f);
                }
            if (scroll == 2)
                if (uTileSelected != null && camPosEntity != null) {
                    uTileSelected.transform.position = new Vector3f(camPosEntity.transform.position).add(9, 6, 0);
                    selectBox1.transform.position = new Vector3f(uTileSelected.transform.position).add(0, 0, -0.1f);
                }

            if (dpt > 0) {
                if (cDpt > 0) {
                    cDpt--;
                    return;
                }
            }
            camMovement();

            if (scroll == 0)
                if (selectedTile != null && camPosEntity != null) {
                    selectedTile.transform.position = new Vector3f(camPosEntity.transform.position).add(9, 6, 0);
                    selectBox1.transform.position = new Vector3f(selectedTile.transform.position).add(0, 0, -0.1f);
                }
            if (scroll == 1)
                if (selectedCreature != null && camPosEntity != null) {
                    selectedCreature.transform.position = new Vector3f(camPosEntity.transform.position).add(9, 6, 0);
                    selectBox1.transform.position = new Vector3f(selectedCreature.transform.position).add(0, 0, -0.1f);
                }
            if (scroll == 2)
                if (uTileSelected != null && camPosEntity != null) {
                    uTileSelected.transform.position = new Vector3f(camPosEntity.transform.position).add(9, 6, 0);
                    selectBox1.transform.position = new Vector3f(uTileSelected.transform.position).add(0, 0, -0.1f);
                }
        } else {
            menuTick();
        }
    }

    public void render() {
        Texture.getTexture(0).bind();
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapHeight; j++) {
                tiles[i][j].render();
            }
        }
        if (usableTiles.size() > 0) {
            for (UsableTile t : usableTiles) {
                t.render();
            }
        }
        entityManager.render();

        if (!menuMode) {
            if (selectedTile != null && scroll == 0 && scroll == 0) {
                selectedTile.render();
            }
            if (selectedCreature != null && scroll == 1 && scroll == 1) {
                selectedCreature.render();
            }
            if (selectedCreature != null && scroll == 2 && scroll == 2) {
                uTileSelected.render();
            }
            selectBox1.render();
        } else {
            backToMenuButton.render();
            menuRender();
        }
    }

    private void camMovement() {
        int xM = 0, yM = 0;

        if (KeyListener.isKeyPressed(GLFW_KEY_A)) {
            xM -= 1;
        }
        if (KeyListener.isKeyPressed(GLFW_KEY_D)) {
            xM += 1;
        }
        if (KeyListener.isKeyPressed(GLFW_KEY_S)) {
            yM -= 1;
        }
        if (KeyListener.isKeyPressed(GLFW_KEY_W)) {
            yM += 1;
        }
        move(xM, yM);
        cDpt = dpt;
    }

    private void camControls() {
        if (MouseListener.getScrollY() > 0)
            if (scroll == 0) {
                tileSelected += 1;
            } else if (scroll == 1) {
                entitySelected += 1;
            } else {
                usableTileSelected += 1;
            }
        if (MouseListener.getScrollY() < 0)
            if (scroll == 0) {
                tileSelected -= 1;
            } else if (scroll == 1) {
                entitySelected -= 1;
            } else {
                usableTileSelected -= 1;
            }

        if (tileSelected >= Tile.tiles.size())
            tileSelected = 0;
        if (tileSelected < 0)
            tileSelected = Tile.tiles.size() - 1;
        if (entitySelected >= Creature.creatures.size())
            entitySelected = 0;
        if (entitySelected < 0)
            entitySelected = Creature.creatures.size() - 1;
        if (usableTileSelected >= UsableTile.usableTiles.size())
            usableTileSelected = 0;
        if (usableTileSelected < 0)
            usableTileSelected = UsableTile.usableTiles.size() - 1;

        selectedTile = Tile.getTile(tileSelected).setParams(0, 0, 0, 0, handler).getOrg();
        selectedTile.setScale(2);
        selectedCreature = Creature.getCreature(entitySelected).setParams(0, 0, handler);
        selectedCreature.setScale(2);

        if (MouseListener.mouseButtonDown(2) && !mD) {
            scroll += 1;
            if (scroll > 1)
                scroll = 0;
            mD = true;
        }

        if (!MouseListener.mouseButtonDown(2))
            mD = false;

        if (MouseListener.mouseButtonDown(0) && scroll == 0) {
            float x = ((MouseListener.getX() / handler.getWidth() + handler.getCamera().getPos().x * TILESIZE / handler.getDefaultWidth() - Camera.camWidth / 2 / handler.getDefaultWidth()) * mapWidth + 0.5f),
                    y = ((MouseListener.getY() / handler.getHeight() - handler.getCamera().getPos().y * TILESIZE / handler.getDefaultHeight() + Camera.camHeight / 2 / handler.getDefaultHeight()) * mapHeight - 0.5f);
            entityManager.removeEntity(entityManager.getEntity((int) x, (mapHeight - 1 - (int) y)));
            removeUsableTile((int) x, mapHeight - 1 - (int) y);
            if (x >= 0 && x < mapWidth && y >= 0 && y < mapHeight) {
                setTile((int) x, handler.getWorld().getMapHeight() - 1 - (int) y,
                        Tile.getTile(tileSelected).setParams(
                                ((int) x),
                                (mapHeight - 1 - (int) y),
                                -1f, 0, handler));
                tiles[(int) x][mapHeight - 1 - (int) y].setId(tileSelected);
            }
        }
        if (MouseListener.mouseButtonDown(0) && scroll == 1) {
            float x = ((MouseListener.getX() / handler.getWidth() + handler.getCamera().getPos().x * TILESIZE / handler.getDefaultWidth() - Camera.camWidth / 2 / handler.getDefaultWidth()) * mapWidth + 0.5f),
                    y = ((MouseListener.getY() / handler.getHeight() - handler.getCamera().getPos().y * TILESIZE / handler.getDefaultHeight() + Camera.camHeight / 2 / handler.getDefaultHeight()) * mapHeight - 0.5f);
            if (x >= 0 && x < mapWidth && y >= 0 && y < mapHeight) {
                entityManager.removeEntity(entityManager.getEntity((int) x, (mapHeight - 1 - (int) y)));
                if (getTile((int) x, mapHeight - 1 - (int) y).getTileType().equals(TileType.FLOR) && entitySelected == 0) {
                    entityManager.removeEntity(cp);
                    cp = new Player((int) x,
                            (mapHeight - 1 - (int) y), -0.1f, handler, entitySelected);
                    cp.setId(entitySelected);
                    entityManager.addEntity(cp);
                } else if (getTile((int) x, mapHeight - 1 - (int) y).getTileType().equals(TileType.FLOR)) {
                    Creature c = Creature.getCreature(entitySelected).setParams(((int) x),
                            (mapHeight - 1 - (int) y), handler);
                    c.setId(entitySelected);
                    entityManager.addEntity(c);
                }
            }
        }
        if (MouseListener.mouseButtonDown(0) && scroll == 2) {
            float x = ((MouseListener.getX() / handler.getWidth() + handler.getCamera().getPos().x * TILESIZE / handler.getDefaultWidth() - Camera.camWidth / 2 / handler.getDefaultWidth()) * mapWidth + 0.5f),
                    y = ((MouseListener.getY() / handler.getHeight() - handler.getCamera().getPos().y * TILESIZE / handler.getDefaultHeight() + Camera.camHeight / 2 / handler.getDefaultHeight()) * mapHeight - 0.5f);
            if (x >= 0 && x < mapWidth && y >= 0 && y < mapHeight) {
                if (getUsableTile((int) x, mapHeight - 1 - (int) y) != null)
                    removeUsableTile((int) x, mapHeight - 1 - (int) y);
                if (getTile((int) x, mapHeight - 1 - (int) y).getTileType().equals(TileType.FLOR)) {
                    addUsableTile(
                            UsableTile.getUsableTile(usableTileSelected).setParams(
                                    ((int) x),
                                    (mapHeight - 1 - (int) y),
                                    -0.7f, handler));
                }
            }
        }

        if (delayBetweenMods > 0) {
            delayBetweenMods--;
        }

        if (KeyListener.isKeyPressed(GLFW_KEY_ESCAPE) && delayBetweenMods == 0) {
            menuMode = true;
            delayBetweenMods = 5;
        }
    }

    private void move(int x, int y) {
        if (camPosEntity.transform.position.x + x >= 0 && camPosEntity.transform.position.x + x < mapWidth) {
            camPosEntity.transform.position.x += x;
        }

        if (camPosEntity.transform.position.y + y >= 0 && camPosEntity.transform.position.y + y < mapHeight) {
            camPosEntity.transform.position.y += y;
        }
    }

    private void menuTick() {
        inGameMenuBackground.transform.position = new Vector3f(camPosEntity.transform.position).add(-12, 0, -0.2f);
        backToMenuButton.transform.position = new Vector3f(camPosEntity.transform.position).add(-7f, -5.3f, -0.1f);
        saveButton.transform.position = new Vector3f(camPosEntity.transform.position).add(-7f, 0, -0.1f);
        writingBox.transform.position = new Vector3f(camPosEntity.transform.position).add(-7f, 5.3f, -0.1f);

        if (delayBetweenMods > 0) {
            delayBetweenMods--;
        }

        if (KeyListener.isKeyPressed(GLFW_KEY_ESCAPE) && delayBetweenMods == 0) {
            menuMode = false;
            delayBetweenMods = 5;
        }

        backToMenuButton.tick();
        saveButton.tick();
    }

    private void menuRender() {
        inGameMenuBackground.render();
        saveButton.render();
        writingBox.render();
        backToMenuButton.render();
    }

    public String getSaveFilePath() {
        return saveFilePath;
    }

    public boolean playerExists() {
        for (Entity e : entityManager.getEntities()) {
            if (e.getId() == 0)
                return true;
        }
        return false;
    }
}
