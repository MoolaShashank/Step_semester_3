public class ExamScoreBandCounter {

    public static int countInBand(int[] scores, int low, int high) {
        return firstGreater(scores, high) - firstGreaterOrEqual(scores, low);
    }

    // Finds the first index i where scores[i] >= target (Lower Bound)
    private static int firstGreaterOrEqual(int[] scores, int target) {
        int left = 0, right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] >= target) {
                right = mid; // Keep searching left to find the first occurrence
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Finds the first index i where scores[i] > target (Upper Bound)
    private static int firstGreater(int[] scores, int target) {
        int left = 0, right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] > target) {
                right = mid;
            } else {
                left = mid + 1; // Move right even if scores[mid] == target
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};

        System.out.println(countInBand(scores, 42, 58));  // Expected: 6
        System.out.println(countInBand(scores, 90, 100)); // Expected: 0
    }
}
