package nyc.c4q;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            playHangman();
}

public static void playHangman(){
    Hangman hangman = new Hangman();
    while (hangman.getMisses() < 5){
        hangman.printCurrentWord();
        hangman.promptPlayer("Enter a letter: ");
        hangman.readLetter();
        hangman.checkLetter();
        if(hangman.guessedSuccessfully()){
            break;
        }
        System.out.println(Drawing.get(hangman.getMisses()));
        System.out.println("Misses -> " +hangman.getMisses());
    }
    if(hangman.guessedSuccessfully()){
        System.out.println("Success");
    } else {
        System.out.println("The answer was " + hangman.getSecretWord());
    }
    checkToPlayAgain();
}
public static void checkToPlayAgain(){
    System.out.println("Would you like to play again? ");
    Scanner scanner = new Scanner(System.in);
    String userAnswer = scanner.next();
    checkAnswer(userAnswer);
}
public static void checkAnswer(String playAgain){
    if ((playAgain.equalsIgnoreCase("yes")) || (playAgain.equalsIgnoreCase("y"))){
        playHangman();
    }
    else if ((playAgain.equalsIgnoreCase("no")) || playAgain.equalsIgnoreCase("n")){
        System.out.println("Thanks for playing!");
        return;
    }
    else{
        System.out.println("Invalid Input, Try again");
        checkToPlayAgain();
    }
}

}
