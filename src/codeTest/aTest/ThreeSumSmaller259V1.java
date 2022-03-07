package codeTest.aTest;

import java.util.ArrayList;
import java.util.List;

/**
 * result is right, but Output Limit Exceeded
 * should use Pointers to solve this problem
 */
public class ThreeSumSmaller259V1 {
    public static void main(String[] args) {
        int[] nums = {-2,0,1,3};
        int target = 2;
        int res = threeSumSmaller(nums, target);
        System.out.println(res);

    }

    public static int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        List<List<Integer>> res = new ArrayList<>();

        //Arrays.sort(nums);
        dfs(nums, res, new ArrayList<>(), target, 0, 3, 0);

        System.out.println(res);
        return res.size();
    }

    private static void dfs(int[] nums, List<List<Integer>> res, List<Integer> sub, int target, int amount, int cnt, int index) {
        if (cnt == 0 && amount < target) {
            res.add(new ArrayList<>(sub));
            return;
        }

        if (cnt < 0) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            sub.add(nums[i]);
            dfs(nums, res, sub, target, amount + nums[i], cnt - 1, i + 1);
            sub.remove(sub.size() - 1);

        }


    }
}
