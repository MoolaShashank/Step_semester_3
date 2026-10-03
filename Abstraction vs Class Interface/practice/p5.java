import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class TravelBooking {
    abstract static class Booking {
        protected double distance;
        private static final double BOOKING_FEE = 50.0;
        
        public Booking(double distance) { this.distance = distance; }
        
        // Abstract method restricted to subclass implementation
        protected abstract double getBaseFare();
        
        // Final public template method applies the universal rule
        public final double getTotalFare() {
            return getBaseFare() + BOOKING_FEE;
        }
    }

    static class Bus extends Booking {
        public Bus(double distance) { super(distance); }
        @Override
        protected double getBaseFare() { return distance * 2.0; }
    }

    static class Train extends Booking {
        public Train(double distance) { super(distance); }
        @Override
        protected double getBaseFare() { return distance * 1.5; }
    }

    static class Flight extends Booking {
        public Flight(double distance) { super(distance); }
        @Override
        protected double getBaseFare() { return 2500.0 + (distance * 4.0); }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        List<Booking> bookings = new ArrayList<>();
        List<String> modes = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            modes.add(mode);
            double distance = sc.nextDouble();
            
            switch (mode) {
                case "BUS": bookings.add(new Bus(distance)); break;
                case "TRAIN": bookings.add(new Train(distance)); break;
                case "FLIGHT": bookings.add(new Flight(distance)); break;
            }
        }
        
        for (int i = 0; i < bookings.size(); i++) {
            System.out.printf("%s: %.2f\n", modes.get(i), bookings.get(i).getTotalFare());
        }
        sc.close();
    }
}
