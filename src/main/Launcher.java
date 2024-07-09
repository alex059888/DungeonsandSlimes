package main;

public class Launcher {

    public static void main(String[] args) {
        Game game = new Game(768, 512, "Dungeons and Slimes");
        game.run();
    }
}
