import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LibrarySystem {
    abstract static class LibraryItem {
        protected String title;
        public LibraryItem(String title) { this.title = title; }
        public abstract LocalDate calculateDueDate(LocalDate currentDate);
    }

    static class Book extends LibraryItem {
        public Book(String title) { super(title); }
        @Override
        public LocalDate calculateDueDate(LocalDate currentDate) { return currentDate.plusDays(14); }
    }

    static class DVD extends LibraryItem {
        public DVD(String title) { super(title); }
        @Override
        public LocalDate calculateDueDate(LocalDate currentDate) { return currentDate.plusDays(7); }
    }

    static class Magazine extends LibraryItem {
        public Magazine(String title) { super(title); }
        @Override
        public LocalDate calculateDueDate(LocalDate currentDate) { return currentDate.plusDays(3); }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        int n = Integer.parseInt(sc.nextLine().trim());
        
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        Pattern pattern = Pattern.compile("^(\\w+)\\s+\"(.*)\"$");
        
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            Matcher m = pattern.matcher(line);
            if (m.find()) {
                String type = m.group(1);
                String title = m.group(2);
                
                LibraryItem item = null;
                switch (type) {
                    case "BOOK": item = new Book(title); break;
                    case "DVD": item = new DVD(title); break;
                    case "MAGAZINE": item = new Magazine(title); break;
                }
                
                if (item != null) {
                    System.out.println(title + ": " + item.calculateDueDate(currentDate));
                }
            }
        }
        sc.close();
    }
}
