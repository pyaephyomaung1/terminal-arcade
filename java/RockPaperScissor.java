import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {

    private static final int TOTAL_ROUNDS = 5;
    private static final int ROCK = 1;
    private static final int PAPER = 2;
    private static final int SCISSOR = 3;

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int playerScore = 0;
        int enemyScore = 0;

        for (int round = 1; round <= TOTAL_ROUNDS; round++) {

            int enemyWeapon = random.nextInt(3) + 1;

            System.out.println("\nRound " + round);
            printMenu();

            int playerWeapon = scanner.nextInt();

            int result = determineWinner(playerWeapon, enemyWeapon);

            if (result == 1) {
                playerScore++;
                System.out.println("You WIN! Enemy chose " + weaponName(enemyWeapon));
            } else if (result == -1) {
                enemyScore++;
                System.out.println("You LOSE! Enemy chose " + weaponName(enemyWeapon));
            } else {
                System.out.println("DRAW! Both chose " + weaponName(enemyWeapon));
            }

            printScore(playerScore, enemyScore);
        }

        printFinalResult(playerScore, enemyScore);
        scanner.close();
    }

    private static int determineWinner(int player, int enemy) {
        if (player == enemy) return 0;

        if ((player == ROCK && enemy == SCISSOR) ||
            (player == PAPER && enemy == ROCK) ||
            (player == SCISSOR && enemy == PAPER)) {
            return 1;
        }
        return -1;
    }

    private static void printMenu() {
        System.out.println("Choose your weapon:");
        System.out.println("1 - Rock");
        System.out.println("2 - Paper");
        System.out.println("3 - Scissor");
        System.out.print("Your choice: ");
    }

    private static void printScore(int player, int enemy) {
        System.out.println("Your Score: " + player);
        System.out.println("Enemy Score: " + enemy);
    }

    private static void printFinalResult(int player, int enemy) {
        System.out.println("\n=== GAME OVER ===");
        if (player > enemy) {
            System.out.println("You are the WINNER!");
        } else if (player < enemy) {
            System.out.println("Welcome to Loser Club");
        } else {
            System.out.println("It's a DRAW");
        }
    }

    private static String weaponName(int weapon) {
        return switch (weapon) {
            case ROCK -> "Rock";
            case PAPER -> "Paper";
            case SCISSOR -> "Scissor";
            default -> "Unknown";
        };
    }
}