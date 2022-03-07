package algorithmWithLeetcode.sort;

import java.util.Arrays;

/**
 * 平均时间复杂度 O(NlogN)
 * 最坏情况： O(N^2), 已经排好序的情况
 * in place ： O(1),
 * 不稳定
 * 先整体有序
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 2, 4, 6, 3};
        sortInteger(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sortInteger(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }

        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int pivot = nums[start + (end - start)/ 2];

        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
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

        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }
}
