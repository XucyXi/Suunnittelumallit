package templatemethod.game;

public class Main {
    public static void main(String[] args) {
        Game myGame = new DiceRace();

        myGame.play(3);
    }
}