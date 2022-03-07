package algorithmWithLeetcode.partition;

import java.util.Arrays;

public class SortColor75 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 0, 2};
//        countSort(nums);
//        System.out.println(Arrays.toString(nums));
        int left = quickSort(nums, 1, 0, nums.length - 1);
        quickSort(nums, 2, left, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * partition
     * 2 次快速分区
     */
    private static int quickSort(int[] nums, int pivot, int left, int right) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] >= pivot) {
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
        return left;
    }

    /**
     * count sort
     * O(N)
     */
    private static void countSort(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }

        int[] cnt = new int[3];
        for (int num : nums) {
            cnt[num]++;
        }
        System.out.println(Arrays.toString(cnt));

        int index = 0;
        for (int i = 0; i < cnt.length; i++) {
            int curColor = cnt[i];
            while (curColor > 0) {
                nums[index++] = i;
                curColor--;
            }

        }
    }


}
