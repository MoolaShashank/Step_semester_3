import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class HostelElectricity {
    abstract static class Room {
        protected int units;
        public Room(int units) { this.units = units; }
        public abstract double calculateBill();
    }

    static class SingleRoom extends Room {
        public SingleRoom(int units) { super(units); }
        @Override
        public double calculateBill() { return units * 8.0; }
    }

    static class SharedRoom extends Room {
        private int occupants;
        public SharedRoom(int units, int occupants) { 
            super(units); 
            this.occupants = occupants; 
        }
        @Override
        public double calculateBill() { 
            return (units * 6.0) / occupants; 
        }
    }

    static class ACRoom extends Room {
        public ACRoom(int units) { super(units); }
        @Override
        public double calculateBill() { return (units * 10.0) + 200.0; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        List<Room> rooms = new ArrayList<>();
        List<String> types = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            types.add(type);
            int units = sc.nextInt();
            
            if (type.equals("SHARED")) {
                rooms.add(new SharedRoom(units, sc.nextInt()));
            } else if (type.equals("SINGLE")) {
                rooms.add(new SingleRoom(units));
            } else {
                rooms.add(new ACRoom(units));
            }
        }
        
        double total = 0;
        for (int i = 0; i < rooms.size(); i++) {
            double bill = rooms.get(i).calculateBill();
            total += bill;
            System.out.printf("%s: %.2f\n", types.get(i), bill);
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}
