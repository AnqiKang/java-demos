package algorithmWithLeetcode.dp.memoizationSearch;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 没有用记忆化搜索。可以用其优化
 */
public class WordBreakII140 {
    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> wordDict = new ArrayList<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        List<String> res = wordBreak(s, wordDict);
        System.out.println(res);

    }

    private static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 1) {
            return res;
        }
        if (wordDict == null || wordDict.size() < 1) {
            return null;
        }

        int maxLen = wordDict.stream().max(Comparator.comparingInt(String::length)).get().length();
        dfs(res, s, wordDict, maxLen, 0, new ArrayList<>());

        return res;

    }

    private static void dfs(List<String> res, String s, List<String> wordDict, int maxLen, int index, List<String> sub) {
        if (index == s.length()) {
            res.add(sub.stream().collect(Collectors.joining(" ")));
            return;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            if (i - index > maxLen) {
                break;
            }

            String curWord = s.substring(index, i);
            if (!wordDict.contains(curWord)) {
                continue;
            }
            sub.add(curWord);
            dfs(res, s, wordDict, maxLen, i, sub);
            sub.remove(sub.size() - 1);

        }

    }
}
