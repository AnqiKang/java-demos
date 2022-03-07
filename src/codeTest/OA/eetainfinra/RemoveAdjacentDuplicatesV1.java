package codeTest.OA.eetainfinra;

import java.util.*;

public class RemoveAdjacentDuplicatesV1 {
    public static void main(String[] args) {
        String s = "bdcccbdee";
        String res = removeDuplicates(s);

        // bdbd
        System.out.println(res);

    }

    private static String removeDuplicates(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        StringBuffer ans = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        stack.add(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            if (stack.isEmpty() || stack.peek() != current) {
                stack.push(current);
            } else {
                stack.pop();
                while (i < s.length() && s.charAt(i) == current) {
                    i++;
                }
                i--;
            }
            //System.out.println(stack);
        }
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}
