package algorithmWithLeetcode.recursion;

public class RecursionBinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4, 5, 5};
        int target = 4;
        int res = binarySearch(nums, 0, nums.length - 1, target);
        System.out.println(res);
    }

    private static int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, end, target);
        }
        return binarySearch(nums, start, mid - 1, target);
    }
}
