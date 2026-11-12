import java.util.Scanner;
import java.util.Random;

public class GuessTheWord {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        String playAgain = "yes";

        System.out.println("================================");
        System.out.println("         GUESS THE WORD");
        System.out.println("================================");

        while (playAgain.equalsIgnoreCase("yes")) {

            int subject = 0;
            int difficulty = 0;

            System.out.println("\nCHOOSE A SUBJECT");
            System.out.println("[1] Math");
            System.out.println("[2] Science");
            System.out.println("[3] English");

            while (subject < 1 || subject > 3) {
                System.out.print("Enter subject: ");

                if (input.hasNextInt()) {
                    subject = input.nextInt();

                    if (subject < 1 || subject > 3) {
                        System.out.println("Invalid choice! Try again.");
                    }
                } else {
                    input.next();
                    System.out.println("Please enter a number.");
                }
            }

            System.out.println("\nCHOOSE DIFFICULTY");
            System.out.println("[1] Easy");
            System.out.println("[2] Medium");
            System.out.println("[3] Hard");

            while (difficulty < 1 || difficulty > 3) {
                System.out.print("Enter difficulty: ");

                if (input.hasNextInt()) {
                    difficulty = input.nextInt();

                    if (difficulty < 1 || difficulty > 3) {
                        System.out.println("Invalid choice! Try again.");
                    }
                } else {
                    input.next();
                    System.out.println("Please enter a number.");
                }
            }

            String[] words = new String[3];
            String[] hints = new String[3];

            if (subject == 1) {

                if (difficulty == 1) {
                    words[0] = "PLUS";
                    words[1] = "CIRCLE";
                    words[2] = "NUMBER";

                    hints[0] = "A symbol used for addition.";
                    hints[1] = "A round shape.";
                    hints[2] = "A mathematical value.";

                } else if (difficulty == 2) {
                    words[0] = "FRACTION";
                    words[1] = "TRIANGLE";
                    words[2] = "EQUATION";

                    hints[0] = "A part of a whole.";
                    hints[1] = "A shape with three sides.";
                    hints[2] = "A statement with an equal sign.";

                } else {
                    words[0] = "PERCENTAGE";
                    words[1] = "MULTIPLICATION";
                    words[2] = "DENOMINATOR";

                    hints[0] = "A ratio expressed out of 100.";
                    hints[1] = "Repeated addition of equal groups.";
                    hints[2] = "The bottom number of a fraction.";
                }

            } else if (subject == 2) {

                if (difficulty == 1) {
                    words[0] = "WATER";
                    words[1] = "PLANT";
                    words[2] = "SUN";

                    hints[0] = "We drink this every day.";
                    hints[1] = "A living thing that grows in soil.";
                    hints[2] = "The star that gives Earth light.";

                } else if (difficulty == 2) {
                    words[0] = "OXYGEN";
                    words[1] = "PLANET";
                    words[2] = "GRAVITY";

                    hints[0] = "A gas humans need to breathe.";
                    hints[1] = "A large object that moves around a star.";
                    hints[2] = "The force that pulls objects downward.";

                } else {
                    words[0] = "PHOTOSYNTHESIS";
                    words[1] = "EVAPORATION";
                    words[2] = "ECOSYSTEM";

                    hints[0] = "The process plants use to make food.";
                    hints[1] = "The process of liquid becoming gas.";
                    hints[2] = "Living things interacting with their environment.";
                }

            } else {

                if (difficulty == 1) {
                    words[0] = "BOOK";
                    words[1] = "HAPPY";
                    words[2] = "APPLE";

                    hints[0] = "Something you read.";
                    hints[1] = "The opposite of sad.";
                    hints[2] = "A fruit that can be red or green.";

                } else if (difficulty == 2) {
                    words[0] = "ADJECTIVE";
                    words[1] = "SYNONYM";
                    words[2] = "VERB";

                    hints[0] = "A word that describes a noun.";
                    hints[1] = "A word with a similar meaning.";
                    hints[2] = "A word that shows an action.";

                } else {
                    words[0] = "METAPHOR";
                    words[1] = "HYPERBOLE";
                    words[2] = "ONOMATOPOEIA";

                    hints[0] = "A comparison without like or as.";
                    hints[1] = "An extreme exaggeration.";
                    hints[2] = "A word that imitates a sound.";
                }
            }

            int index = random.nextInt(3);
            String answer = words[index];
            String hint = hints[index];

            int attempts = 8;

            if (difficulty == 2) {
                attempts = 6;
            } else if (difficulty == 3) {
                attempts = 4;
            }

            System.out.println("\n================================");
            System.out.println("             GAME START");
            System.out.println("================================");
            System.out.println("Hint: " + hint);
            System.out.println("Letters: " + answer.length());
            System.out.println("Attempts: " + attempts);

            String guess = "";

            while (attempts > 0 && !guess.equalsIgnoreCase(answer)) {

                System.out.print("\nEnter your guess: ");
                guess = input.next();

                if (guess.equalsIgnoreCase(answer)) {
                    System.out.println("CORRECT! YOU GOT IT!");

                } else {
                    attempts--;
                    System.out.println("Wrong answer! Try again.");
                    System.out.println("Attempts left: " + attempts);
                }
            }

            if (!guess.equalsIgnoreCase(answer)) {
                System.out.println("\nGAME OVER!");
                System.out.println("The correct word is: " + answer);
            }

            System.out.print("\nPlay again? (yes/no): ");
            playAgain = input.next();

            while (!playAgain.equalsIgnoreCase("yes") &&
                   !playAgain.equalsIgnoreCase("no")) {

                System.out.print("Please enter yes or no: ");
                playAgain = input.next();
            }
        }

        System.out.println("\nTHANK YOU FOR PLAYING!");

        input.close();
    }
}
