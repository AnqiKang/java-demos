package codeTest.OA.eetainfinra;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateAndKeepSameOrder {
    public static void main(String[] args) {
        String input = "reekofbeet";
        String output = modifiedString(input);
        System.out.println(output);
    }

    private static String modifiedString(String input) {
        if (input == null || input.length() < 2) {
            return input;
        }

        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (set.contains(c)) {
                continue;
            }
            set.add(c);
            sb.append(c);
        }
        return sb.toString();

    }
}
