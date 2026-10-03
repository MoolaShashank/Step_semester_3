import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class LibraryFines {
    abstract static class Item {
        protected String title;
        protected int daysLate;
        public Item(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }
        public String getTitle() { return title; }
        public abstract double calculateFine();
    }

    static class Book extends Item {
        public Book(String title, int daysLate) { super(title, daysLate); }
        @Override
        public double calculateFine() { return daysLate * 2.0; }
    }

    static class DVD extends Item {
        public DVD(String title, int daysLate) { super(title, daysLate); }
        @Override
        public double calculateFine() { return Math.min(50.0, daysLate * 5.0); }
    }

    static class Magazine extends Item {
        public Magazine(String title, int daysLate) { super(title, daysLate); }
        @Override
        public double calculateFine() { return daysLate * 1.0; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        
        List<Item> items = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();
            
            switch (type) {
                case "BOOK": items.add(new Book(title, daysLate)); break;
                case "DVD": items.add(new DVD(title, daysLate)); break;
                case "MAGAZINE": items.add(new Magazine(title, daysLate)); break;
            }
        }
        
        double total = 0;
        for (Item item : items) {
            double fine = item.calculateFine();
            total += fine;
            System.out.printf("%s: %.2f\n", item.getTitle(), fine);
        }
        System.out.printf("Total Fines: %.2f\n", total);
        sc.close();
    }
}
