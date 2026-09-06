import java.util.HashMap;

public class SubarraySumK {
    public static void main(String[] args) {
        int[] nums = {1, -1, 0};
        System.out.println(subarraySum(nums, 0));
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        
        // Base case: a prefix sum of 0 occurs exactly once before traversal
        prefixSumMap.put(0, 1);
        
        for (int num : nums) {
            currentSum += num;
            
            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }
            
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}
