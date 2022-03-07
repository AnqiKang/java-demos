package algorithmWithLeetcode.dp.memoizationSearch;

import java.util.*;

/**
 * 用HashMap实现记忆化搜索
 * O(N^2)
 * why?
 * 1: 之前，没有任何的if语句阻止递归，现在通过查询HashMap来阻止
 * 2： 看每个x y会被调用几次，。
 */
public class Triangle120V2 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>(4);
        triangle.add(new ArrayList<>(Arrays.asList(2)));
        triangle.add(new ArrayList<>(Arrays.asList(3, 4)));
        triangle.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
        triangle.add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));
        // System.out.println(triangle);
        int res = minimumTotal(triangle);
        System.out.println(res);

    }

    private static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() < 1) {
            return -1;
        }


        Map<Integer, Integer> map = new HashMap<>();

        return dfs(triangle, 0, 0, map);


    }

    private static int dfs(List<List<Integer>> triangle, int x, int y, Map<Integer, Integer> map) {
        if (x == triangle.size()) {
            return 0;
        }

        int hashCode = x * triangle.size() + y;
        if (map.containsKey(hashCode)) {
            return map.get(hashCode);
        }

        int left = dfs(triangle, x + 1, y, map);
        int right = dfs(triangle, x + 1, y + 1, map);
        map.put(hashCode,Math.min(left, right) + triangle.get(x).get(y));
        return map.get(hashCode);


    }


}
