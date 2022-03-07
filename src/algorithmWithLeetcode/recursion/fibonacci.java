package algorithmWithLeetcode.recursion;

public class fibonacci {
    public static void main(String[] args) {
        int res = fib(10);
        System.out.println(res);

    }

    private static int fib(int n) {
//        if (n == 0 || n == 1) {
//            return 0;
//        }
//        if (n == 2) {
//            return 1;
//        }
        if (n <= 2) {
            return n - 1;
        }

        return fib(n - 1) + fib(n - 2);
    }
}
