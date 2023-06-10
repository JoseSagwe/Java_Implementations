import java.util.Random;
import java.util.Scanner;

// Interface for game rules
interface Game {
    void initialize();
    void play();
    void end();
}

// Abstract class for game implementation
abstract class AbstractGame implements Game {
    protected int targetNumber;
    protected int attempts;
    protected Scanner scanner;

    public AbstractGame() {
        scanner = new Scanner(System.in);
    }

    protected abstract void generateNumber();

    @Override
    public void initialize() {
        attempts = 0;
        generateNumber();
    }

    @Override
    public void end() {
        scanner.close();
    }
}

// Game implementation
class GuessingGame extends AbstractGame {
    private int guess;

    @Override
    protected void generateNumber() {
        Random random = new Random();
        targetNumber = random.nextInt(100) + 1;
    }

    @Override
    public void play() {
        while (true) {
            System.out.print("Enter your guess (1-100): ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < targetNumber) {
                System.out.println("Higher!");
            } else if (guess > targetNumber) {
                System.out.println("Lower!");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                break;
            }
        }
    }
}

// Main class
public class GuesingGame {
    public static void main(String[] args) {
        Game game = new GuessingGame();
        game.initialize();
        game.play();
        game.end();
    }
}




// In this game, the Game interface defines the basic methods that every game should have: initialize(), play(), and end(). The AbstractGame 
//class provides a common implementation for these methods and adds additional functionality. The GuessingGame class extends AbstractGame to 
//implement the actual guessing game logic.

//The game starts by creating an instance of the GuessingGame class in the main method. It then calls the initialize() method to set up the game, followed by the play() method to start playing. The game continues until the player guesses the correct number, and then it calls the end() method to clean up and close the Scanner object.

//This example demonstrates various Java concepts like classes, methods, constructors, static keywords, StringBuffers (not used in this
//particular game), interfaces, abstract methods, and classes. It provides a good starting point for beginners to understand these concepts 
//in a practical context. Feel free to modify and expand upon this code as you continue to learn Java!