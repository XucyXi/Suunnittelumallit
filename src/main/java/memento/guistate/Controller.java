package memento.guistate;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Controller {
    private Model model;
    private Gui gui;

    // The two history lists
    private Stack<IMemento> undoStack = new Stack<>();
    private Stack<IMemento> redoStack = new Stack<>();

    public Controller(Gui gui) {
        this.gui = gui;
        this.model = new Model();
        saveState(); // Save the initial default state
    }

    public void saveState() {
        undoStack.push(model.createMemento());
        redoStack.clear(); // Clear redo list when a new change is made
        updateHistoryView();
    }

    public void undo() {
        if (undoStack.size() > 1) { // Keeps at least the initial state
            redoStack.push(undoStack.pop()); // Moves current state to redo stack
            model.restoreState(undoStack.peek()); // Restores the previous state
            gui.updateGui();
            updateHistoryView();
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            IMemento m = redoStack.pop();
            undoStack.push(m); // Moves back to undo stack
            model.restoreState(m);
            gui.updateGui();
            updateHistoryView();
        }
    }

    public void restoreFromHistory(int targetIndex) {
        if (targetIndex >= 0 && targetIndex < undoStack.size()) {
            // Pops everything above the selected index and push it to the redo stack
            while (undoStack.size() - 1 > targetIndex) {
                redoStack.push(undoStack.pop());
            }
            model.restoreState(undoStack.peek());
            gui.updateGui();
            updateHistoryView();
        }
    }

    // --- Inputs from GUI ---
    public void changeColor(int boxIndex) {
        int currentColor = model.getBoxColor(boxIndex);
        model.setBoxColor(boxIndex, (currentColor + 1) % 3);
        saveState();
        gui.updateGui();
    }

    public void toggleCheckbox(boolean isChecked) {
        model.setChecked(isChecked);
        saveState();
        gui.updateGui();
    }

    private void updateHistoryView() {
        List<String> historyStrings = new ArrayList<>();
        int step = 1;
        for (IMemento m : undoStack) {
            historyStrings.add("Step " + step++ + " - Saved at " + m.getTimestamp());
        }
        gui.updateHistoryList(historyStrings);
    }

    public Model getModel() { return model; }
}