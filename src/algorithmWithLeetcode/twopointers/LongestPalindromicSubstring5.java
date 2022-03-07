package algorithmWithLeetcode.twopointers;

public class LongestPalindromicSubstring5 {
    public static void main(String[] args) {
        String s = "babad";
        String res = findLongestPalindromicSubstring3(s);
        System.out.println(res);
    }

    /**
     * method 1 - o（n^ 3)
     * 但其实这里已经存在了一点优化了，就是如果当前长度的最外层left 和 right 不满足条件时，就退出当前len的下面操作了
     * 因为当len -- 时，还会遍历到的。
     * 比如 babad
     * len = 5， left = 0； right = 4； left 和right 字母不相同， 在这里， i++ = 1， i + len 5 就超出了string的长度范围，直接退出下面的遍历了。
     * 直接返回到len-- 那一层
     * 存在问题： 除了复杂度，在判断是否是回文串的时候，while， 应该把它单独的包装成一个函数
     *
     * @param s
     * @return
     */
    private static String findLongestPalindromicSubstring1(String s) {
        if (s == null || s.length() < 2) {
            return "";
        }
        for (int len = s.length(); len >= 0; len--) { // 控制总长度，因为如果长度为5时，找不到，那就只能找长度为4的。因为5已经不可能了，所以 --
            for (int i = 0; i + len <= s.length(); i++) { // i从第一位开始，因为有总长度的控制，所以是 i+len小于总长度， 并且i不断向后移动
                int l = i, r = i + len - 1;  // 左右指针，left = i， right 同样受len的控制。并且index 从0开始 所以 - 1
                while (l < r && s.charAt(l) == s.charAt(r)) { // 确定好了当前的左右指针，如果左边=右边，向中间移动，继续比较。
                    l++;
                    r--;
                }
                if (l >= r) { // 如果可以走到这里，说明至少是有一个满足条件的string了。
                    return s.substring(i, i + len); // substring 前包后不包
                }
            }
        }
        return "";
    }

    /**
     * method 2 - o（n^ 3)
     * coding style
     */
    private static String findLongestPalindromicSubstring2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        for (int len = s.length(); len >= 0; len--) {
            for (int i = 0; i + len <= s.length(); i++) {
                int left = i;
                int right = i + len - 1;
                if (isPalindrome(left, right, s)) {
                    return s.substring(left, left + len);
                }
            }
        }
        return "";
    }

    private static boolean isPalindrome(int left, int right, String s) {
        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        return left >= right;
    }

    /**
     * method 3 - o (n ^ 2)
     * 想要优化，先看之前的方法里有什么东西是被浪费的
     * 对于 abcba 判断是不是回文串的时候，其实对bcb是不是回文串又判断了一次
     * 所以可以从中心点向外出发进行比较。
     * 一共有多少个中轴线呢？
     * n 个： 奇数长度的回文串中心点
     * n- 1个 偶数
     */
    private static String findLongestPalindromicSubstring3(String s) {
        if (s == null) {
            return null;
        }
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            // 从i=0开始的，意思是当前的中心线先为0； 假设回文串为基数，所以左右都为 i
            String oddPalindrome = getPalindromeFrom(s, i, i);
            if (longest.length() < oddPalindrome.length()) {
                longest = oddPalindrome;
            }

            // 从i=0开始的，意思是当前的中心线先为0； 假设回文串为偶数，所以左i，右i+1
            String evenPalindrome = getPalindromeFrom(s, i, i + 1);
            if (longest.length() < evenPalindrome.length()) {
                longest = evenPalindrome;
            }
        }
        return longest;
    }

    // 得到以当前中心线左右字母的最长回文串。从中心往两边走
    private static String getPalindromeFrom(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    /**
     * method 4 - 动态规划
     * 基于method1 的优化
     */
}
