import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class DeliverySystem {
    abstract static class Delivery {
        protected double weight, distance;
        public Delivery(double weight, double distance) { 
            this.weight = weight; 
            this.distance = distance; 
        }
        public abstract double calculateFee();
    }

    static class StandardDelivery extends Delivery {
        public StandardDelivery(double weight, double distance) { super(weight, distance); }
        @Override
        public double calculateFee() { return 5.0 + (0.50 * weight) + (0.10 * distance); }
    }

    static class ExpressDelivery extends Delivery {
        public ExpressDelivery(double weight, double distance) { super(weight, distance); }
        @Override
        public double calculateFee() { return 15.0 + (1.00 * weight) + (0.20 * distance); }
    }

    static class InternationalDelivery extends Delivery {
        private double customsFee;
        public InternationalDelivery(double weight, double distance, double customsFee) { 
            super(weight, distance); 
            this.customsFee = customsFee; 
        }
        @Override
        public double calculateFee() { return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        List<Delivery> deliveries = new ArrayList<>();
        List<String> types = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            types.add(type);
            double w = sc.nextDouble();
            double d = sc.nextDouble();
            
            if (type.equals("INTERNATIONAL")) {
                deliveries.add(new InternationalDelivery(w, d, sc.nextDouble()));
            } else if (type.equals("EXPRESS")) {
                deliveries.add(new ExpressDelivery(w, d));
            } else {
                deliveries.add(new StandardDelivery(w, d));
            }
        }
        
        double total = 0;
        for (int i = 0; i < deliveries.size(); i++) {
            double fee = deliveries.get(i).calculateFee();
            total += fee;
            System.out.printf("%s: %.2f\n", types.get(i), fee);
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}
