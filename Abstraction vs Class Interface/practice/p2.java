import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class WeeklyStaffPay {
    abstract static class Staff {
        protected String name;
        public Staff(String name) { this.name = name; }
        public String getName() { return name; }
        public abstract double calculatePay();
    }

    static class FullTime extends Staff {
        private double weeklySalary;
        public FullTime(String name, double weeklySalary) { 
            super(name); 
            this.weeklySalary = weeklySalary; 
        }
        @Override
        public double calculatePay() { return weeklySalary; }
    }

    static class Hourly extends Staff {
        private double hours, rate;
        public Hourly(String name, double hours, double rate) { 
            super(name); 
            this.hours = hours; 
            this.rate = rate; 
        }
        @Override
        public double calculatePay() {
            if (hours <= 40) return hours * rate;
            return (40 * rate) + ((hours - 40) * rate * 1.5);
        }
    }

    static class Intern extends Staff {
        private double stipend;
        public Intern(String name, double stipend) { 
            super(name); 
            this.stipend = stipend; 
        }
        @Override
        public double calculatePay() { return stipend; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        List<Staff> staffList = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            
            switch (type) {
                case "FULLTIME": staffList.add(new FullTime(name, sc.nextDouble())); break;
                case "HOURLY": staffList.add(new Hourly(name, sc.nextDouble(), sc.nextDouble())); break;
                case "INTERN": staffList.add(new Intern(name, sc.nextDouble())); break;
            }
        }
        
        double total = 0;
        for (Staff s : staffList) {
            double pay = s.calculatePay();
            total += pay;
            System.out.printf("%s: %.2f\n", s.getName(), pay);
        }
        System.out.printf("Total Payroll: %.2f\n", total);
        sc.close();
    }
}
