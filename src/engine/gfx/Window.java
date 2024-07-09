package engine.gfx;

import engine.gfx.textures.ImageParser;
import engine.gfx.textures.Texture;
import engine.io.KeyListener;
import engine.io.MouseListener;
import org.joml.Vector2f;
import org.lwjgl.glfw.GLFWImage;

import static java.sql.Types.NULL;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glViewport;
import static org.lwjgl.stb.STBImage.stbi_load;

public class Window {
    private long window;
    private int width, height;
    private String title;

    private final ImageParser resource_01 = ImageParser.loadImage("./res/textures/Game Icon.png");

    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, 1);
        glfwWindowHint(GLFW_RESIZABLE, 1);
        glfwWindowHint(GLFW_DECORATED, 1);
        window = glfwCreateWindow(width, height, title, NULL, NULL);

        GLFWImage image = GLFWImage.malloc(); GLFWImage.Buffer imagebf = GLFWImage.malloc(1);
        image.set(resource_01.getWidth(), resource_01.getHeight(), resource_01.getImage());
        imagebf.put(0, image);

        glfwSetWindowIcon(window, imagebf);

        glfwSetCursorPosCallback(window, MouseListener::mousePosCallback);
        glfwSetMouseButtonCallback(window, MouseListener::mouseButtonCallback);
        glfwSetScrollCallback(window, MouseListener::mouseScrollCallback);
        glfwSetKeyCallback(window, KeyListener::keyCallBack);

        if(window == NULL) {
            System.err.println("ERROR: Window not created!");
            glfwTerminate();
            assert false : "ERROR";
        }

        glfwSetFramebufferSizeCallback(window, this::framebufferSizeCallback);
    }

    public boolean shouldClose() {
        return glfwWindowShouldClose(window);
    }

    public void makeContextCurrent() {
        glfwMakeContextCurrent(window);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public long getWindow() {
        return window;
    }

    private void framebufferSizeCallback(long window, int width, int height) {
        glViewport(0,0,width,height);
        this.width = width;
        this.height = height;
    }
}
