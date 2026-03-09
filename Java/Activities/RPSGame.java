import java.util.Scanner;
import java.util.Random;

public class RPSGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String[] choice = {"Rock", "Paper", "Scissors"};

        try {

            System.out.println("==== Rock Paper Scissors Game ====");
            System.out.println("0 - Rock | 1 - Paper | 2 - Scissors");

            System.out.print("Your move: ");
            int human = sc.nextInt();

            if (human < 0 || human > 2) {
                throw new IllegalArgumentException("Choose only 0, 1 or 2");
            }

            int computer = rand.nextInt(3);

            System.out.println("\nYou played: " + choice[human]);
            System.out.println("Computer played: " + choice[computer]);

            System.out.println("\n--- Result ---");

            if (human == computer) {
                System.out.println("It's a Draw!");
            } 
            else if ((human == 0 && computer == 2) ||
                     (human == 1 && computer == 0) ||
                     (human == 2 && computer == 1)) {
                System.out.println("You beat the Computer!");
            } 
            else {
                System.out.println("Computer wins this round!");
            }

            

        } 
        catch (Exception e) {
            System.out.println("Invalid input! Please enter 0, 1, or 2.");
        }

        sc.close();
    }
}
