package algorithmWithLeetcode.dfs.combination;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber17 {
    private final static char[][] LETTERS = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public static void main(String[] args) {
        String digits = "23";
        letterCombinations(digits);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() < 1 || digits == null) {
            return res;
        }

        // "234" --> [['a','b','c'],['d','e','f']]
        List<List<Character>> letterList = new ArrayList<>();
        for (char digit : digits.toCharArray()) {
            int num = digit - '0';

            if (num != 0 && num != 1) {
                List<Character> list = new ArrayList<>();
                for (char ch : LETTERS[num]) {
                    list.add(ch);
                }
                letterList.add(list);
            }

        }


        System.out.println(letterList);
        dfs(letterList, res, new StringBuilder(), 0);
        System.out.println(res);

        return res;
    }

    private static void dfs(List<List<Character>> letterList, List<String> res, StringBuilder sb, int index) {
        if (sb.length() == letterList.size()) {
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < letterList.get(index).size(); i++) {
            sb.append(letterList.get(index).get(i));
            dfs(letterList, res, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);

        }
    }


}
