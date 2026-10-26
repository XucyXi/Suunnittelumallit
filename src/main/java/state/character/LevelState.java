package state.character;

public interface LevelState {
    void train(GameCharacter character);
    void meditate(GameCharacter character);
    void fight(GameCharacter character);
    void displayAvailableActions();
    String getLevelName();
}