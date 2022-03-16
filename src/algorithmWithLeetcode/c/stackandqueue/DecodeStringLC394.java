package algorithmWithLeetcode.c.stackandqueue;

import java.util.Stack;

public class DecodeStringLC394 {
    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        String res = decodeString(s);


    }

    private static String decodeString(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        Stack<Integer> intStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        String res = "";

        int n = 0;
        while (n < s.length()) {
            if (Character.isDigit(s.charAt(n))) {
                int count = 0;
                while (Character.isDigit(s.charAt(n))) {
                    count = count * 10 + s.charAt(n) - '0';
                    n++;
                }
                intStack.push(count);
            } else if (s.charAt(n) == '[') {
                strStack.push(res);
                res = "";
                n++;
            } else if (s.charAt(n) == ']') {
                StringBuilder sb = new StringBuilder(strStack.pop());
                int times = intStack.pop();
                for (int i = 0; i < times; i++) {
                    sb.append(res);
                }
                res = sb.toString();
                n++;
            } else {
                res += s.charAt(n);
                n++;
            }
        }
        System.out.println(res);
        return res;
    }
}
