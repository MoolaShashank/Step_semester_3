import java.util.Arrays;

public class ArrayRotator {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(rotateArray(nums, 3)));
    }

    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        
        k = k % nums.length;
        int[] newArray = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            newArray[(i + k) % nums.length] = nums[i];
        }
        
        return newArray;
    }
}
