import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ElectricityBilling {
    abstract static class Connection {
        protected int units;
        public Connection(int units) { this.units = units; }
        public abstract double calculateBill();
    }

    static class Home extends Connection {
        public Home(int units) { super(units); }
        @Override
        public double calculateBill() {
            if (units <= 100) return units * 5.0;
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }

    static class Shop extends Connection {
        public Shop(int units) { super(units); }
        @Override
        public double calculateBill() { return (units * 8.0) + 100.0; }
    }

    static class Factory extends Connection {
        public Factory(int units) { super(units); }
        @Override
        public double calculateBill() { return Math.max(1000.0, units * 6.0); }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        List<Connection> connections = new ArrayList<>();
        List<String> types = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            types.add(type);
            int units = sc.nextInt();
            
            switch (type) {
                case "HOME": connections.add(new Home(units)); break;
                case "SHOP": connections.add(new Shop(units)); break;
                case "FACTORY": connections.add(new Factory(units)); break;
            }
        }
        
        double total = 0;
        for (int i = 0; i < connections.size(); i++) {
            double bill = connections.get(i).calculateBill();
            total += bill;
            System.out.printf("%s: %.2f\n", types.get(i), bill);
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}
