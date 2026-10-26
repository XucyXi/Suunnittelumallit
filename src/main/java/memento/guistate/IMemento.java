package memento.guistate;

public interface IMemento {
    // Exposing metadata to the Caretaker (Controller) for the ListView
    String getTimestamp();
}