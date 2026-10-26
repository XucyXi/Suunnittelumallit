package state.character;

public class GameCharacter {
    private final String name;
    private int exp;
    private int hp;
    private LevelState currentState;

    public GameCharacter(String name) {
        this.name = name;
        this.exp = 0;
        this.hp = 100;
        this.currentState = new NoviceState(); // Starts as Novice
    }

    public void setState(LevelState state) {
        this.currentState = state;
        System.out.println("\n*** LEVEL UP! " + name + " is now a " + state.getLevelName() + " ***");
    }

    // --- State Delegation ---
    public void train() { currentState.train(this); }
    public void meditate() { currentState.meditate(this); }
    public void fight() { currentState.fight(this); }

    // --- Stat Modifiers ---
    public void addExp(int amount) { this.exp += amount; }
    public void addHp(int amount) { this.hp += amount; }
    public void reduceHp(int amount) { this.hp -= amount; }

    public int getExp() { return exp; }
    public int getHp() { return hp; }

    public void displayStatus() {
        System.out.println("\n==================================");
        System.out.println("Name:  " + name);
        System.out.println("Level: " + currentState.getLevelName());
        System.out.println("HP:    " + hp + " | EXP: " + exp);
        System.out.println("==================================");
        currentState.displayAvailableActions();
    }
}