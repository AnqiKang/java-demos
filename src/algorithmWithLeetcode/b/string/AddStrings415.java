package algorithmWithLeetcode.b.string;

/**
 * adding two numbers in string format.
 * The sum of two digits must be between 0 and 18.   ( 9 + 9 = 18)
 * The ones place is added to the result while the tens place is carried and summed with the next pair of digits.
 * When summing two numbers, the carried digit will always be zero or one.
 * This process can be repeated for each digit
 *
 * corn case： after adding all digits, if last one position still need append 1.
 * so we need check if the carry != 0
 */
public class AddStrings415 {
    public static void main(String[] args) {
        String num1 = "456";
        String num2 = "77";
        String res = addition(num1, num2);
        System.out.println(res);
    }

    private static String addition(String num1, String num2) {
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;

        int carry = 0;
        StringBuilder sb = new StringBuilder();

        // num1 num2长度不一样
        while (index1 >= 0 || index2 >= 0) {
            int n1 = 0;
            int n2 = 0;

            if (index1 >= 0) {
                n1 = num1.charAt(index1) - '0';
                index1--;
            }

            if (index2 >= 0) {
                n2 = num2.charAt(index2) - '0';
                index2--;
            }

            int sum = n1 + n2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;

        }
        // 特殊情况处理，最后一位算完之后 也需要在进  1
        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }


}
