import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 5;
        int score = 0;
        boolean playAgain = true;
        
        System.out.println("You have been challenged for a Number Game,Welcome!");
        
        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("\nMy brain has a number between " + minRange + " and " + maxRange + ". Guess it!");
            
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            while (attempts < attemptsLimit && !guessedCorrectly) {
                System.out.print("Lets see this is ur attempt " + (attempts + 1) + ": so,What have u decided or guessed: ");
                int guess = scanner.nextInt();
                
                if (guess == targetNumber) {
                    System.out.println("Fantastic! You guessed it right!,My friend u Won this game");
                    guessedCorrectly = true;
                    score++;
                } else if (guess < targetNumber) {
                    System.out.println("Dont you think it's Too low! Try again.");
                } else {
                    System.out.println("Dont you think it's Too high! Try again.");
                }
                
                attempts++;
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The number was: " + targetNumber);
            }
            
            System.out.println("Your current score: " + score);
            System.out.print("Won't you wanna play again? (yes/no): ");
            String playChoice = scanner.next().toLowerCase();
            playAgain = playChoice.equals("yes") || playChoice.equals("y");
        }
        
        System.out.println("Thank you for your time playing this game!");
        scanner.close();
    }
}
