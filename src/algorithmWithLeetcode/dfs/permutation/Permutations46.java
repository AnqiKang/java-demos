package algorithmWithLeetcode.dfs.permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = permutation(nums);
        System.out.println(res);
    }

    private static List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        boolean[] visited = new boolean[nums.length];

        dfs(nums, res, visited, new ArrayList<>());
        return res;
    }

    private static void dfs(int[] nums, List<List<Integer>> res, boolean[] visited, ArrayList<Integer> per) {
        if (per.size() == nums.length) {
            res.add(new ArrayList<>(per));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            per.add(nums[i]);
            visited[i] = true;
            dfs(nums, res, visited, per);
            per.remove(per.size() - 1);
            visited[i] = false;
        }
    }
}
