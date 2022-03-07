package codeTest.aTest;

import java.util.Arrays;

/**
 * Rearrange positive and negative numbers in an array maintaining the order of occurrence.
 * Input: [12 11 -13 -5 6 -7 5 -3 -6]
 * Output: [-13 -5 -7 -3 -6 12 11 6 5]
 */
public class RearrangePositiveAndNegativeNumInArray {
    public static void main(String[] args) {
        int[] input = {12, 11, -13, -5, 6, -7, 5, -3, -6};
        int[] output = rearrange(input);
        System.out.println(Arrays.toString(output));

    }

    private static int[] rearrange(int[] input) {
        if (input == null || input.length < 2) {
            return input;
        }
        int[] output = new int[(input.length - 1) * 2];

        int left = 0;
        int right = output.length - 1;
        int mid = left + (right - left) / 2;

        for (int i = 0; i < input.length; i++) {
            if (input[i] < 0) {
                output[left++] = input[i];
            } else {
                output[right--] = input[i];
            }
        }
        int index = output.length - 1;
        for (int i = left; i < input.length; i++) {
            output[i] = output[index--];
        }
        return Arrays.copyOfRange(output, 0, input.length);
    }
}
