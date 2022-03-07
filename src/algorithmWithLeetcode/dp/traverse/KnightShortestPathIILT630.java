package algorithmWithLeetcode.dp.traverse;

public class KnightShortestPathIILT630 {
    // 当前的点只能往右边跳。但是对于自顶向下 最终的i和j来说，所有的点都是从左边跳过来的。
    private static int[] X_AXIS = {1, -1, -2, 2};
    private static int[] Y_AXIS = {-2, -2, -1, -1};

    public static void main(String[] args) {
        boolean[][] grid = new boolean[3][4];

        int res = shortestPath2(grid);
        System.out.println(res);
    }

    private static int shortestPath2(boolean[][] grid) {
        if (grid == null || grid.length < 1 || grid[0] == null || grid[0].length < 1) {
            return -1;
        }

        int[][] dp = new int[grid.length][grid[0].length];

        // 求最小值，或者最短的问题，一般先初始为无穷大
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;

        // dp[i][j] 表示当前的点， newX和newY表示当前的dp[i][j]可以从这些[newX][newY]跳过来
        // 为什么先循环列？因为是朝右边走， 先循环行的化，newX可能小于i， 也可能大于i，而i是从小到大的
        for (int j = 0; j < dp[0].length; j++) {
            for (int i = 0; i < dp.length; i++) {
                if (grid[i][j] == true) {
                    continue;
                }
                for (int n = 0; n < 4; n++) {
                    int newX = i + X_AXIS[n];
                    int newY = j + Y_AXIS[n];

                    if (isValid(newX, newY, grid) && dp[newX][newY] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[newX][newY] + 1);
                    }

                }
            }
        }
        if (dp[dp.length - 1][dp[dp.length - 1].length - 1] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    private static boolean isValid(int x, int y, boolean[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }
        if (grid[x][y]) {
            return false;
        }
        return true;
    }


}
