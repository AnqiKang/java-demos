package algorithmWithLeetcode.binarySearch;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements658 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 10, 10, 10};
        int k = 1;
        int x = 9;
        List<Integer> res = findClosestElements(arr, k, x);
        System.out.println(res);
    }

    /**
     * 在这个题目里，最终求的只是原数组满足条件的一段，保持有序
     */
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (arr == null || arr.length < 1) {
            return res;
        }
        int left = 0;
        int right = arr.length - 1;
        
        while (right - left >= k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }

        for (int i = left; i <= right; i++) {
            res.add(arr[i]);
        }

        return res;
    }


}
