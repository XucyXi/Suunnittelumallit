package memento.guistate;

import java.util.Arrays;

public class Model {
    private int[] boxColors = new int[3]; // 0: Red, 1: Blue, 2: Yellow
    private boolean isChecked = false;

    public IMemento createMemento() {
        return new Memento(boxColors, isChecked);
    }

    public void restoreState(IMemento memento) {
        Memento m = (Memento) memento;
        this.boxColors = Arrays.copyOf(m.getBoxColors(), m.getBoxColors().length);
        this.isChecked = m.isChecked();
    }

    public void setBoxColor(int index, int color) { boxColors[index] = color; }
    public int getBoxColor(int index) { return boxColors[index]; }

    public void setChecked(boolean checked) { isChecked = checked; }
    public boolean isChecked() { return isChecked; }
}