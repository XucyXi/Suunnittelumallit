package flyweight.rpgmap;

import javafx.scene.canvas.GraphicsContext;

public class Tile {
    private final int gridX;
    private final int gridY;
    private final TileGraphic graphic; // The shared Flyweight

    public Tile(int gridX, int gridY, String type) {
        this.gridX = gridX;
        this.gridY = gridY;
        // Fetch the shared graphic from the factory instead of creating a new one
        this.graphic = TileGraphicFactory.getTileGraphic(type);
    }

    public void render(GraphicsContext gc, int tileSize) {
        int pixelX = gridX * tileSize;
        int pixelY = gridY * tileSize;
        // Pass the extrinsic state (pixels) to the intrinsic graphic
        graphic.draw(gc, pixelX, pixelY, tileSize, tileSize);
    }
}