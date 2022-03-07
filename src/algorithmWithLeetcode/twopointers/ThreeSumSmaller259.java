package algorithmWithLeetcode.twopointers;

import java.util.Arrays;

public class ThreeSumSmaller259 {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 3};
        int target = 2;
        int res = threeSumSmaller(nums, target);
        System.out.println(res);
    }

    private static int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < target) {
                    res += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }


}

