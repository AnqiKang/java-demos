package algorithmWithLeetcode.dfs.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = combinationSum(candidates, target);
        System.out.println(res);


    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length < 1) {
            return res;
        }

        Arrays.sort(candidates);
        dfs(candidates, res, new ArrayList<>(), target, 0);
        return res;
    }

    private static void dfs(int[] candidates, List<List<Integer>> res, ArrayList<Integer> sub, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(sub));
            return;
        }
        if (target < 0) {
            return;
        }


        for (int i = index; i < candidates.length; i++) {
            sub.add(candidates[i]);
            dfs(candidates, res, sub, target - candidates[i], i);
            sub.remove(sub.size() - 1);
        }
    }
}
