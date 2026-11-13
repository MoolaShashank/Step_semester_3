public class SecondBestScore {

    public static int secondHighest(int[] scores) {
        int first = -1;
        int second = -1;

        for (int score : scores) {
            if (score > first) {
                second = first;
                first = score;
            } else if (score < first && score > second) {
                second = score;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        int[] sample1 = {45, 78, 92, 78, 60};
        System.out.println(secondHighest(sample1)); // Expected: 78

        int[] sample2 = {50, 50, 50};
        System.out.println(secondHighest(sample2)); // Expected: -1
    }
}
