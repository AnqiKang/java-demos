package algorithmWithLeetcode.dp.traverse;

public class UglyNumberII264 {
    public static void main(String[] args) {
        int n = 10;
        int res = UglyNumber(n);
        System.out.println(res);
    }

    private static int UglyNumber(int n) {
        if (n < 1) {
            return -1;
        }
        int[] dp = new int[n];
        dp[0] = 1;

        int pointer2 = 0;
        int pointer3 = 0;
        int pointer5 = 0;

        for (int i = 1; i < n; i++) {
            // i 表示当前下标，dp[i] 表示当前下标的ugly number
            // 对于当前下标来说，分别 * 2， 3， 5， 然后取最小的数
            // i = 1， dp[0] 都是1，* 2, 3, 5 选择最小的结果作为 dp[1] 的填充数  2
            // i = 2， dp[pointer2] = 2 * 2 = 4, dp[pointer1] = 1 * 3, dp[pointer5] = 1 * 5, 最小数 dp[2] = 3
            dp[i] = Math.min(Math.min(dp[pointer2] * 2, dp[pointer3] * 3), dp[pointer5] * 5);

            // 填充后，移动对应指针
            // 并不是并列关系，而是每一个都要查看一下，去重复，例如 i = 5， 填充了6。 2* 3 = 6， 3 * 2 也是6， 两个pointer都会+1的
            if (dp[i] == dp[pointer2] * 2) {
                pointer2++;
            }
            if (dp[i] == dp[pointer3] * 3) {
                pointer2++;
            }
            if (dp[i] == dp[pointer5] * 5) {
                pointer2++;
            }
        }
        return dp[n - 1];
    }
}
