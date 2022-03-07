package algorithmWithLeetcode.sort;

import java.util.Arrays;

/**
 * 最好最坏的时间复杂度 O(NlogN)
 * 空间复杂度： O(N)
 * 稳定
 * 先局部有序
 */
public class MergeSortDemo {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 4, 5};
        sortInteger(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sortInteger(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }

        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
    }

    private static void mergeSort(int[] nums, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid, temp); // 前半段
        mergeSort(nums, mid + 1, end, temp); // 后半段

        merge(nums, start, mid, end, temp);
    }

    private static void merge(int[] nums, int start, int mid, int end, int[] temp) {
        int leftIndex = start;
        int rightIndex = mid + 1;
        int index = leftIndex;

        while (leftIndex <= mid && rightIndex <= end) {
            if (nums[leftIndex] < nums[rightIndex]) {
                temp[index++] = nums[leftIndex++];
            } else {
                temp[index++] = nums[rightIndex++];

            }
        }
        while (leftIndex <= mid) {
            temp[index++] = nums[leftIndex++];
        }
        while (rightIndex <= end) {
            temp[index++] = nums[rightIndex++];
        }

        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
    }

}
