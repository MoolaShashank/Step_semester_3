public class PalindromeChecker {
    public static void main(String[] args) {
        String testWord = "madam";
        System.out.println("Iterative: " + (isPalindromeIterative(testWord) ? "Palindrome" : "Not Palindrome") +
                " | Recursive: " + (isPalindromeRecursive(testWord) ? "Palindrome" : "Not Palindrome") +
                " | Array Reversal: " + (isPalindromeArrayReversal(testWord) ? "Palindrome" : "Not Palindrome"));
    }

    public static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) return false;
            left++; right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) return false;
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] arr = text.toCharArray();
        StringBuilder reversed = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            reversed.append(arr[i]);
        }
        return text.equals(reversed.toString());
    }
}
