package codeTest.aTest;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber17 {
    public static void main(String[] args) {
        String digits = "123";
        List<String> allCombinations = letterCombinations(digits);
        System.out.println(allCombinations);

    }

    private final static String[] numToLetters = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    private static List<String> letterCombinations(String digits) {
        List<String> allCombinations = new ArrayList<>();
        if (digits == null || digits.length() < 1) {
            return allCombinations;
        }

        return null;

    }
}
