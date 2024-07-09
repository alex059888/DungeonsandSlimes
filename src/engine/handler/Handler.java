package engine.handler;

import engine.gfx.Camera;
import engine.gfx.Window;
import engine.gfx.shaders.Shader;
import engine.scenes.Scene;
import engine.scenes.worlds.World;
import main.Game;

import static java.lang.Math.max;
import static java.lang.Math.sqrt;

public class Handler {
    public static final float PI = 3.1415926535f, DR = 0.0174533f;
    public boolean showDir = true;

    public Shader defaultShader;

    public float renderDistance; //in chunks

    private int fps = 60;

    private float timeSinceLastTick = 0;

    private Camera camera;

    private final int defaultWidth, defaultHeight;

    private Game game;
    private World world;
    private Scene scene;

    public Handler(Game game) {
        this.game = game;
        defaultWidth = game.getWidth();
        defaultHeight = game.getHeight();
        renderDistance = 2;
    }

    public Game getGame() {
        return game;
    }

    public Window getWindow() {
        return game.getWindow();
    }

    public int getWidth() {
        return game.getWindow().getWidth();
    }

    public int getHeight() {
        return game.getWindow().getHeight();
    }

    public float dist(float ax, float ay, float bx, float by) {
        return (float) sqrt((bx-ax)*(bx-ax) + (by-ay)*(by-ay));
    }

    public World getWorld() {
        if (world != null)
            return world;
        return game.getScene().getWorld();
    }

    public Scene getScene() {
        if (scene != null)
            return scene;
        return game.getScene();
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public void changeSceneScene(Scene scene) {
        this.scene = scene;
    }

    public int getFps() {
        return fps;
    }

    public void setFps(int fps) {
        this.fps = fps;
    }

    public float getTimeSinceLastTick() {
        return timeSinceLastTick / 100000000;
    }

    public float getTimeSinceLastTickPerFps() {
        return timeSinceLastTick / 100000000 / fps;
    }

    public void setTimeSinceLastTick(float timeSinceLastTick) {
        this.timeSinceLastTick = timeSinceLastTick;
    }

    public Shader getDefaultShader() {
        return defaultShader;
    }

    public void setDefaultShader(Shader defaultShader) {
        this.defaultShader = defaultShader;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public int getDefaultWidth() {
        return defaultWidth;
    }

    public int getDefaultHeight() {
        return defaultHeight;
    }
}
