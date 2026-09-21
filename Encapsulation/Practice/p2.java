public class Scorecard {
    private final boolean[] results;
    private int answersRecorded;

    public Scorecard(int totalQuestions) {
        this.results = new boolean[totalQuestions];
        this.answersRecorded = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (answersRecorded < results.length) {
            results[answersRecorded] = isCorrect;
            answersRecorded++;
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < answersRecorded; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }
}
