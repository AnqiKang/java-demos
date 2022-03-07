package algorithmWithLeetcode.twopointers;

import java.util.Arrays;

public class ThreeSumClosest16 {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 2, 1};
        int target = 1;
        int res = threeSumClosest(nums, target);
        System.out.println(res);

    }

    private static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }

        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);

        // 优化： if diff == 0, 已经最接近了，break traverse
        for (int i = 0; i < nums.length - 2 && diff != 0; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(diff)) { // 如果当前的sum 到target的距离比diff小， 说明当前的sum 更符合条件
                    diff = target-sum;
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        return target-diff;  // 返回的是最接近target的sum， 而不是最接近的值
    }
}
