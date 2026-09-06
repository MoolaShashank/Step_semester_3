public class DuplicateFinder {
    public static void main(String[] args) {
        String[] teams1 = {"ByteForce", "CodeCrafters", "ByteForce"};
        String[] teams2 = {"ByteForce", "CodeCrafters", "NullPointers"};
        
        System.out.println(findDuplicateTeam(teams1));
        System.out.println(findDuplicateTeam(teams2));
    }

    public static String findDuplicateTeam(String[] teamNames) {
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }
}
