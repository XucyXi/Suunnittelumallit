package flyweight.rpgmap;

import javafx.scene.canvas.GraphicsContext;
import java.util.Random;

public class GameMap {
    private final int width;
    private final int height;
    private final Tile[][] tiles;
    private final int tileSize;

    public GameMap(int width, int height, int tileSize) {
        this.width = width;
        this.height = height;
        this.tileSize = tileSize;
        this.tiles = new Tile[width][height];
        generateMap();
    }

    private void generateMap() {
        Random random = new Random();
        String[] types = {"grass", "water", "forest", "mountain"};

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                String randomType = types[random.nextInt(types.length)];
                tiles[x][y] = new Tile(x, y, randomType);
            }
        }
    }

    public void render(GraphicsContext gc) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y].render(gc, tileSize);
            }
        }
    }
}