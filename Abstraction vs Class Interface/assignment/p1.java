import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MovieTicketCounter {
    abstract static class Ticket {
        protected int count;
        
        public Ticket(int count) { 
            this.count = count; 
        }
        
        protected abstract double getBasePrice();
        
        public final double calculateTotalAmount() {
            return (getBasePrice() + 20.0) * count;
        }
    }

    static class RegularTicket extends Ticket {
        public RegularTicket(int count) { super(count); }
        @Override
        protected double getBasePrice() { return 150.0; }
    }

    static class PremiumTicket extends Ticket {
        public PremiumTicket(int count) { super(count); }
        @Override
        protected double getBasePrice() { return 250.0; }
    }

    static class ReclinerTicket extends Ticket {
        public ReclinerTicket(int count) { super(count); }
        @Override
        protected double getBasePrice() { return 400.0; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        List<Ticket> tickets = new ArrayList<>();
        List<String> types = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            types.add(type);
            int count = sc.nextInt();
            
            switch (type) {
                case "REGULAR": tickets.add(new RegularTicket(count)); break;
                case "PREMIUM": tickets.add(new PremiumTicket(count)); break;
                case "RECLINER": tickets.add(new ReclinerTicket(count)); break;
            }
        }
        
        double total = 0;
        for (int i = 0; i < tickets.size(); i++) {
            double amt = tickets.get(i).calculateTotalAmount();
            total += amt;
            System.out.printf("%s: %.2f\n", types.get(i), amt);
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}
