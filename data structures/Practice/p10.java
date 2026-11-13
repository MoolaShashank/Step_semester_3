import java.util.Arrays;

public class RemoveDuplicatesInPlace {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int writeIdx = 1;

        for (int readIdx = 1; readIdx < nums.length; readIdx++) {
            if (nums[readIdx] != nums[writeIdx - 1]) {
                nums[writeIdx] = nums[readIdx];
                writeIdx++;
            }
        }
        return writeIdx;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        int k = removeDuplicates(nums);
        System.out.println("length = " + k + ", nums[0.." + (k - 1) + "] = " + Arrays.toString(Arrays.copyOf(nums, k)));
    }
}
