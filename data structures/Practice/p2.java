import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        String reversed = new StringBuilder(word).reverse().toString();

        System.out.println(reversed);
        if (word.equals(reversed)) {
            System.out.println("palindrome");
        } else {
            System.out.println("not a palindrome");
        }
    }
}
