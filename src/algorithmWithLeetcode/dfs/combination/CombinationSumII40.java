package algorithmWithLeetcode.dfs.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII40 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> res = combinationSum2(candidates, target);
        System.out.println(res);


    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length < 1) {
            return res;
        }

        Arrays.sort(candidates);

        dfs(candidates, res, new ArrayList<>(), target, 0);
        return res;
    }

    private static void dfs(int[] candidates, List<List<Integer>> res, List<Integer> sub, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(sub));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if(i > 0 && candidates[i] == candidates[i -1] && i > index){
                continue;
            }
            sub.add(candidates[i]);
            dfs(candidates, res, sub, target - candidates[i], i + 1);
            sub.remove(sub.size() - 1);
        }
    }

}
