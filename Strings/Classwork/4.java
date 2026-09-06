import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueLetterHunt {
    public static void main(String[] args) {
        String input1 = "swiss";
        String input2 = "aabbcc";
        
        char result1 = findFirstNonRepeatingChar(input1);
        char result2 = findFirstNonRepeatingChar(input2);
        
        System.out.println("Input: " + input1 + " | Output: " + (result1 != '\0' ? "First Non-Repeating Character: '" + result1 + "'" : "No Non-Repeating Character Found"));
        System.out.println("Input: " + input2 + " | Output: " + (result2 != '\0' ? "First Non-Repeating Character: '" + result2 + "'" : "No Non-Repeating Character Found"));
    }

    public static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();
        
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return '\0'; // Return null character if none found
    }
}
