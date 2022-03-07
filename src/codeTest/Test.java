package codeTest;


import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<String> words = new ArrayList<String>();
        words.add("Rat");
        words.add("Car");
        words.add("Below");
        words.add("Tast");
        words.add("Cried");
        words.add("Study");
        words.add("Thing");
        words.add("Chin");
        words.add("Grab");
        words.add("Act");
        words.add("Robed");
        words.add("Vase");
        words.add("Glean");
        words.add("Desserts");
        words.add("Tar");
        words.add("Arc");
        words.add("Elbow");
        words.add("State");
        words.add("Cider");
        words.add("Dusty");
        words.add("Night");
        words.add("Inch");
        words.add("Brag");
        words.add("Cat");
        words.add("Bored");
        words.add("Save");
        words.add("Angel");
        words.add("Streseed");

        // Return type is List<List<String>>
        //{{Rat, Tar}, {Car, Arc},{Elbow,Below}}

        List<List<String>> res = anagrams(words);
        System.out.println(res);

    }

    private static List<List<String>> anagrams(List<String> words) {
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.size() < 1) {
            return res;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            String curWord = word.toLowerCase();
            char[] chars = curWord.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);

        }
        //System.out.println(map);
        for (Map.Entry entry : map.entrySet()) {
            res.add((List<String>) entry.getValue());
        }

        return res;
    }
}
