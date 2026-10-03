import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class StreamingRenewal {
    abstract static class Plan {
        protected String name;
        protected LocalDate startDate;
        public Plan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }
        public String getName() { return name; }
        public abstract LocalDate calculateRenewalDate();
    }

    static class BasicPlan extends Plan {
        public BasicPlan(String name, LocalDate startDate) { super(name, startDate); }
        @Override
        public LocalDate calculateRenewalDate() { return startDate.plusDays(30); }
    }

    static class StandardPlan extends Plan {
        public StandardPlan(String name, LocalDate startDate) { super(name, startDate); }
        @Override
        public LocalDate calculateRenewalDate() { return startDate.plusDays(90); }
    }

    static class PremiumPlan extends Plan {
        public PremiumPlan(String name, LocalDate startDate) { super(name, startDate); }
        @Override
        public LocalDate calculateRenewalDate() { return startDate.plusDays(365); }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        List<Plan> subscribers = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());
            
            switch (type) {
                case "BASIC": subscribers.add(new BasicPlan(name, date)); break;
                case "STANDARD": subscribers.add(new StandardPlan(name, date)); break;
                case "PREMIUM": subscribers.add(new PremiumPlan(name, date)); break;
            }
        }
        
        for (Plan plan : subscribers) {
            System.out.printf("%s: %s\n", plan.getName(), plan.calculateRenewalDate().toString());
        }
        sc.close();
    }
}
