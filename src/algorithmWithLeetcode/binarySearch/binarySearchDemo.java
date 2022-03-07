package algorithmWithLeetcode.binarySearch;

/**
 * O(LogN)
 * 有序数据上： 广义的有序
 * 减治的算法思想： decrease and conquer 每次减少一半，再治理
 */
public class binarySearchDemo {
    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 4, 4, 6, 6, 9, 10};
        int target = 6;
        int res = findPosition(nums, target);
        System.out.println(res);
    }

    /**
     *  start + 1 < end 相邻的时候退出循环，没有机会重合，这样写无论怎样都不会死循环
     *  退出循环后判断两个数即可。
     *  根据题目具体分析来选择需要的结果
     *  ！！！如果使用start < end 如果数组中有很多重复数据，可能会导致死循环
     *
     *  start + (end - start) / 2
     *
     *  中点情况分情况讨论： 不要叠合
     *  nums[mid] == target
     *  nums[mid] < target
     *  nums[mid] > target
     *
     */

    private static int findPosition(int[] nums, int target) {
        if (nums == null || nums.length < 1 || nums[nums.length - 1] < target || nums[0] > target) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == start) {
            return end;
        }
        return -1;

    }
}
