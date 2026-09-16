package state.character;

public class NoviceState implements LevelState {
    @Override
    public void train(GameCharacter character) {
        System.out.println("You swing a wooden sword at a dummy. (+20 EXP)");
        character.addExp(20);
        if (character.getExp() >= 50) {
            character.setState(new IntermediateState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("You don't know how to meditate yet.");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("You are too weak to fight real monsters!");
    }

    @Override
    public void displayAvailableActions() { System.out.println("Available Actions: [1] Train"); }
    @Override
    public String getLevelName() { return "Novice"; }
}