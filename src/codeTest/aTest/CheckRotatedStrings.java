package codeTest.aTest;

public class CheckRotatedStrings {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "llohe";

        boolean res = check(s1, s2);
        System.out.println(res);
    }

    private static  boolean check(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return true;
        }

        if (s1.length() != s2.length()) {
            return false;
        }


        for (int left = 0, right = s2.length() - 1; left < s1.length(); left++, right--) {
            if (s1.charAt(left) != s2.charAt(right)) {
                return false;
            }

        }
        return true;
    }
}
