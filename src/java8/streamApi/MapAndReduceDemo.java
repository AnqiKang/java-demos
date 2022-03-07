package java8.streamApi;

import java.util.Arrays;
import java.util.List;

/**
 * sum
 * multiple
 * min/max
 */

public class MapAndReduceDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 7, 8, 1, 5, 9);

        // sum with map
        int sum1 = list.stream().mapToInt(n -> n).sum();
        System.out.println(sum1);

        // sum with reduce
        int reduceSum = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduceSum);

        int reduceSum1 = list.stream().reduce(Integer::sum).get();
        System.out.println(reduceSum1);

        // multiple
        int multipleRes = list.stream().reduce(1, (a, b) -> a * b);
        System.out.println(multipleRes);

        // min / max
        int maxRes = list.stream().reduce(0, (a, b) -> a > b ? a : b);
        System.out.println(maxRes);

        int minValue = list.stream().reduce(Integer::min).get();
        System.out.println(minValue);

        List<String> words = Arrays.asList("javacore", "Spring", "Hibernate");

        // longest string
        String longestWord = words.stream().reduce((a, b) -> a.length() > b.length() ? a : b).get();
        System.out.println(longestWord);

    }
}
