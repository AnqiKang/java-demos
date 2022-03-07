package algorithmWithLeetcode.dfs.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets78 {
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
        dfs(nums, res, new ArrayList<>(), 0);
        return res;
    }

    private static void dfs(int[] nums, List<List<Integer>> res, ArrayList<Integer> sub, int startIndex) {
        res.add(new ArrayList<>(sub));

        for (int i = startIndex; i < nums.length; i++) {
            sub.add(nums[i]);
            dfs(nums, res, sub, i + 1);
            sub.remove(sub.size() - 1);

        }

    }
}
