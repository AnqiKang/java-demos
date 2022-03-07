package algorithmWithLeetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = ThreeSum(nums);
        System.out.println(res);
    }

    private static List<List<Integer>> ThreeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);

        /**
         *  O(NLogN + N ^2)
         *  sort O(NLogN)
         *  一次 2Sum O(N) 进行了N次 就是O(N^N)
         *
         *  3 sum,
         *  1： 确定target： 遍历nums，当前的i就为 -target，
         *      因为确定的是target从 i = 0 开始i 的范围。
         *      3 sum 最终为 3 个数，所以要确保当前的i后面至少还有两个数， 这样才是 3 sum
         *      i 的范围 就是 0 - nums.length - 2
         *  2: 确定了 target 之后，根据 2 sum，从num 的剩下的范围里寻找这个目标值
         *  3：去重： 无论是在循环i的时候，还是 2 sum 里面寻找 left 和 right 的时候
         *      如果相邻的两个数相同，就可以跳过了。
         */
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            twoSum(nums, left, right, target, res);
        }
        return res;
    }

    private static void twoSum(int[] nums, int left, int right, int target, List<List<Integer>> res) {
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                res.add(Arrays.asList(-target, nums[left], nums[right]));
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
    }
}
