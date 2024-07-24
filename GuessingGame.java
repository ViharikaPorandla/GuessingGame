import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        String playAgain;

        System.out.println("Welcome to the Guessing Game!");

        do {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            System.out.println("\nI have generated a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                try {
                    int guess = Integer.parseInt(scanner.nextLine());
                    attempts++;

                    if (guess < numberToGuess) {
                        System.out.println("Too low!");
                    } else if (guess > numberToGuess) {
                        System.out.println("Too high!");
                    } else {
                        System.out.println("Congratulations! You guessed the correct number.");
                        guessedCorrectly = true;
                        score++;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.nextLine().toLowerCase();
        } while (playAgain.equals("y"));

        System.out.println("Your final score is: " + score);
        System.out.println("Thank you for playing the Guessing Game!");
        scanner.close();
    }
}
