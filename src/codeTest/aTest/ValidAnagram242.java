package codeTest.aTest;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram242 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        boolean res = isValidAnagram(s, t);
        System.out.println(res);
    }

    private static boolean isValidAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sToMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            sToMap.put(c, sToMap.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (sToMap.containsKey(c)) {
                sToMap.put(c, sToMap.getOrDefault(c, 0) - 1);
                if (sToMap.get(c) == 0) {
                    sToMap.remove(c);
                }
            } else {
                return false;
            }
        }
        return sToMap.size() == 0;
    }


}
