import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ParkingSystem {
    abstract static class Vehicle {
        protected int hours;
        public Vehicle(int hours) { this.hours = hours; }
        public abstract double calculateCharge();
    }

    static class Bike extends Vehicle {
        public Bike(int hours) { super(hours); }
        @Override
        public double calculateCharge() { return hours * 10.0; }
    }

    static class Car extends Vehicle {
        public Car(int hours) { super(hours); }
        @Override
        public double calculateCharge() {
            if (hours <= 0) return 0.0;
            return 30.0 + ((hours - 1) * 20.0);
        }
    }

    static class Truck extends Vehicle {
        public Truck(int hours) { super(hours); }
        @Override
        public double calculateCharge() {
            return Math.max(100.0, hours * 50.0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        List<Vehicle> vehicles = new ArrayList<>();
        List<String> types = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            types.add(type);
            int hours = sc.nextInt();
            
            switch (type) {
                case "BIKE": vehicles.add(new Bike(hours)); break;
                case "CAR": vehicles.add(new Car(hours)); break;
                case "TRUCK": vehicles.add(new Truck(hours)); break;
            }
        }
        
        double total = 0;
        for (int i = 0; i < vehicles.size(); i++) {
            double charge = vehicles.get(i).calculateCharge();
            total += charge;
            System.out.printf("%s: %.2f\n", types.get(i), charge);
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}
