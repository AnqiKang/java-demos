package codeTest.aTest;

public class fibonacci {
    public static void main(String[] args) {

        // 0,1,1,2,3,5
        int res = fibHelper(10);
        System.out.println(res);
    }

    private static int fibHelper(int num) {
        if (num <= 2) {
            return num -1;
        }

        return fibHelper(num - 1) + fibHelper(num - 2);

    }
}
