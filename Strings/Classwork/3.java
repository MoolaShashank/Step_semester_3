import java.util.Random;

public class BMICalculator {
    public static void main(String[] args) {
        double[] heights = new double[10];
        double[] weights = new double[10];
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            heights[i] = 1.5 + (rand.nextDouble() * 0.5); // Random height between 1.5m and 2.0m
            weights[i] = 50 + (rand.nextDouble() * 50);   // Random weight between 50kg and 100kg
        }
        
        printWellnessReport(heights, weights);
    }

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi <= 24.9) return "Normal";
        if (bmi <= 29.9) return "Overweight";
        return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("Person %d | %.2f m | %.2f kg | %.2f | %s\n", 
                              (i + 1), heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }
}
