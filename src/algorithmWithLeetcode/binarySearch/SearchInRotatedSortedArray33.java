package algorithmWithLeetcode.binarySearch;

public class SearchInRotatedSortedArray33 {
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 2;
        int res = search(nums, target);
        System.out.println(res);
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int min = findMin(nums, target, 0, nums.length - 1);
        System.out.println(min);

        if (nums[nums.length - 1] < target) {
            return binarySearch(nums, target, 0, min - 1);
        } else {
            return binarySearch(nums, target, min, nums.length - 1);
        }
    }

    private static int binarySearch(int[] nums, int target, int left, int right) {
        if(right < 0){
            right = left;
        }
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }

    private static int findMin(int[] nums, int target, int left, int right) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[left] < nums[right] ? left : right;

    }
}
