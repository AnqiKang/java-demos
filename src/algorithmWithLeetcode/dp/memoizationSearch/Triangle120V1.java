package algorithmWithLeetcode.dp.memoizationSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle120V1 {
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

        /**
         * O(2^N)  超时
         * [2] ： x = 0, y = 0
         * [3,4]: x = 1, y = 0, 和 x = 1, y = 1
         * 当 x = 0, y = 0， sum = 0表示的是 当当前点之前的sum是多少。
         */
        return dfs(triangle, 0, 0);


    }

    private static int dfs(List<List<Integer>> triangle, int x, int y) {
        if (x == triangle.size()) {
            return 0;
        }


        int left = dfs(triangle, x + 1, y);
        int right = dfs(triangle, x + 1, y + 1);
        return Math.min(left, right) + triangle.get(x).get(y);
    }


}
