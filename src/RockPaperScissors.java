import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Jason on 6/23/2016.
 * This is a Rock Paper Scissors Game
 */
public class RockPaperScissors {
    public static Scanner input = new Scanner(System.in);
    public static String playerName = "";
    public static String yesOrNo = "";
    public static List<String> myRecords = new ArrayList<>();

    public static void main(String[] args) {
        // call mainMenu method to open the main menu
        mainMenu();

    }

    public static void mainMenu() {

        System.out.println(
                "-=~=-=~=-=~=-=~=- Main Menu -=~=-=~=-=~=-=~=-" +
                        "\n-=~=-  Welcome to Rock Paper Scissors!  -=~=-" +
                        "\n-=~=-=~=-=~=-=~=-           -=~=-=~=-=~=-=~=-" +
                        "\n1. Type 'play' to play" +
                        "\n2. Type 'history' to view your game history" +
                        "\nType 'quit' to quit the game\n\n");
        menuOptionCheck();
    }

    public static void menuOptionCheck() {
        String userInput = input.nextLine().trim();

        // using switch case
        switch (userInput) {
            case "play":
                playRPS();
                break;

            case "history":
                logHistory();
                break;

            case "quit":
                exitTheProgram();
                break;

            default:
                System.out.println("Silly Rabbit " + userInput + " is not a valid command!\n" +
                        "Type 'play' to play 'history' to view your game history or 'quit' to quit the game");
                menuOptionCheck();
        }
    }

    public static void playRPS() {

        System.out.println("New Challenger!\nPlease enter your name to continue\n");
        playerName = inputName();
        System.out.println("\n\nThe rules of Rock Paper Scissors is very simple.\nRock beats Scissors\n" +
                "Paper beats Rock" + "\nScissors beats Paper\n");
        matchStart();


    }

    public static void logHistory() {
        System.out.println("\n-=~=-=~=-=~=-=~=- History -=~=-=~=-=~=-=~=-\n");

        if (myRecords.isEmpty()) {
            System.out.println("No History\n");
        } else {
            for (int i = 0; i < myRecords.size(); i++) {
                System.out.println(myRecords.get(i));
            }
        }

        historyPrompt();
    }


    public static void exitTheProgram() {
        System.out.println("Thanks for playing good bye!");
        System.out.println("      .' '.            .' '.            .' '.           .' '.   ");
        System.out.println("    _/_-.-_\\_        _/.-.-.\\_        _/.-.-.\\_       _/.-.-.\\_ ");
        System.out.println("   / __} {__ \\      /|( o o )|\\      ( ( o o ) )     ( ( o o ) )");
        System.out.println("  / // * * \\\\ \\    | // * * \\\\ |      |/ * * \\|       |/ * * \\| ");
        System.out.println(" / / \\'---'/ \\ \\  / / \\'---'/ \\ \\      \\'/^\\'/         \\ .-. /  ");
        System.out.println(" \\ \\_/`'''`\\_/ /  \\ \\_/`'''`\\_/ /      /`\\ /`\\         /`'''`\\  ");
        System.out.println("  \\           /    \\           /      /  /|\\  \\       /       \\ ");

    }

    public static String inputName() {
        String name = input.nextLine().trim();
        System.out.println("Your name is " + name + "?" +
                "\nType 'yes' to continue or 'no' to re-enter your name");
        yesOrNo = confirmation();

        return name;
    }

    public static String confirmation() {
        String confirm = input.nextLine().trim();

        switch (confirm) {
            case "yes":
                return confirm;

            case "no":
                System.out.println("Please re-enter your name");
                inputName();
                break;

            default:
                System.out.println("      .' '.            .' '.            .' '.           .' '.   ");
                System.out.println("    _/_-.-_\\_        _/.-.-.\\_        _/.-.-.\\_       _/.-.-.\\_ ");
                System.out.println("   / __} {__ \\      /|( o o )|\\      ( ( o o ) )     ( ( o o ) )");
                System.out.println("  / // * * \\\\ \\    | // * * \\\\ |      |/ * * \\|       |/ * * \\| ");
                System.out.println(" / / \\'---'/ \\ \\  / / \\'---'/ \\ \\      \\'/^\\'/         \\ .-. /  ");
                System.out.println(" \\ \\_/`'''`\\_/ /  \\ \\_/`'''`\\_/ /      /`\\ /`\\         /`'''`\\  ");
                System.out.println("  \\           /    \\           /      /  /|\\  \\       /       \\ ");
                System.out.println("Oh sorry that's an invalid command");
                confirmation();
        }
        return confirm;
    }

    public static void matchStart() {
        // Player choice of RPS
        System.out.println("Type in 'rock', 'paper', or 'scissors' to start the match!\n");
        String choice = input.nextLine().trim();
        int playerChoice = 0;
        String compStringRPS = "";

        if (choice.equalsIgnoreCase("rock")) {
            playerChoice = 1;
        } else if (choice.equalsIgnoreCase("paper")) {
            playerChoice = 2;
        } else if (choice.equalsIgnoreCase("scissors")) {
            playerChoice = 3;
        } else {
            System.out.println("      .' '.            .' '.            .' '.           .' '.   ");
            System.out.println("    _/_-.-_\\_        _/.-.-.\\_        _/.-.-.\\_       _/.-.-.\\_ ");
            System.out.println("   / __} {__ \\      /|( o o )|\\      ( ( o o ) )     ( ( o o ) )");
            System.out.println("  / // * * \\\\ \\    | // * * \\\\ |      |/ * * \\|       |/ * * \\| ");
            System.out.println(" / / \\'---'/ \\ \\  / / \\'---'/ \\ \\      \\'/^\\'/         \\ .-. /  ");
            System.out.println(" \\ \\_/`'''`\\_/ /  \\ \\_/`'''`\\_/ /      /`\\ /`\\         /`'''`\\  ");
            System.out.println("  \\           /    \\           /      /  /|\\  \\       /       \\ ");
            System.out.println(playerName + " why are you so useless I told you to:");
            matchStart();
        }

        Random randRNG = new Random();
        int compRPS = randRNG.nextInt(3) + 1;

        switch (compRPS) {
            // rock
            case 1:
                compStringRPS = "rock";
                break;
            // paper
            case 2:
                compStringRPS = "paper";
                break;
            // scissors
            case 3:
                compStringRPS = "scissor";
                break;
            default:
                System.out.println("How did this happen?");
        }

        // Tie
        if (playerChoice == compRPS) {
            System.out.println(playerName + " chose: " + choice +
                    " computer chose: " + compStringRPS + "\nResult: You got lucky and tied");
            myRecords.add(playerName + " chose: " + choice +
                    " computer chose: " + compStringRPS + " Result: TIE");
        } else if (playerChoice == 1) {
            if (compRPS == 2) {
                System.out.println(playerName + " chose: " + choice +
                        " computer chose: " + compStringRPS + "\nResult: What bad luck maybe next time " + playerName);
                myRecords.add(playerName + " chose: " + choice +
                        " computer chose: " + compStringRPS + " Result: LOSE");
            } else if (compRPS == 3) {
                System.out.println(playerName + " chose: " + choice +
                        " computer chose: " + compStringRPS + "\nResult: Alright... You win this time " + playerName);
                myRecords.add(playerName + " chose: " + choice +
                        " computer chose: " + compStringRPS + " Result: WIN");
            }
        } else if (playerChoice == 2) {
            if (compRPS == 1) {
                System.out.println(playerName + " chose: " + choice +
                        " computer chose: " + compStringRPS + "\nResult: Alright... You win this time " + playerName);
                myRecords.add(playerName + " chose: " + choice +
                        " computer chose: " + compStringRPS + " Result: WIN");
            } else if (compRPS == 3) {
                System.out.println(playerName + " chose: " + choice +
                        " computer chose: " + compStringRPS + "\nResult: What bad luck maybe next time " + playerName);
                myRecords.add(playerName + " chose: " + choice +
                        " computer chose: " + compStringRPS + " Result: LOSE");
            }
        } else if (playerChoice == 3) {
            if (compRPS == 1) {
                System.out.println(playerName + " chose: " + choice +
                        " computer chose: " + compStringRPS + "\nResult: What bad luck maybe next time " + playerName);
                myRecords.add(playerName + " chose: " + choice +
                        " computer chose: " + compStringRPS + " Result: LOSE");
            } else if (compRPS == 2) {
                System.out.println(playerName + " chose: " + choice +
                        " computer chose: " + compStringRPS + "\nResult: Alright... You win this time " + playerName);
                myRecords.add(playerName + " chose: " + choice +
                        " computer chose: " + compStringRPS + " Result: WIN");
            }
        }

        System.out.println("Play again? Type 'yes' to continue 'no' to go back to the main menu");
        playAgain();


    }

    public static void playAgain() {
        String optionAgain = input.nextLine().trim();
        switch (optionAgain) {
            case "yes":
                matchStart();
                break;
            case "no":
                System.out.println("You quit? Are you serious... Maybe next time punk ass " + playerName);
                mainMenu();
                break;
            default:
                System.out.println("      .' '.            .' '.            .' '.           .' '.   ");
                System.out.println("    _/_-.-_\\_        _/.-.-.\\_        _/.-.-.\\_       _/.-.-.\\_ ");
                System.out.println("   / __} {__ \\      /|( o o )|\\      ( ( o o ) )     ( ( o o ) )");
                System.out.println("  / // * * \\\\ \\    | // * * \\\\ |      |/ * * \\|       |/ * * \\| ");
                System.out.println(" / / \\'---'/ \\ \\  / / \\'---'/ \\ \\      \\'/^\\'/         \\ .-. /  ");
                System.out.println(" \\ \\_/`'''`\\_/ /  \\ \\_/`'''`\\_/ /      /`\\ /`\\         /`'''`\\  ");
                System.out.println("  \\           /    \\           /      /  /|\\  \\       /       \\ ");
                System.out.println(playerName + ", it was a simple request can you not comply?" +
                        "\nType 'yes' to continue 'no' to go back to the main menu");
                playAgain();
        }
    }

    public static void historyPrompt() {
        System.out.println("Type 'back' to return to the main menu or 'exit' ");
        String backOrExit = input.nextLine().trim();
        switch (backOrExit) {
            case "back":
                mainMenu();
                break;

            case "exit":
                System.out.println("      .' '.            .' '.            .' '.           .' '.   ");
                System.out.println("    _/_-.-_\\_        _/.-.-.\\_        _/.-.-.\\_       _/.-.-.\\_ ");
                System.out.println("   / __} {__ \\      /|( o o )|\\      ( ( o o ) )     ( ( o o ) )");
                System.out.println("  / // * * \\\\ \\    | // * * \\\\ |      |/ * * \\|       |/ * * \\| ");
                System.out.println(" / / \\'---'/ \\ \\  / / \\'---'/ \\ \\      \\'/^\\'/         \\ .-. /  ");
                System.out.println(" \\ \\_/`'''`\\_/ /  \\ \\_/`'''`\\_/ /      /`\\ /`\\         /`'''`\\  ");
                System.out.println("  \\           /    \\           /      /  /|\\  \\       /       \\ ");
                System.out.println("Goodbye!");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid Command");
                historyPrompt();
        }
    }


}
