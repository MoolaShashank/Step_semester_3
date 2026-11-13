import java.util.Arrays;

public class LibraryBookShelf {

    public static void shelf(int[] books) {
        // Start from the second book (index 1) onwards
        for (int i = 1; i < books.length; i++) {
            int currentBook = books[i];
            int j = i - 1;

            // Move every bigger book on its left one place to the right
            while (j >= 0 && books[j] > currentBook) {
                books[j + 1] = books[j];
                j--;
            }

            // Place the new book into the gap
            books[j + 1] = currentBook;

            System.out.println("After placing " + currentBook + ": " + Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        // Sample Input
        int[] sampleBooks = {30, 10, 40, 20};
        shelf(sampleBooks);
        System.out.println();

        // Custom Test Input
        int[] customBooks = {50, 25, 45, 15, 35};
        shelf(customBooks);
    }
}
