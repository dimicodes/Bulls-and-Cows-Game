package bullscows;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        char[] theCode;

        Scanner scanner = new Scanner(System.in);
        int userInput = 0;
        int userInputSymbols = 0;
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("Please, enter the secret code's length:");
            String userInputString = scanner.nextLine();
            if (!isNumeric(userInputString)) {
                System.out.println("Error: \""+ userInputString + "\" isn't a valid number.");
                break;
            } else {
                userInput = Integer.parseInt(userInputString);
            }

            System.out.println("Input the number of possible symbols in the code:");
            String userInputSymbolsString = scanner.nextLine();
            if (!isNumeric(userInputSymbolsString)) {
                System.out.println("Error: " + userInputSymbolsString + " isn't a valid number.");
                break;
            } else {
                userInputSymbols = Integer.parseInt(userInputSymbolsString);
            }

            if (userInput <= 0 || userInput > 10) {
                System.out.println("Error: Invalid input length. Please enter a number between 1 and 10.");
                break;
            } else if (userInputSymbols > 36) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                break;
            } else if (userInputSymbols < userInput) {
                System.out.println("Error: it's not possible to generate a code with a length of " + userInput + " with " + userInputSymbols + " unique symbols.");
                break;
            } else {
                theCode = generateCode(userInput,userInputSymbols);
                System.out.println("Okay, let's start a game!");
                startGame(theCode);
                keepRunning = false;
            }
        }

    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    static void startGame(char[] theCode) {
        Scanner scanner = new Scanner(System.in);
        boolean gameNotOver = true;
        int i = 1;
        while (gameNotOver) {
            System.out.println("Turn " + i + ":");
            char [] userGuess = scanner.nextLine().toCharArray();
            while (userGuess.length != theCode.length) {
                System.out.println("Please guess a number of length " + theCode.length);
                userGuess = scanner.nextLine().toCharArray();
            }
            if (Arrays.equals(userGuess, theCode)) {
                System.out.println(grade(userGuess, theCode));
                System.out.println("Congratulations! You guessed the secret code.");
                gameNotOver = false;
            } else {
                System.out.println(grade(userGuess, theCode));
                i++;
            }
        }
    }
    static String grade(char[] numGuessed, char[] secretCode) {
        int bull = 0;
        int cow = 0;

        for (int i = 0; i < secretCode.length; i++) {
            if (numGuessed[i] == secretCode[i]) {
                bull++;
            } else {
                for (int j = 0; j < secretCode.length; j++) {
                    if (numGuessed[i] == secretCode[j] && i != j) {
                        cow++;
                        break; // Avoid counting the same number multiple times
                    }
                }
            }
        }

        String secretString = new String(secretCode);
        if (bull > 0 || cow > 0) {
            return "Grade: " + bull + " bull(s) and " + cow + " cow(s).";
        } else {
            return "Grade: None.";
        }
    }

    static char[] generateCode(int length, int userRange) {
        char[] characters = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] secretCode = new char[length];
        boolean[] usedCharacters = new boolean[userRange]; // To track used characters
        StringBuilder secretPrepared = new StringBuilder();

        for (int i = 0; i < length; ) {
            secretPrepared.append("*");
            int randomIndex = (int) (Math.random() * (userRange));
            if (!usedCharacters[randomIndex]) {
                secretCode[i] = (char) characters[randomIndex];
                usedCharacters[randomIndex] = true;
                i++;
            }
        }
        if (userRange <= 10) {
            secretPrepared.append(" (0-9)");
        }
        if(userRange > 10) {
            secretPrepared.append(" (0-9, a-").append(characters[userRange - 1]).append(").");
        }
        
        System.out.println("The secret is prepared: " + secretPrepared);
        return secretCode;
    }
}
