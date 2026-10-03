import java.util.Scanner;

public class CityCabFare {
    interface NightServiceable {}
    
    abstract static class Cab {
        protected double km;
        public Cab(double km) { this.km = km; }
        protected abstract double getRate();
        
        public double calculateBaseFare() {
            return Math.max(100.0, km * getRate());
        }
    }
    
    static class Mini extends Cab {
        public Mini(double km) { super(km); }
        @Override
        protected double getRate() { return 10.0; }
    }
    
    static class Sedan extends Cab implements NightServiceable {
        public Sedan(double km) { super(km); }
        @Override
        protected double getRate() { return 14.0; }
    }
    
    static class SUV extends Cab implements NightServiceable {
        public SUV(double km) { super(km); }
        @Override
        protected double getRate() { return 18.0; }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        int n = Integer.parseInt(sc.nextLine().trim());
        
        double total = 0;
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) { i--; continue; }
            String[] parts = line.split("\\s+");
            String type = parts[0];
            double km = Double.parseDouble(parts[1]);
            boolean isNight = parts[2].equals("NIGHT");
            
            Cab cab = null;
            switch (type) {
                case "MINI": cab = new Mini(km); break;
                case "SEDAN": cab = new Sedan(km); break;
                case "SUV": cab = new SUV(km); break;
            }
            
            if (isNight && !(cab instanceof NightServiceable)) {
                System.out.printf("%s: night service not available\n", type);
            } else {
                double fare = cab.calculateBaseFare();
                if (isNight) {
                    fare *= 1.20;
                }
                total += fare;
                System.out.printf("%s: %.2f\n", type, fare);
            }
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}
