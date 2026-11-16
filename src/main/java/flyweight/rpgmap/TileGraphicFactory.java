package flyweight.rpgmap;

import javafx.scene.paint.Color;
import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {
    private static final Map<String, TileGraphic> graphics = new HashMap<>();

    public static TileGraphic getTileGraphic(String type) {
        if (!graphics.containsKey(type)) {
            // Simulate loading a heavy image into memory
            System.out.println("Loading heavy graphic asset for: " + type);

            Color color;
            switch (type.toLowerCase()) {
                case "water": color = Color.BLUE; break;
                case "forest": color = Color.DARKGREEN; break;
                case "mountain": color = Color.GRAY; break;
                case "grass": default: color = Color.LIGHTGREEN; break;
            }
            graphics.put(type, new TileGraphic(type, color));
        }
        return graphics.get(type);
    }
}