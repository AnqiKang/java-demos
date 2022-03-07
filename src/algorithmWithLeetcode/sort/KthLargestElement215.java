package algorithmWithLeetcode.sort;

import java.util.Arrays;

public class KthLargestElement215 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int res = findKthLargest(nums, k);
        System.out.println(Arrays.toString(nums));
        System.out.println(res);

    }

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < 1 || nums.length < k) {
            return -1;
        }

        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private static int quickSelect(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[start];
        }
        int left = start;
        int right = end;
        int pivot = nums[(start + end) / 2];

        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        if (start + k - 1 <= right) {
            return quickSelect(nums, start, right, k);
        } else if (start + k - 1 >= left) {
            return quickSelect(nums, left, end, k - (left - start));
        } else {
            return nums[right + 1];
        }
    }
}
