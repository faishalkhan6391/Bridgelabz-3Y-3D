package Level2;
import java.util.Scanner;

public class RockPaperScissors {

    // Method to get computer choice using Math.random()
    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3); // 0, 1, or 2
        if (choice == 0) return "rock";
        else if (choice == 1) return "paper";
        else return "scissors";
    }

    // Method to determine winner
    public static String findWinner(String user, String computer) {
        if (user.equals(computer)) {
            return "Draw";
        }
        if ((user.equals("rock") && computer.equals("scissors")) ||
            (user.equals("paper") && computer.equals("rock")) ||
            (user.equals("scissors") && computer.equals("paper"))) {
            return "User";
        }
        return "Computer";
    }

    // Method to calculate percentages and return 2D array
    public static String[][] calculateStats(int userWins, int compWins, int draws, int totalGames) {
        String[][] stats = new String[2][3];
        double userPercent = ((double) userWins / totalGames) * 100;
        double compPercent = ((double) compWins / totalGames) * 100;

        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f", userPercent) + "%";

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(compWins);
        stats[1][2] = String.format("%.2f", compPercent) + "%";

        return stats;
    }

    // Method to display stats
    public static void displayResults(String[][] stats, int draws) {
        System.out.println("\n--- Final Results ---");
        System.out.println("Player\tWins\tWin %");
        System.out.println("---------------------------");
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2]);
        }
        System.out.println("Draws: " + draws);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // take user input for number of games
        System.out.print("Enter number of games to play: ");
        int totalGames = sc.nextInt();

        int userWins = 0, compWins = 0, draws = 0;

        System.out.println("\nChoices: rock, paper, scissors\n");

        // play multiple rounds
        for (int i = 1; i <= totalGames; i++) {
            System.out.print("Game " + i + " - Enter your choice: ");
            String userChoice = sc.next().toLowerCase();

            String compChoice = getComputerChoice();
            String winner = findWinner(userChoice, compChoice);

            System.out.println("Computer chose: " + compChoice);
            System.out.println("Result: " + winner + " wins!\n");

            // count results
            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) compWins++;
            else draws++;
        }

        // calculate and display final stats
        String[][] stats = calculateStats(userWins, compWins, draws, totalGames);
        displayResults(stats, draws);
    }
}

