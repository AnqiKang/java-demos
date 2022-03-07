package codeTest.OA.eetainfinra;

public class CountSubarraysLessK {
    public static void main(String[] args) {
        int[] arr = {1, 11, 2, 3, 15};
        int k = 10;
        int res = count(arr, k);
        System.out.println(res);
    }

    private static int count(int[] arr, int k) {
        int n = arr.length;
        int l = 0, r = 0, cnt = 0, sum = arr[0];

        while (r < n) {
            if (sum < k) {
                r++;
                cnt += r - l;
                if (r < n) {
                    sum += arr[r];
                }
            } else {
                sum -= arr[l];
                l++;
            }

        }
        return cnt;
    }

}
