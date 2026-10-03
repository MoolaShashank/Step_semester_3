import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class CanteenBilling {
    abstract static class Customer {
        protected double amount;
        public Customer(double amount) { this.amount = amount; }
        public abstract double calculateFinalAmount();
    }

    static class Student extends Customer {
        public Student(double amount) { super(amount); }
        @Override
        public double calculateFinalAmount() { return amount * 0.90; }
    }

    static class Staff extends Customer {
        public Staff(double amount) { super(amount); }
        @Override
        public double calculateFinalAmount() { return amount * 0.95; }
    }

    static class Guest extends Customer {
        public Guest(double amount) { super(amount); }
        @Override
        public double calculateFinalAmount() { return amount + 10.0; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        List<Customer> customers = new ArrayList<>();
        List<String> types = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            types.add(type);
            double amount = sc.nextDouble();
            
            switch (type) {
                case "STUDENT": customers.add(new Student(amount)); break;
                case "STAFF": customers.add(new Staff(amount)); break;
                case "GUEST": customers.add(new Guest(amount)); break;
            }
        }
        
        double total = 0;
        for (int i = 0; i < customers.size(); i++) {
            double finalAmount = customers.get(i).calculateFinalAmount();
            total += finalAmount;
            System.out.printf("%s: %.2f\n", types.get(i), finalAmount);
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}
