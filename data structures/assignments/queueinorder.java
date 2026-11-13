public class QueueOrderChecker {

    public static int firstBreak(int[] tokens) {
        // An empty queue or a queue of one student is always in order
        if (tokens == null || tokens.length <= 1) {
            return -1;
        }

        // Start at index 1 and compare each token with the one just before it
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i; // Return the index of the first out-of-order student
            }
        }

        return -1; // The whole queue is in non-decreasing order
    }

    public static void main(String[] args) {
        // Sample Input 1
        int[] sample1 = {3, 5, 5, 8, 6, 9};
        System.out.println(firstBreak(sample1)); // Expected: 4

        // Sample Input 2
        int[] sample2 = {1, 2, 2, 7};
        System.out.println(firstBreak(sample2)); // Expected: -1

        // Custom Test Inputs
        int[] custom1 = {10, 20, 15, 25, 12};
        System.out.println(firstBreak(custom1)); // Expected: 2 (15 comes after 20)

        int[] custom2 = {42};
        System.out.println(firstBreak(custom2)); // Expected: -1 (single student)
    }
}
