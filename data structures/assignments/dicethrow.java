import java.util.Arrays;

public class DiceThrowTally {

    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7]; // Indices 1 to 6 store frequencies for die faces

        // Step 1: Tally how many times each die value (1 to 6) appeared
        for (int roll : rolls) {
            count[roll]++;
        }

        // Step 2: Print the frequency counts
        System.out.print("Counts:");
        for (int v = 1; v <= 6; v++) {
            System.out.print(" " + v + ":" + count[v]);
        }
        System.out.println();

        // Step 3: Build the sorted result array using the counts
        int[] sorted = new int[rolls.length];
        int index = 0;
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                sorted[index++] = v;
            }
        }

        return sorted;
    }

    public static void main(String[] args) {
        // Sample Input
        int[] sampleRolls = {4, 1, 6, 4, 2, 1, 4};
        int[] sortedSample = diceSort(sampleRolls);
        System.out.println("Sorted: " + Arrays.toString(sortedSample));
        System.out.println();

        // Custom Test Input
        int[] customRolls = {6, 5, 3, 5, 1, 2, 6, 3, 5};
        int[] sortedCustom = diceSort(customRolls);
        System.out.println("Sorted: " + Arrays.toString(sortedCustom));
    }
}
