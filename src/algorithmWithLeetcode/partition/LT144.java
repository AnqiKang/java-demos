package algorithmWithLeetcode.partition;

import java.util.Arrays;

public class LT144 {
    public static void main(String[] args) {
        int[] A = {-13, -8, -12, -15, -14, 35, 7, -1, 11, 27, 10, -7, -12, 28, 18};
        reRange(A);
        System.out.println(Arrays.toString(A));
    }

    public static void reRange(int[] A) {
        if (A == null || A.length < 1) {
            return;
        }

        /**
         * partition 左边全是负数，右边全是正数
         * 返回 left ，就是全部负数的个数
         */
        int totalNeg = partition(A, 0, A.length - 1);
        int totalPos = A.length - totalNeg;

        /**
         * left
         * 如果负数多，那么 index 0 应该为负数，partition过后，前半部分都是负数，所以要从index 1 开始交换
         * 如果正数多，那么 index 0 应该为正数， 所以要从index 0 开始交换
         */
        int left = totalNeg > totalPos ? 1 : 0;
        int right = 0;

        /**
         * right
         * left == 1 说明负数多，应该就是 ----+++ --》 - + - + - 这种结构， right 应该从 A.length - 1
         * left == 0 说明正数多，应该就是 ---++++ --》 + - + - + 这种结构，right 应该从 A.length - 2
         * 但这是根据left 来判断是不可以的，因为还要考虑正负数一样多的情况，
         * 上面应该是把一样多的情况归给了left == 0， 但是 left = 0 的情况下 right = A.length - 2了。
         * 而如果一样多， ---+++ left 从0开始，right 应该从 A.length - 1开始
         */
        if (totalPos > totalNeg) {
            right = A.length - 2;
        } else {
            right = A.length - 1;
        }

        /**
         * 根据个数得到了left 和 right
         * 交换位置
         */
        change(A, left, right);
    }

    private static void change(int[] A, int left, int right) {
        while (left < right) {
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left += 2;
            right -= 2;
        }

    }

    private static int partition(int[] A, int left, int right) {
        while (left <= right) {
            while (left <= right && A[left] < 0) {
                left++;
            }
            while (left <= right && A[right] >= 0) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
}
