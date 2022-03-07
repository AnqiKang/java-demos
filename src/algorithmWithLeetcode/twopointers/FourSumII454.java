package algorithmWithLeetcode.twopointers;

import java.util.HashMap;
import java.util.Map;

public class FourSumII454 {
    public static void main(String[] args) {
        int[] num1 = {1, 2};
        int[] num2 = {-2, -1};
        int[] num3 = {-1, 2};
        int[] num4 = {0, 2};
        int res = fourSumCount(num1, num2, num3, num4);
        System.out.println(res);
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        // 求出 前两个数组的 sum 和 次数
        for (Integer a : nums1) {
            for (Integer b : nums2) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        // -sum 就是当前的目标
        int cnt = 0;
        for (Integer c : nums3) {
            for (Integer d : nums4) {
                int sum = c + d;
                cnt += map.getOrDefault(-sum, 0);
            }
        }
        return cnt;
    }

}
