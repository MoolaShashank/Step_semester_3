import java.util.Arrays;

public class PrizeTable {

    public static int prizeTable(int[] marks) {
        int swaps = 0;
        int n = marks.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;

            // Scan from i + 1 to the end to find the index of the largest mark
            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIdx]) {
                    maxIdx = j;
                }
            }

            // Swap only if the largest mark is not already at position i
            if (maxIdx != i) {
                int temp = marks[i];
                marks[i] = marks[maxIdx];
                marks[maxIdx] = temp;
                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        // Sample Input 1
        int[] sample1 = {45, 90, 60, 75};
        int swaps1 = prizeTable(sample1);
        System.out.println(Arrays.toString(sample1) + "   swaps = " + swaps1);

        // Sample Input 2
        int[] sample2 = {80, 70, 60};
        int swaps2 = prizeTable(sample2);
        System.out.println(Arrays.toString(sample2) + "   swaps = " + swaps2);

        // Custom Test Input
        int[] custom = {50, 95, 85, 40, 70};
        int swapsCustom = prizeTable(custom);
        System.out.println(Arrays.toString(custom) + "   swaps = " + swapsCustom);
    }
}
