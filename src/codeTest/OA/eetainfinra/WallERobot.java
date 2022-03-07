package codeTest.OA.eetainfinra;

public class WallERobot {
    public static void main(String[] args) {
        int p = 3;
        int a_count = 8;
        int[] a = {0, 1, 1, 1, 1, 0, 0, 1};
        int res = detect(p, a_count, a);
        System.out.println(res);
    }

    private static int detect(int p, int a_count, int[] a) {
        if (a == null || a.length < 1) {
            return 0;
        }
        int index = p - 1;
        int cnt = 0;

        int left = index - 1;
        int right = index + 1;

        for (; left >= 0 && right < a_count; left--, right++) {
            if (a[left] == 1 && a[right] == 1) {
                cnt += 2;
            }
        }

        while (left < 0 && right < a_count) {
            if (a[right] == 1) {
                cnt++;
            }
            right++;
        }

        while (right >= a_count && left >= 0) {
            if (a[left] == 1) {
               cnt++;
            }
            left--;
        }
        return a[index] == 1 ? cnt + 1 : cnt;
    }


}
