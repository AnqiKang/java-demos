package java8.streamApi;

import java.util.*;

/**
 * Filter - for conditional check
 */
public class FilterDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Murrit", "John", "Peter", "Merek", "Mac"));
        list.stream().filter(s -> s.startsWith("M")).forEach(o -> System.out.println(o));

        //  Stream<T> filter(Predicate<? super T> predicate);


        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");

        // map没有办法直接stream（）,先要对 key-value pair 进行 forEach，
        map.forEach((k, v) -> {
            if (k % 2 == 0) {
                System.out.println(k + " : " + v);
            }
        });
        // map.entrySet() 是一个set， 可以直接使用stream（）
        map.entrySet().stream().filter(k -> k.getKey() % 2 == 0).forEach(obj -> System.out.println(obj));


    }
}
