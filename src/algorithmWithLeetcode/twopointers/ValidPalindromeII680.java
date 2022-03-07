package algorithmWithLeetcode.twopointers;

public class ValidPalindromeII680 {
    public static void main(String[] args) {
        String s = "abcdcba";
        boolean res = isPalindrome(s);
        System.out.println(res);
    }

    private static boolean isPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left++;
            right--;
        }
        if(left >= right){
            return true;
        }
        return isValid(left + 1, right, s) || isValid(left, right-1, s);
    }

    private static boolean isValid(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
