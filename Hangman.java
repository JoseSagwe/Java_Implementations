//Hangman is a word-guessing game where the player tries to guess a hidden word by suggesting letters one at a time.

import java.util.Scanner;

interface Game {
    void initialize();
    void play();
    void end();
}

abstract class AbstractGame implements Game {
    protected int maxAttempts;
    protected String[] words;
    protected String wordToGuess;
    protected char[] guessedLetters;
    protected int attempts;
    protected Scanner scanner;

    public AbstractGame() {
        scanner = new Scanner(System.in);
    }

    protected abstract void selectRandomWord();

    @Override
    public void initialize() {
        attempts = 0;
        selectRandomWord();
        guessedLetters = new char[wordToGuess.length()];
        for (int i = 0; i < wordToGuess.length(); i++) {
            guessedLetters[i] = '_';
        }
    }

    @Override
    public void end() {
        scanner.close();
    }
}

class HangmanGame extends AbstractGame {
    @Override
    protected void selectRandomWord() {
        words = new String[]{"hangman", "computer", "java", "programming", "openai"};
        int randomIndex = (int) (Math.random() * words.length);
        wordToGuess = words[randomIndex];
    }

    @Override
    public void play() {
        while (true) {
            System.out.println("Word: " + new String(guessedLetters));
            System.out.print("Enter a letter: ");
            char letter = scanner.nextLine().charAt(0);
            attempts++;

            boolean found = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == letter) {
                    guessedLetters[i] = letter;
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Incorrect letter!");
            }

            if (new String(guessedLetters).equals(wordToGuess)) {
                System.out.println("Congratulations! You guessed the word '" + wordToGuess + "' in " + attempts + " attempts.");
                break;
            }
        }
    }
}

public class Hangman {
    public static void main(String[] args) {
        Game game = new HangmanGame();
        game.initialize();
        game.play();
        game.end();
    }
}


//In this game, the Game interface and AbstractGame class are similar to the previous example. However, the selectRandomWord() method is 
//implemented differently in the HangmanGame class to select a random word from a predefined array.

//The game starts by creating an instance of the HangmanGame class in the main method. It then calls the initialize() method to set up 
//the game, followed by the play() method to start playing. The player can enter a letter and attempt to guess the hidden word. The game continues until the player correctly guesses the word or runs out of attempts.

//The Hangman game demonstrates the use of arrays, loops, conditionals, and string manipulation in Java. It provides an opportunity 
//for beginners to practice these concepts while enjoying a classic word-guessing game. Feel free to modify and enhance this code to suit 
//syour needs and explore further Java concepts!