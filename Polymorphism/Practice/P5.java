import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ExaminationSystem {
    abstract static class Question {
        protected String correct, student;
        protected double points;
        public Question(String correct, String student, double points) {
            this.correct = correct;
            this.student = student;
            this.points = points;
        }
        public abstract double evaluate();
    }

    static class ExactMatchQuestion extends Question {
        public ExactMatchQuestion(String correct, String student, double points) { 
            super(correct, student, points); 
        }
        @Override
        public double evaluate() {
            return correct.equalsIgnoreCase(student) ? points : 0.0;
        }
    }

    static class EssayQuestion extends Question {
        public EssayQuestion(String correct, String student, double points) { 
            super(correct, student, points); 
        }
        @Override
        public double evaluate() {
            String[] keywords = correct.split(",");
            int matches = 0;
            String studentLower = student.toLowerCase();
            
            for (String kw : keywords) {
                if (studentLower.contains(kw.trim().toLowerCase())) {
                    matches++;
                }
            }
            if (matches >= 2) return points * 0.75;
            if (matches == 1) return points * 0.50;
            return 0.0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        int n = Integer.parseInt(sc.nextLine().trim());
        
        List<Question> questions = new ArrayList<>();
        List<String> types = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            // Basic parsing assuming quotes separate the fields
            String[] parts = line.split("\"");
            String type = parts[0].trim();
            types.add(type);
            
            String correct = parts[3];
            String student = parts[5];
            double points = Double.parseDouble(parts[6].trim());
            
            if (type.equals("ESSAY")) {
                questions.add(new EssayQuestion(correct, student, points));
            } else {
                questions.add(new ExactMatchQuestion(correct, student, points));
            }
        }
        
        double total = 0;
        for (int i = 0; i < questions.size(); i++) {
            double score = questions.get(i).evaluate();
            total += score;
            System.out.printf("%s: %.2f\n", types.get(i), score);
        }
        System.out.printf("Total Score: %.2f\n", total);
        sc.close();
    }
}
