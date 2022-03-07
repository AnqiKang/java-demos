package algorithmWithLeetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum18 {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        Arrays.sort(nums);
        List<List<Integer>> res = fourSum(nums, 0);
        System.out.println(res);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int a = nums[i];
            threeSum(nums, i + 1, target - a, a, res);
        }
        return res;
    }

    private static void threeSum(int[] nums, int left, int target, int a, List<List<Integer>> res) {
        for (int i = left; i < nums.length - 2; i++) {
            if (i > left && nums[i] == nums[i - 1]) {
                continue;
            }

            int b = nums[i];
            twoSum(nums, i + 1, target - b, a, b, res);
        }
    }

    private static void twoSum(int[] nums, int left, int target, int a, int b, List<List<Integer>> res) {
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                res.add(Arrays.asList(a, b, nums[left], nums[right]));
                left++;
                right--;
                while (left > 0 && left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (right < nums.length - 1 && left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
