package state.character;

public class MasterState implements LevelState {
    @Override
    public void train(GameCharacter character) { System.out.println("You have mastered all training."); }
    @Override
    public void meditate(GameCharacter character) { System.out.println("Your mind is perfectly clear."); }
    @Override
    public void fight(GameCharacter character) { System.out.println("No enemies can challenge you anymore."); }

    @Override
    public void displayAvailableActions() { System.out.println("Available Actions: None. You have beaten the game!"); }
    @Override
    public String getLevelName() { return "Master"; }
}