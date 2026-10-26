package memento.guistate;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;

public class Gui extends Application {
    private Controller controller;
    private ColorBox[] colorBoxes = new ColorBox[3];
    private CheckBox checkBox;
    private ListView<String> historyListView;

    @Override
    public void start(Stage primaryStage) {
        historyListView = new ListView<>();
        controller = new Controller(this);

        // --- Main Window Setup ---
        HBox boxesLayout = new HBox(15);
        for (int i = 0; i < 3; i++) {
            final int index = i;
            colorBoxes[i] = new ColorBox();
            colorBoxes[i].setOnMouseClicked(e -> controller.changeColor(index));
            boxesLayout.getChildren().add(colorBoxes[i]);
        }

        checkBox = new CheckBox("Enable Feature");
        checkBox.setOnAction(e -> controller.toggleCheckbox(checkBox.isSelected()));

        VBox mainLayout = new VBox(20, boxesLayout, checkBox);
        mainLayout.setPadding(new Insets(20));
        Scene mainScene = new Scene(mainLayout, 380, 200);

        // Setup Keyboard Shortcuts
        mainScene.setOnKeyPressed(this::handleKeyInput);

        primaryStage.setTitle("Memento Pattern - Main UI");
        primaryStage.setScene(mainScene);
        primaryStage.show();

        // --- History Window Setup ---
        Stage historyStage = new Stage();
        historyStage.setTitle("History Window");

        historyListView.setOnMouseClicked(e -> {
            int selected = historyListView.getSelectionModel().getSelectedIndex();
            if (selected != -1) controller.restoreFromHistory(selected);
        });

        Scene historyScene = new Scene(historyListView, 250, 300);
        historyScene.setOnKeyPressed(this::handleKeyInput); // Allow shortcuts here too
        historyStage.setScene(historyScene);

        // Position history window next to main window
        historyStage.setX(primaryStage.getX() + 400);
        historyStage.setY(primaryStage.getY());
        historyStage.show();

        updateGui(); // Initial paint
    }

    private void handleKeyInput(KeyEvent event) {
        if (event.isControlDown() && event.getCode() == KeyCode.Z) {
            controller.undo();
        } else if (event.isControlDown() && event.getCode() == KeyCode.Y) {
            controller.redo();
        }
    }

    // Called by the Controller to force the View to redraw itself
    public void updateGui() {
        Model model = controller.getModel();
        for (int i = 0; i < 3; i++) {
            colorBoxes[i].setColor(model.getBoxColor(i));
        }
        checkBox.setSelected(model.isChecked());
    }

    // Called by the Controller to update the History ListView
    public void updateHistoryList(List<String> history) {
        historyListView.getItems().clear();
        historyListView.getItems().addAll(history);
        historyListView.getSelectionModel().select(history.size() - 1); // Highlight latest
    }
}