import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class CollegeFeeCounter {
    interface BusUser {
        double getTransportFee();
    }
    
    abstract static class Student {
        protected String name;
        public Student(String name) { this.name = name; }
        public String getName() { return name; }
        public abstract double getBaseFee();
    }
    
    static class DayScholar extends Student implements BusUser {
        public DayScholar(String name) { super(name); }
        @Override
        public double getBaseFee() { return 40000.0; }
        @Override
        public double getTransportFee() { return 12000.0; }
    }
    
    static class Hosteller extends Student {
        public Hosteller(String name) { super(name); }
        @Override
        public double getBaseFee() { return 40000.0 + 60000.0; }
    }
    
    static class Scholar extends Student implements BusUser {
        public Scholar(String name) { super(name); }
        @Override
        public double getBaseFee() { return 20000.0; }
        @Override
        public double getTransportFee() { return 12000.0; }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        int n = Integer.parseInt(sc.nextLine().trim());
        
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) { i--; continue; }
            String[] parts = line.split("\\s+");
            
            if (parts[0].equals("DAY")) {
                students.add(new DayScholar(parts[2]));
            } else if (parts[0].equals("DAY_SCHOLAR")) {
                students.add(new DayScholar(parts[1]));
            } else if (parts[0].equals("HOSTELLER")) {
                students.add(new Hosteller(parts[1]));
            } else if (parts[0].equals("SCHOLAR")) {
                students.add(new Scholar(parts[1]));
            }
        }
        
        double grandTotal = 0;
        for (Student s : students) {
            double totalFee = s.getBaseFee();
            if (s instanceof BusUser) {
                totalFee += ((BusUser) s).getTransportFee();
            }
            grandTotal += totalFee;
            System.out.printf("%s: %.2f\n", s.getName(), totalFee);
        }
        System.out.printf("Total Collected: %.2f\n", grandTotal);
        sc.close();
    }
}
