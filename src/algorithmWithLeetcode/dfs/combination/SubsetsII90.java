package algorithmWithLeetcode.dfs.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII90 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        List<List<Integer>> res = subset(nums);
        System.out.println(res);
    }

    private static List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null) {
            return res;
        }

        Arrays.sort(nums);
        dfs(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }

    private static void dfs(int[] nums, List<List<Integer>> res, ArrayList<Integer> sub, int startIndex) {
        res.add(new ArrayList<>(sub));

        for (int i = startIndex; i < nums.length; i++) {
            // 去重： 如果当前数与前一个数是一样的， nums[i] == nums[i - 1]
            // 并且前面的这个数没有被挑选过，i > startIndex；
            // 如果i-1已经被挑选过了，那么下一个index 就是 i - 1 + 1 就是 i。
            // 所以要判断一下此时此刻的i是不是不等于startIndex， 上一个数挑的是startIndex- 1，
            // 当前挑的是i。因为i至少是大于等于startIndex + 1
            // 所以startIndex- 1 和 startIndex + 1之间至少有一个数。所以i-1这个数肯定没有被放到sub里面。
            if (i > 0 && nums[i] == nums[i - 1] && i > startIndex) {
                continue;
            }
            sub.add(nums[i]);
            dfs(nums, res, sub, i + 1);
            sub.remove(sub.size() - 1);
        }
    }
}
