import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
    private static final int MAX_ATTEMPT = 5;
    private static final int MAX_NUMBER = 100;

    private static final String[] DARES = {
            "Change your social media bio to: 'I lost to a random number generator today.'",
            "Send a text to the 3rd person in your contacts saying: 'The numbers... they're everywhere.'",
            "Do 15 pushups while counting out loud in binary.",
            "Post a photo of a calculator captioned: 'My True Master.'",
            "Do a robot dance for 30 seconds.",
            "Explain the complexity of number 7 to a friend.",
            "Let someone draw an 'L' on your forehead.",
            "Call your Ex",
            "Speak Shakespearean English for 10 minutes.",
            "Balance a spoon on your nose for 60 seconds.",
            "Plank for as many seconds as the missed number.",
            "Write a poem praising CPU intelligence.",
            "Sing 'Counting Stars' to a friend.",
            "Drink water using only a teaspoon.",
            "Change your wallpaper to 'Wrong Guess'.",
            "Spin 10 times and walk straight."
    };

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(MAX_NUMBER);
        int health = 0;
        boolean gameOver = false;

        while (!gameOver) {
            System.out.print("Enter your number: ");
            int guess = scanner.nextInt();
            health++;

            if (guess > secretNumber) {
                System.out.println("Too high. Try again.");
            } else if (guess < secretNumber) {
                System.out.println("Too low. Try again.");
            } else {
                System.out.println("Correct! You won 🎉");
                gameOver = true;
            }

            if (!gameOver && health == MAX_ATTEMPT) {
                printDare();
                gameOver = true;
            }
        }
        scanner.close();
    }

    public static void printDare() {
        int index = (int) (Math.random() * DARES.length);
        System.out.println(DARES[index]);
    }

}
