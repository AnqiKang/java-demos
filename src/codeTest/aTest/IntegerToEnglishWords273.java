package codeTest.aTest;

public class IntegerToEnglishWords273 {
    public static void main(String[] args) {
        int num = 1234567891;
        String words = numberToWords(num);
        System.out.println(words);
    }

    private final static String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final static String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final static String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    private static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int i = 0;
        String words = "";

        while (num > 0) {
            if (num % 1000 != 0) { // 三位数一个量级，余数不为0代表当前的量级有数， i控制量级。 第一个三位，无量级，第二个三位Thousand， 第三个量级Million。。。
                words = helper(num % 1000) +THOUSANDS[i] + " " + words; // helper是三位一个量级里的内部的转换，
            }
            num /= 1000; // 每处理完一个量级之后，num去掉三位，i++，进入下一个量级
            i++;
        }

        return words.trim();
    }

    private static String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return LESS_THAN_20[num] + " ";
        } else if (num < 100)
            return TENS[num / 10] + " " + helper(num % 10);
        else
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }
}
