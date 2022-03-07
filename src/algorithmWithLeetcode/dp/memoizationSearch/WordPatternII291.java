package algorithmWithLeetcode.dp.memoizationSearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 匹配问题： 1对1匹配
 */
public class WordPatternII291 {
    public static void main(String[] args) {
        String pattern = "abab";
        String s = "redblueredblue";
        boolean res = wordPatternMatch(pattern, s);
        System.out.println(res);

    }

    private static boolean wordPatternMatch(String pattern, String s) {

        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return dfs(pattern, s, map, set);
    }

    private static boolean dfs(String pattern, String s, Map<Character, String> map, Set<String> set) {
        // 递归的出口
        // pattern 和 s 同时结束才算匹配完成
        if (pattern.length() == 0) {
            return s.length() == 0;
        }
        // 取出pattern 第一个字符, 看是否已有对应匹配
        Character ch = pattern.charAt(0);

        if (map.containsKey(ch)) {
            String word = map.get(ch);
            // 如果不匹配，word不是s的前缀，
            if (!s.startsWith(word)) {
                return false;
            }
            // 如果是前缀，继续向下查看
            return dfs(pattern.substring(1), s.substring(word.length()), map, set);
        }

        // 递归的拆解: 如果pattern里的首字母还没有找到匹配的字符， 那么pattern的首字母可能对应任何一个s的前缀，枚举查找
        for (int i = 0; i < s.length(); i++) {
            // 枚举取前缀
            String word = s.substring(0, i + 1);
            // 该前缀已经出现过了，剪枝优化
            if (set.contains(word)) {
                continue;
            }
            // 标记word已用, 记录映射关系
            set.add(word);
            map.put(ch, word);

            // 递归继续分解查看
            if (dfs(pattern.substring(1), s.substring(i + 1), map, set)) {
                return true;
            }
            // 回溯
            map.remove(ch);
            set.remove(word);
        }

        return false;
    }
}
