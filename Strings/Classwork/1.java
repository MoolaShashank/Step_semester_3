import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] options = {"Rock", "Paper", "Scissors"};
        
        int rounds = 5;
        int wins = 0, losses = 0, draws = 0;
        String[] history = new String[rounds];

        for (int i = 0; i < rounds; i++) {
            System.out.print("Round " + (i + 1) + " - Enter Rock, Paper, or Scissors: ");
            String playerMove = scanner.nextLine();
            String computerMove = options[random.nextInt(3)];
            
            String result = playRound(playerMove, computerMove);
            history[i] = "Round " + (i + 1) + " | " + playerMove + " | " + computerMove + " | " + result;
            
            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }

        System.out.println("\n--- Final Summary ---");
        for (String record : history) {
            System.out.println(record);
        }
        
        double winPercentage = ((double) wins / rounds) * 100;
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", wins, losses, draws, winPercentage);
    }

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) return "Draw";
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }
}
