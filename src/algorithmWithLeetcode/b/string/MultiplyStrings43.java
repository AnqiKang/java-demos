package algorithmWithLeetcode.b.string;

import java.util.Arrays;

public class MultiplyStrings43 {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "45";
        String res = multiply(num1, num2);
        System.out.println(res);

    }

    /**
     * multiply two integer numbers that are represented as strings
     * 大整数乘法可以转换为大整数加法
     * 参照乘法的竖式计算方法，用num1每一位去乘num2，然后将这些值按位相加
     */
    private static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        // 任意两个整数的乘法结果的长度不会超过这两个数本身长度的和
        int len = num1.length() + num2.length();
        int[] res = new int[len];

        /**
         * 每一位nums1[i] * num2 --> res[i + j + 1] += (num1[i]− '0') * (num2[j] - '0')
         *  + 1是因为 在res数组里面也是倒着放入结果的，但是res[0]用于存放最后一个结果的进位。
         *    1 2 3
         *      4 5
         *
         *  res [0,0,0,0,0]
         *
         * 第一轮： num1的每一位 * num2[最后一位]
         *  num1[2] = 3  num2[1] = 5
         *  3 * 5 = res[i + j + 1 = 2 + 1 + 1] = 3 * 5
         *  res [0,0,0,0,5]
         *  num[1] = 2  num2[1] = 5
         *  2 * 5 = res[ 1 + 1 + 1] = 10
         *  res [0,0,0,10,5]
         *  num[0] = 1  num2[1] = 5
         *  1 * 5 = res[2] = 5
         *  res [0,0,5,10,5]
         *
         *  第一轮： num1的每一位 * num2[倒数第二位]
         *  num1[2] = 3  num2[0] = 4
         *  3 * 4 = res[3] + 12
         *  res [0,0,5,22,5]
         *  num1[1] = 2  num2[0] = 4
         *  2 * 4 = res[2] + 8
         *  res [0,0,13,22,5]
         *  num1[0] = 1, num2[0] = 4
         *  1 * 4 = res[1] + 4
         *  res [0,4,13,22,5]
         */
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                res[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        System.out.println(Arrays.toString(res));
        /**
         * 处理进位
         * 倒序处理，
         * res = [0, 4, 13, 22, 15]
         * i = 4 ; res[3] = 22 + 进位数 （15/10 = 1) = 23 ; res[4] = 个位数，5
         *
         * res = [0, 4, 13, 23, 5]
         * i= 3； res[2] = 13 + (23/ 10 = 2) = 15, res[3] = 3
         *
         * res = [0, 4, 15, 3, 5]
         * i = 2; res[1] = 4 + 1, res[2] = 5
         *
         *  res = [0, 5, 5, 3, 5]
         *  i = 1; res[0] = 0 + 0; res[1] = 1
         *  i > 0;
         *
         */
        for (int i = res.length - 1; i > 0; i--) {
            res[i - 1] += res[i] / 10;
            res[i] %= 10;
        }

        System.out.println(Arrays.toString(res));


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0 && sb.toString().length() == 0) {
                continue;
            }
            sb.append(res[i]);
        }


        return sb.toString();
    }
}
