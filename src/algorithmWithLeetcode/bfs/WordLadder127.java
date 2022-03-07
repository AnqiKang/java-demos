package algorithmWithLeetcode.bfs;

import java.util.*;

public class WordLadder127 {
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        String beginWord = "hit";
        String endWord = "cog";
        int res = ladderLength(beginWord, endWord, wordList);
        System.out.println(res);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() < 1 || !wordList.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.add(beginWord);
        set.add((beginWord));

        int len = 1;

        while (!queue.isEmpty()) {
            len++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                List<String> nextWords = getNextWords(wordList, curWord);
                for (String word : nextWords) {
                    if (set.contains(word)) {
                        continue;
                    }
                    if (word.equals(endWord)) {
                        return len;
                    }
                    queue.offer(word);
                    set.add(word);
                }

            }

        }
        return 0;
    }

    private static List<String> getNextWords(List<String> wordList, String curWord) {
        List<String> nextWords = new ArrayList<>();

        for (String word : wordList) {
            boolean hasOneDiff = false;
            for (int i = 0; i < curWord.length(); i++) {
                if (word.charAt(i) != curWord.charAt(i)) {
                    if (hasOneDiff) {
                        hasOneDiff = false;
                        break;
                    }
                    hasOneDiff = true;
                }

            }
            if (hasOneDiff) {
                nextWords.add(word);
            }

        }
        return nextWords;
    }
}
