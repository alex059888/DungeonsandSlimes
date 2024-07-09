package engine.gfx.textures;

import org.joml.Vector2f;
import org.lwjgl.BufferUtils;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.stb.STBImage.stbi_image_free;
import static org.lwjgl.stb.STBImage.stbi_load;

public class Texture {
    private int texID;

    private Vector2f texSize;

    private final int id;

    public static List<Texture> textures = List.of(
            new DefaultTileMap(0),
            new MenuScreenTexture(1),
            new ButtonsTileMap(2),
            new GameIcon(3),
            new LevelButtonsTileMap(4),
            new UITitleTexture(5),
            new InGameMenuScreen(6),
            new SelectBox(7),
            new WritingBox(8),
            new IGBH(9),
            new SBB(10)
    );

    public Texture(String filepath, Vector2f size, int id) {
        this.id = id;
        texSize = size;

        // Generate texture on GPU
        texID = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, texID);

        // Set texture parameters
        // Repeat image in both directions
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
        // When stretching the image, pixelate
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        // When shrinking an image, pixelate
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

        IntBuffer width = BufferUtils.createIntBuffer(1);
        IntBuffer height = BufferUtils.createIntBuffer(1);
        IntBuffer channels = BufferUtils.createIntBuffer(1);
        ByteBuffer image = stbi_load(filepath, width, height, channels, 0);

        if (image != null) {
            if (channels.get(0) == 3) {
                glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, width.get(0), height.get(0),
                        0, GL_RGB, GL_UNSIGNED_BYTE, image);
            } else if (channels.get(0) == 4) {
                glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width.get(0), height.get(0),
                        0, GL_RGBA, GL_UNSIGNED_BYTE, image);
            } else {
                assert false : "Error: (Texture) Unknown number of channesl '" + channels.get(0) + "'";
            }
        } else {
            assert false : "Error: (Texture) Could not load image '" + filepath + "'";
        }

        stbi_image_free(image);
    }

    public void bind() {
        glBindTexture(GL_TEXTURE_2D, texID);
    }

    public void unbind() {
        glBindTexture(GL_TEXTURE_2D, 0);
    }

    public int getId() {
        return id;
    }

    public static Texture getTexture(int id) {
        return textures.get(id);
    }

    public int getTexID() {
        return texID;
    }

    public static void addTexture(String path, Vector2f texSize, int id) {
        textures.add(new Texture(path, texSize, id));
    }

    public Vector2f getTexSize() {
        return texSize;
    }

    public static float getTexCord(float texCord, float texSize, float subTexSize) {
        return 1.0f/texSize*subTexSize*texCord;
    }
}
