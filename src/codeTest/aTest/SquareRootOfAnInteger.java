package codeTest.aTest;

/**
 * Find the Square root of an integer
 * – start with O(n) and optimize the solution as much as you can till O(Log n)
 * -- binary search
 */
public class SquareRootOfAnInteger {
    public static void main(String[] args) {
        int x = 10;
        int res = floorSqrt(x);
        System.out.println(res);

    }

    private static int floorSqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long start = 1;
        long end = x;

        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (end * end > x) {
            return (int) start;
        }
        return (int) end;


    }
}
