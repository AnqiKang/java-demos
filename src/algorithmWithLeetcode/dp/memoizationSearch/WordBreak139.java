package algorithmWithLeetcode.dp.memoizationSearch;

import java.util.*;

public class WordBreak139 {
    public static void main(String[] args) {
        String s = "algorithmWithLeetcode";
        List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code"));
        boolean res = wordBreak(s, wordDict);
        System.out.println(res);


    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() < 1) {
            return true;
        }
        if (wordDict == null || wordDict.size() < 1) {
            return false;
        }

        // 可能性减枝， 如果该词已经超过了 dict里面最长的单词，那么他一定不是正确的单词
        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }

        return dfs(s, 0, maxLen, wordDict, new HashMap<Integer, Boolean>());
    }

    /**
     * 从index开始到String结尾处的substring 能否拆分成 wordDict 里面的单词
     * @param s  原始字符串
     * @param index  切分子串，
     * @param maxLen  wordDict里面最长的单词长度
     * @param wordDict
     * @param map  记忆化搜索
     * @return
     */
    private static boolean dfs(String s, int index, int maxLen, List<String> wordDict, Map<Integer, Boolean> map) {
        // 记忆化搜索，如果 从该index到结尾的子串已经在map中存在了，直接返回其结果
        if (map.containsKey(index)) {
            return map.get(index);
        }
        // 递归的出口，已经划分到了该string的尾部。 之前划分的词都在wordDict里面，
        if (index == s.length()) {
            return true;
        }

        // 递归的拆解：字符串的切割
        // 起点index是确定的，只需要枚举终点，下一个划分的字符串的终点， 分治解决每个子问题
        // substring 前包后不抱，所以end = index + 1。 保证长度至少=1
        for (int end = index + 1; end <= s.length(); end++) {
            // 利用词长剪枝
            if (end - index > maxLen) {
                break;
            }
            // 得到前缀单词， 判断该词，只有该词在字典中，才会向下继续切割 （切割的后缀单词）
            String word = s.substring(index, end);
            if (!wordDict.contains(word)) {
                continue;
            }
            // 继续向下切割
            if (dfs(s, end, maxLen, wordDict, map)) {
                return true;
            }
        }

        map.put(index, false);
        return false;

    }
}
