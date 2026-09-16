package state.character;

public class IntermediateState implements LevelState {
    @Override
    public void train(GameCharacter character) {
        System.out.println("You practice combat drills. (+30 EXP)");
        character.addExp(30);
        checkLevelUp(character);
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("You clear your mind and rest. (+20 HP)");
        character.addHp(20);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("You are not quite ready for actual combat.");
    }

    private void checkLevelUp(GameCharacter character) {
        if (character.getExp() >= 110) character.setState(new ExpertState());
    }

    @Override
    public void displayAvailableActions() { System.out.println("Available Actions: [1] Train, [2] Meditate"); }
    @Override
    public String getLevelName() { return "Intermediate"; }
}