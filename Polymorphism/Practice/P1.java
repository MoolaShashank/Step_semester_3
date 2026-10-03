import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class PaymentSystem {
    abstract static class Payment {
        protected double amount;
        public Payment(double amount) { this.amount = amount; }
        public abstract double getAdjustedAmount();
    }

    static class CardPayment extends Payment {
        public CardPayment(double amount) { super(amount); }
        @Override
        public double getAdjustedAmount() { return amount * 1.02; } // 2% fee
    }

    static class WalletPayment extends Payment {
        public WalletPayment(double amount) { super(amount); }
        @Override
        public double getAdjustedAmount() { return amount * 1.01; } // 1% fee
    }

    static class BankTransferPayment extends Payment {
        public BankTransferPayment(double amount) { super(amount); }
        @Override
        public double getAdjustedAmount() { return amount; } // No fee
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        List<Payment> transactions = new ArrayList<>();
        List<String> types = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            types.add(type);
            
            switch (type) {
                case "CARD": transactions.add(new CardPayment(amount)); break;
                case "WALLET": transactions.add(new WalletPayment(amount)); break;
                case "BANKTRANSFER": transactions.add(new BankTransferPayment(amount)); break;
            }
        }
        
        double total = 0;
        for (int i = 0; i < transactions.size(); i++) {
            double adjusted = transactions.get(i).getAdjustedAmount();
            total += adjusted;
            System.out.printf("%s: %.2f\n", types.get(i), adjusted);
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}
