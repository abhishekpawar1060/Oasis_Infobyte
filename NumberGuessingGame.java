import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int totalScore = 0;
        int maxAttempts = 5;
        int rounds = 3;

        for (int round = 1; round <= rounds; round++) {
            int tryCount = 0;
            int score = 0;

            int randNumber = rand.nextInt(100) + 1;

            while (tryCount < maxAttempts) {
                System.out.print("Round " + round + " - Attempt " + (tryCount + 1) + ": Enter your Guess (1 - 100): ");
                int playerGuess = sc.nextInt();
                tryCount++;

                if (playerGuess == randNumber) {
                    score = (maxAttempts - tryCount + 1) * 10; // Calculate score based on remaining attempts
                    totalScore += score;
                    System.out.println("Correct! You Win this round! Your Score for this round: " + score);
                    System.out.println("It took you " + tryCount + " tries in this round.");
                    break;
                } else if (randNumber > playerGuess) {
                    System.out.println("Nope! The number is higher. Guess Again.");
                } else {
                    System.out.println("Nope! The number is lower. Guess Again.");
                }
            }

            System.out.println("Round " + round + " is over. Your Total Score: " + totalScore);
        }

        System.out.println("Game Over! Total Score: " + totalScore);
    }
}
