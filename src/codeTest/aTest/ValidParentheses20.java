package codeTest.aTest;

import java.util.Stack;

public class ValidParentheses20 {
    public static void main(String[] args) {
        String s = "()";
        boolean res = isValid(s);
        System.out.println(res);
    }

    private static boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                // 这里的顺序不能改变，会发生短路效应。如果先pop出来了，并且不相等，
                // 然后再去看是不是empty时，stack已经是empty的了。所以只会return false
                return false;
            }
        }

        return stack.isEmpty();
    }


}
