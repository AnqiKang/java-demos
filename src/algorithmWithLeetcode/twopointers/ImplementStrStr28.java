package algorithmWithLeetcode.twopointers;

public class ImplementStrStr28 {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";

        int res = strStr(haystack, needle);
        System.out.println(res);
    }

    /**
     * 问题， 使用了substring，， 可以多加一个for循环来一一判断
     * 并且每次substring之后都会产生一个新的字符串， 造成空间上的浪费
     * @param haystack
     * @param needle
     * @return
     */
    private static int strStr(String haystack, String needle) {
        if (haystack == null && needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || needle == null || haystack.length() < needle.length() || haystack.length() < 1) {
            return -1;
        }

        char firstLetter = needle.charAt(0);
        int len = needle.length();

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == firstLetter) {
                if (((i + len) <= haystack.length()) && (haystack.substring(i, i + len).equals(needle))) {
                    return i;
                }
            }
        }
        return -1;
    }


}
