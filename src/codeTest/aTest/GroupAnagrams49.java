package codeTest.aTest;

import java.util.*;

public class GroupAnagrams49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams(strs);
        System.out.println(res);
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length < 1) {
            return null;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars); // 排序后，可以得到相同的字母个数和顺序，用于比较
            String key = String.valueOf(chars);

            // map.putIfAbsent(key, new ArrayList<>());
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            // get 得到其value，是一个arrayList，往里面添加具体的value
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
