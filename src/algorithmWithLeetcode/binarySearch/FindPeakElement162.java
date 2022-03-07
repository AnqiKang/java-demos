package algorithmWithLeetcode.binarySearch;

public class FindPeakElement162 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int res = findPeakElement(nums);
        System.out.println(res);
    }

    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int res = binarySearch(nums, 0, nums.length - 1);
        return res;

    }

    private static int binarySearch(int[] nums, int left, int right) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[left] > nums[right] ? left : right;
    }
}
