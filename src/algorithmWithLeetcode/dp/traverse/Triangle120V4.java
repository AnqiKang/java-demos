package algorithmWithLeetcode.dp.traverse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 自顶向下：
 * 先计算最底顶层的数据，找到最短的路径，再向下计算到最后一层
 */

public class Triangle120V4 {
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
        int[][] dp = new int[triangle.size()][triangle.size()];


        // 初始化: 自顶向下，初始化最顶层数据 从0，0 到 i， j的最短路径
        // 同时还要初始化没有左上角和右上角的点，就是边缘值，这些点只能从一个方向过来。并不参与大小的比较。
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }


        // 方程： 到哪里去？
        // 自顶向下，第一层数据已经有了，向下计算下一层
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 1; j < triangle.get(i).size() - 1; j++) { // 因为 j=0 和 j = i - 1的整条边都被初始化过了 （垂直和斜边）
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            ans = Math.min(ans, dp[dp.length - 1][i]);
        }
        return ans;


    }


}
