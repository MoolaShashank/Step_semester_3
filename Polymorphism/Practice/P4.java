import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class TransportSystem {
    abstract static class Transport {
        protected double distance;
        public Transport(double distance) { this.distance = distance; }
        public abstract double calculateFare();
    }

    static class Bus extends Transport {
        public Bus(double distance) { super(distance); }
        @Override
        public double calculateFare() { 
            return Math.min(10.0, 2.0 + (0.10 * distance)); 
        }
    }

    static class Train extends Transport {
        public Train(double distance) { super(distance); }
        @Override
        public double calculateFare() { return 3.0 + (0.15 * distance); }
    }

    static class Metro extends Transport {
        private double peakFactor;
        public Metro(double distance, double peakFactor) { 
            super(distance); 
            this.peakFactor = peakFactor; 
        }
        @Override
        public double calculateFare() { 
            return (1.50 + (0.20 * distance)) * peakFactor; 
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        List<Transport> journeys = new ArrayList<>();
        List<String> types = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            types.add(type);
            double dist = sc.nextDouble();
            
            if (type.equals("METRO")) {
                journeys.add(new Metro(dist, sc.nextDouble()));
            } else if (type.equals("TRAIN")) {
                journeys.add(new Train(dist));
            } else {
                journeys.add(new Bus(dist));
            }
        }
        
        double total = 0;
        for (int i = 0; i < journeys.size(); i++) {
            double fare = journeys.get(i).calculateFare();
            total += fare;
            System.out.printf("%s: %.2f\n", types.get(i), fare);
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}
