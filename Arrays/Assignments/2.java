public class DuplicatePick {
    public static void main(String[] args) {
        String[] team1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        String[] team2 = {"Kohli", "Bumrah", "Rohit"};
        
        System.out.println(findDuplicatePick(team1));
        System.out.println(findDuplicatePick(team2));
    }

    public static String findDuplicatePick(String[] playerNames) {
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }
}
