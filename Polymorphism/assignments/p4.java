import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class FestivalBonus {
    abstract static class Employee {
        protected String name;
        protected double salary;
        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }
        public String getName() { return name; }
        public abstract double calculateBonus();
    }

    static class FullTimeEmployee extends Employee {
        public FullTimeEmployee(String name, double salary) { super(name, salary); }
        @Override
        public double calculateBonus() { return salary * 0.10; }
    }

    static class PartTimeEmployee extends Employee {
        public PartTimeEmployee(String name, double salary) { super(name, salary); }
        @Override
        public double calculateBonus() { return salary * 0.05; }
    }

    static class Intern extends Employee {
        public Intern(String name, double salary) { super(name, salary); }
        @Override
        public double calculateBonus() { return 2000.0; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        List<Employee> employees = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            
            switch (type) {
                case "FULLTIME": employees.add(new FullTimeEmployee(name, salary)); break;
                case "PARTTIME": employees.add(new PartTimeEmployee(name, salary)); break;
                case "INTERN": employees.add(new Intern(name, salary)); break;
            }
        }
        
        double total = 0;
        for (Employee emp : employees) {
            double bonus = emp.calculateBonus();
            total += bonus;
            System.out.printf("%s: %.2f\n", emp.getName(), bonus);
        }
        System.out.printf("Total Bonus: %.2f\n", total);
        sc.close();
    }
}
