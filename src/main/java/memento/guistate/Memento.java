package memento.guistate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Memento implements IMemento {
    private final int[] boxColors;
    private final boolean isChecked;
    private final String timestamp;

    public Memento(int[] boxColors, boolean isChecked) {
        // We have to clone the array so the memento holds a true separate copy of the state
        this.boxColors = Arrays.copyOf(boxColors, boxColors.length);
        this.isChecked = isChecked;

        // Saving the exact time this state was created
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.timestamp = LocalDateTime.now().format(formatter);
    }

    public int[] getBoxColors() { return boxColors; }
    public boolean isChecked() { return isChecked; }

    @Override
    public String getTimestamp() { return timestamp; }
}