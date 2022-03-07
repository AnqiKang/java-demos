package codeTest.aTest;

public class RecursiveFactorial {
    // 阶乘
    public static void main(String[] args) {
        int res = helper(6);
        System.out.println(res);


    }

    private static int helper(int num){
        if(num <= 1){
            return num;
        }
        return num * helper(num -1);
    }
}
