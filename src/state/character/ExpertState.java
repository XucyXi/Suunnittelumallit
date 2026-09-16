package state.character;

public class ExpertState implements LevelState {
    @Override
    public void train(GameCharacter character) {
        System.out.println("You spar with the guards. (+40 EXP)");
        character.addExp(40);
        checkLevelUp(character);
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("You focus your inner energy. (+30 HP)");
        character.addHp(30);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("You defeat a wild beast! (-20 HP, +60 EXP)");
        character.reduceHp(20);
        character.addExp(60);
        checkLevelUp(character);
    }

    private void checkLevelUp(GameCharacter character) {
        if (character.getExp() >= 250) character.setState(new MasterState());
    }

    @Override
    public void displayAvailableActions() { System.out.println("Available Actions: [1] Train, [2] Meditate, [3] Fight"); }
    @Override
    public String getLevelName() { return "Expert"; }
}