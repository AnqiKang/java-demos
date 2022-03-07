package algorithmWithLeetcode.dp.traverse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 自底向上：
 * 先计算最底层的数据，找到最短的路径，再向上计算倒数第二层的数据
 */

public class Triangle120V3 {
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
        // dp 动态坐标: 按照原始三角形，制造对应dp坐标
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];

        // 初始化: 自底向上，初始化最底层
        for (int i = 0; i < dp.length; i++) {
            dp[dp.length - 1][i] = triangle.get(triangle.size() - 1).get(i);
        }

        // 方程： 到哪里去？
        // 自底向上，倒数第一层已经初始化好了，从倒数第二层到起点去
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];

    }


}
