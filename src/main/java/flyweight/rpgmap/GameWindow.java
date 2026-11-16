package flyweight.rpgmap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameWindow extends Application {

    @Override
    public void start(Stage primaryStage) {
        int columns = 40;
        int rows = 30;
        int tileSize = 20;

        Canvas canvas = new Canvas(columns * tileSize, rows * tileSize);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Generate the logical map (Factory phase)
        GameMap map = new GameMap(columns, rows, tileSize);

        // Render the map graphically (Flyweight phase)
        map.render(gc);

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);

        primaryStage.setTitle("RPG Map Generator (Flyweight Pattern)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}