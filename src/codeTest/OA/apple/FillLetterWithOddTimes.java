package codeTest.OA.apple;

import java.util.Arrays;

public class FillLetterWithOddTimes {
    public static void main(String[] args) {
        int N = 7;
        String res =  fill(N);
        System.out.println(res);


    }

    private static String fill(int n) {
        if (n < 1) {
            return "";
        }
        char[] chars = new char[n];
        Arrays.fill(chars, 'a');

        if (n % 2 == 1) {
            chars[0] = 'b';
        }
        return new String(chars);
    }

}
