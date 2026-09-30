package templatemethod.game;

import java.util.Random;
import java.util.Scanner;

public class DiceRace extends Game {
    private int[] scores;
    private int targetScore;
    private int winningPlayer;
    private Random random;
    private Scanner scanner;

    @Override
    public void initializeGame(int numberOfPlayers) {
        scores = new int[numberOfPlayers];
        targetScore = 20;
        winningPlayer = -1;
        random = new Random();
        scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("    WELCOME TO THE DICE RACE!    ");
        System.out.println("=================================");
        System.out.println("First player to reach " + targetScore + " points wins.");
        System.out.println("Starting game with " + numberOfPlayers + " players...\n");
    }

    @Override
    public void playSingleTurn(int player) {
        System.out.print("Player " + (player + 1) + "'s turn. Press ENTER to roll...");
        scanner.nextLine();

        int roll = random.nextInt(6) + 1;
        scores[player] += roll;

        System.out.println(" -> Player " + (player + 1) + " rolled a " + roll + "!");
        System.out.println("    Total score: " + scores[player] + "\n");

        if (scores[player] >= targetScore) {
            winningPlayer = player;
        }
    }

    @Override
    public boolean endOfGame() {
        return winningPlayer != -1;
    }

    @Override
    public void displayWinner() {
        System.out.println("=================================");
        System.out.println("     PLAYER " + (winningPlayer + 1) + " WINS THE GAME!   ");
        System.out.println("=================================");
        scanner.close();
    }
}