package algorithmWithLeetcode.dp.backpack;

public class BackpackLT92V2 {
    /**
     * dp[i][j] 记录最优值； 表示当前i个数里挑出若干数的 sum <= j 的最大和为多少
     */
    public static void main(String[] args) {
        int[] nums = {3, 4, 8, 5};
        int size = 10;
        int res = backPack(size, nums);
        System.out.println(res);

    }

    private static int backPack(int size, int[] nums) {
        if (nums.length < 0 || nums == null) {
            return Integer.MIN_VALUE;
        }
        int[][] dp = new int[nums.length + 1][size + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= size; j++) {
                if (nums[i - 1] <= j) { // 如果 数组里 前 i-1个数小于等于当前sum。
                    // 1；dp[i-1][j] 表示 前i-1个数里面，凑出来的小于等于j的数最大是多少？ 当前的i不计算在内
                    // 2： 当前第i个数也参与， num[i-1]就是当前第i个数， 我前面的 i-1个数里，需要凑出一个 加上当前第i个数的值之后最接近j的数，
                    // 例如 j = 7， nums[i-1] = 2, 那么我前面的凑出的如果是5， 就刚好 5 + 2 = 7，
                    // 如果前面凑出的最大为4， 那么 4+2=6， 表示最接近7 的只能是6
                    // dp[i - 1][j - nums[i - 1]] + nums[i - 1] 加起来尽可能的等于j
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[nums.length][size];
    }
}
