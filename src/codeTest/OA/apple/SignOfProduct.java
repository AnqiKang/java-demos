package codeTest.OA.apple;

/**
 * 2019-11-05 --2
 */
public class SignOfProduct {
    public static void main(String[] args) {
        int[] A = {1, 22, 3, -5, 0};
        int res = helper(A);
        System.out.println(res);

    }

    private static int helper(int[] a) {
        if (a == null || a.length < 1) {
            return 0;
        }
        int negCnt = 0;
        for (int n : a) {
            if (n == 0) {
                return 0;
            } else if (n < 0) {
                negCnt++;
            }
        }
        return negCnt % 2 == 0 ? 1 : -1;
    }
}
