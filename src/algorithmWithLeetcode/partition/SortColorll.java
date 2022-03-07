package algorithmWithLeetcode.partition;

import java.util.Arrays;

/**
 * 如果有k种颜色
 * 正常的快速排序 O（NLogN）
 * 这个题目要求： O（NLogK）
 * 通常来说 N是数组的长度
 * K是颜色的个数
 * 所以正常情况下 K <= N
 * <p>
 * 类似与快速排序，在一个区间上对K种颜色的元素进行排序
 */
public class SortColorll {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 1, 4};
        sort(nums);
        System.out.println(Arrays.toString(nums));

    }

    private static void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        partition(nums, 0, nums.length - 1, 0, nums.length - 1);
    }

    private static void partition(int[] nums, int from, int to, int idxLeft, int idxRight) {
        if (from == to) {
            return;
        }
        int mid = (from + to) / 2;
        int left = idxLeft;
        int right = idxRight;
        while (left <= right) {
            while (left <= right && nums[left] <= mid) {
                left++;
            }
            while (left <= right && nums[right] > mid) {
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

        partition(nums, from, mid, idxLeft, right);
        partition(nums, mid + 1, to, left, idxRight);
    }


}
