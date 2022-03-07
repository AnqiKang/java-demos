package algorithmWithLeetcode.twopointers;

public class ValidPalindrome125 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean res = isPalindrome(s);
        System.out.println(res);
    }

    /**
     * 对于不合规的空格和特殊字符的判断， 一定也是放在while（）里面，否则会出错。
     * while 里面的判断不要放在多，可以单独的封装成一个方法
     * @param s
     * @return
     */
    private static boolean isPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !isValid(s.charAt(left))) {
                left++;
            }
            while (left < right && !isValid(s.charAt(right))) {
                right--;
            }
            if (left < right && !isEqual(s.charAt(left), s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;

    }

    private static boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }

    private static boolean isEqual(char left, char right) {
        return Character.toLowerCase(left) == Character.toLowerCase(right);
    }
}
