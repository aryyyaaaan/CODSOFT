import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalRounds = 0;
        int roundsWon = 0;
        int totalAttempts = 0;
        boolean playAgain = true;

        System.out.println("🎮 Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number between 1 and 100.");

        while (playAgain) {
            int secretNumber = random.nextInt(100) + 1; // 1 to 100
            int maxAttempts = 7;
            int attemptsUsed = 0;
            boolean guessedCorrectly = false;

            totalRounds++;
            System.out.println("\n🔁 Round " + totalRounds);
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attemptsUsed < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess;

                try {
                    guess = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("❌ Invalid input! Please enter a number.");
                    scanner.next(); // Clear the invalid input
                    continue;
                }

                attemptsUsed++;

                if (guess == secretNumber) {
                    System.out.println("🎉 Correct! You guessed it in " + attemptsUsed + " attempts.");
                    guessedCorrectly = true;
                    roundsWon++;
                    totalAttempts += attemptsUsed;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("📉 Too low! Attempts left: " + (maxAttempts - attemptsUsed));
                } else {
                    System.out.println("📈 Too high! Attempts left: " + (maxAttempts - attemptsUsed));
                }
            }

            if (!guessedCorrectly) {
                System.out.println("😢 You've used all attempts. The number was: " + secretNumber);
            }

            // Ask if user wants to play again
            System.out.print("Would you like to play another round? (yes/no): ");
            scanner.nextLine(); // Consume leftover newline
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }

        // Game summary
        System.out.println("\n🧾 Game Over!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Rounds Won: " + roundsWon);
        if (roundsWon > 0) {
            double avgAttempts = (double) totalAttempts / roundsWon;
            System.out.printf("Average Attempts per Win: %.2f\n", avgAttempts);
        } else {
            System.out.println("No wins this time. Better luck next round!");
        }

        scanner.close();
    }
}
