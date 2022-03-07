package codeTest.aTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 11, 15};
        int[] res = twoSum2(nums, 9);
        System.out.println(Arrays.toString(res));


    }

    /**
     * O(N)
     *
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum2(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length < 1) {
            return res;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[1] = i;
                res[0] = map.get(target - nums[i]);
                return res;
            }
            map.put(nums[i],i);
        }
        return res;
    }


    /**
     * O(n^2)
     *
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[]{-1, -1};
        }
        int[] res = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (target - curNum == nums[j]) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;

    }
}
