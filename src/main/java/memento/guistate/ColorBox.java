package memento.guistate;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorBox extends Rectangle {
    public ColorBox() {
        super(100, 100); // 100x100 square
        setStroke(Color.BLACK);
        setStrokeWidth(2);
    }

    public void setColor(int colorCode) {
        if (colorCode == 0) setFill(Color.RED);
        else if (colorCode == 1) setFill(Color.BLUE);
        else if (colorCode == 2) setFill(Color.YELLOW);
    }
}