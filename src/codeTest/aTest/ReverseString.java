package codeTest.aTest;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        String str = "I am a developer";
        String res = reverseString(str);
        System.out.println(res);


    }

    private static String reverseString(String str) {
        String[] words = str.split(" ");
        System.out.println(Arrays.toString(words));

        int left = 0;
        int right = words.length - 1;

        while(left <= right){
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        System.out.println(Arrays.toString(words));


        return String.join(" ", words);


    }
}
