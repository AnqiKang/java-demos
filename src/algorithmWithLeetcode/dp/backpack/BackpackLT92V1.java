package algorithmWithLeetcode.dp.backpack;

public class BackpackLT92V1 {
    /**
     * true / false 表示
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
        // dp[i][j] 表示前i个数里，能否挑出若干数，他们的和为 j
        // 需要记录前n个数 ， 那么第n个数的坐标就是 nums[n -1]
        // 但是前n个数里，有前0个，前1个，前2个 。。。 前n ， 那么一共有 n+1个数. 多开的这个位置表示前0个数
        boolean[][] dp = new boolean[nums.length + 1][size + 1];

        // 初始化： 前0个数里可以凑出和为0
        dp[0][0] = true;

        // i: 即表示行数，也表示第 几 个数，
        for (int i = 1; i <= nums.length; i++) {
            // j 表示 sum,  范围从 0  - 背包的size
            for (int j = 0; j <= size; j++) {
                if (j >= nums[i - 1]) {
                    // 如果当前 i个数的sum 比 前 i -1 个数的sum 还大，或者相等，相等时就直接等于之前的状态，
                    // 大于时可以看一下差多少， 如果差值出现过，就也可以凑出当前的sum。
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j]; // 如果当前的i个数的sum 比 nums里面的第i个数小，那么看看i-1的sum 如果可以满足，这里更能满足
                }
            }
        }
        for(int i = size; i >= 0; i--){
            // dp 最后一层，倒序遍历，第一个为true的位置，地方，就是最接近于size的地方。
            if(dp[nums.length][i]){
                return i;
            }
        }
        return -1;
    }
}
