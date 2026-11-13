import java.util.Arrays;

public class HeightLineUp {

    public static void lineUp(int[] heights) {
        int n = heights.length;

        for (int pass = 1; pass < n; pass++) {
            boolean swapped = false;

            for (int j = 0; j < n - pass; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }

            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));

            // If no swaps occurred in this sweep, the line is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        // Sample Input 1
        lineUp(new int[]{4, 2, 5, 1});
        System.out.println();

        // Sample Input 2
        lineUp(new int[]{1, 3, 2, 4});
        System.out.println();

        // Custom Test Input
        lineUp(new int[]{6, 3, 8, 5, 2});
    }
}
