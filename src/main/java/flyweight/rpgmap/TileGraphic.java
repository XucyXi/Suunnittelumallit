package flyweight.rpgmap;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TileGraphic {
    private final String type;
    private final Color color; // Represents the "Image" we are trying to save memory on

    public TileGraphic(String type, Color color) {
        this.type = type;
        this.color = color;
    }

    // The Flyweight takes the Extrinsic state (X, Y) as arguments to draw itself
    public void draw(GraphicsContext gc, int x, int y, int width, int height) {
        gc.setFill(color);
        gc.fillRect(x, y, width, height);

        // Add a subtle border to make the grid visible
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(0.5);
        gc.strokeRect(x, y, width, height);
    }
}