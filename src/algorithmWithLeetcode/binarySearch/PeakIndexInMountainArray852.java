package algorithmWithLeetcode.binarySearch;

public class PeakIndexInMountainArray852 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 6, 3};
        int peek = peakIndexInMountainArray(arr);
        System.out.println(peek);

    }

    public static int peakIndexInMountainArray(int[] arr) {
        if (arr == null || arr.length < 1) {
            return -1;
        }

        int peek = binarySearch(arr, 0, arr.length - 1);
        return peek;
    }

    /**
     * 为什么 mid + 1 和mid - 1 不会越界？
     * 因为while循环的退出条件是 left + 1 < right
     * 所以 left < mid + 1 < right
     */
    private static int binarySearch(int[] arr, int left, int right) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                left = mid;
            } else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                right = mid;
            } else if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }

        }
        // 防止数据 只有上升趋势或者下降趋势
        return Math.max(arr[left], arr[right]);
    }

    /**
     * method 2:
     */
    private static int binarySearch2(int[] arr, int left, int right) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return Math.max(arr[left], arr[right]);
    }


}
