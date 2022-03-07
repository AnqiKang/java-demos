package algorithmWithLeetcode.binarySearch;

public class FindMinimumInRotatedSortedArray153 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 1};
        int res = findMin(nums);
        System.out.println(res);
    }

    public static int findMin(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int min = partition(nums, 0, nums.length - 1);
        return min;
    }

    private static int partition(int[] nums, int left, int right) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] > nums[right] && nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }

    /**
     * 其实只根据 mid 和 end 就可以比较出 趋势了
     * 画图：
     * 如果 mid 大于 right 说明答案只能在右边
     * 如果 mid 小于 right 说明答案只能在左边
     */
    private static int partition2(int[] nums, int left, int right) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
