package algorithmWithLeetcode.binarySearch;
import java.util.Arrays;

public class FindKClosestElementsLT460 {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 10, 20};
        int target = 21;
        int k = 4;
        int[] res = kClosestNumbers(arr, target, k);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 在这个题目里，找的是满足条件的差的按大小顺序排列的k个数
     */
    public static int[] kClosestNumbers(int[] A, int target, int k) {
        if (A == null || A.length < 1) {
            return null;
        }

        int[] res = new int[k];
        /**
         * 大于等于 k 的最左index， 要注意的是，如果没有满足条件的那就说明 所有的数都小于target， 那么要返回数组的长度。
         * 如果找的是 小于等于target 的最右index，那么没有满足条件的说明 所有的数都是大与target的， 返回-1
         */
        int right = partition(A, target, 0, A.length - 1);
        int left = right - 1;
        for (int i = 0; i < k; i++) {
            if (isLeftCloser(A, target, left, right)) {
                res[i] = A[left--];
            } else {
                res[i] = A[right++];
            }
        }
        return res;
    }

    private static boolean isLeftCloser(int[] A, int target, int left, int right) {
        if (left < 0) {
            return false;
        }
        if (right >= A.length) {
            return true;
        }
        return target - A[left] <= A[right] - target;
    }


    private static int partition(int[] A, int target, int left, int right) {
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (A[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (A[left] >= target) {
            return left;
        }
        if (A[right] >= target) {
            return right;
        }
        return A.length;
    }


}
