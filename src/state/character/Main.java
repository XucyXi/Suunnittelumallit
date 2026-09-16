package state.character;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameCharacter alphen = new GameCharacter("Alphen");

        System.out.println("Welcome to the Character Development Simulator!");

        boolean playing = true;
        while (playing) {
            alphen.displayStatus();

            // End the loop if we hit Master state
            if (alphen.getExp() >= 250) {
                System.out.println("\nCongratulations! You have reached Master level and completed the game.");
                break;
            }

            System.out.print("Choose an action: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    alphen.train();
                    break;
                case "2":
                    alphen.meditate();
                    break;
                case "3":
                    alphen.fight();
                    break;
                case "exit":
                case "q":
                    playing = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try 1, 2, or 3.");
            }
        }
        scanner.close();
    }
}