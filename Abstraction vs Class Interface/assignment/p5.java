import java.util.Scanner;

public class HomeApplianceEnergy {
    interface SaverModeSupported {}
    
    abstract static class Appliance {
        protected double hours;
        public Appliance(double hours) { this.hours = hours; }
        public abstract double getPowerRating();
        
        public double calculateUnits() {
            return (getPowerRating() * hours) / 1000.0;
        }
    }
    
    static class Fridge extends Appliance {
        public Fridge(double hours) { super(hours); }
        @Override
        public double getPowerRating() { return 150.0; }
    }
    
    static class AC extends Appliance implements SaverModeSupported {
        public AC(double hours) { super(hours); }
        @Override
        public double getPowerRating() { return 1500.0; }
    }
    
    static class TV extends Appliance {
        public TV(double hours) { super(hours); }
        @Override
        public double getPowerRating() { return 100.0; }
    }
    
    static class Washer extends Appliance implements SaverModeSupported {
        public Washer(double hours) { super(hours); }
        @Override
        public double getPowerRating() { return 500.0; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        int n = Integer.parseInt(sc.nextLine().trim());
        
        double totalCost = 0;
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) { i--; continue; }
            String[] parts = line.split("\\s+");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saver = parts.length > 2 && parts[2].equals("SAVER");
            
            Appliance app = null;
            switch (type) {
                case "FRIDGE": app = new Fridge(hours); break;
                case "AC": app = new AC(hours); break;
                case "TV": app = new TV(hours); break;
                case "WASHER": app = new Washer(hours); break;
            }
            
            if (saver && !(app instanceof SaverModeSupported)) {
                System.out.printf("%s: saver mode not supported\n", type);
            } else {
                double units = app.calculateUnits();
                if (saver) {
                    units *= 0.75;
                }
                double cost = units * 8.0;
                totalCost += cost;
                System.out.printf("%s: Units=%.2f Cost=%.2f\n", type, units, cost);
            }
        }
        System.out.printf("Total Cost: %.2f\n", totalCost);
        sc.close();
    }
}
