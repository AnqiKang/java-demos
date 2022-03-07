package java8.streamApi;

import java.util.*;
import java.util.function.Consumer;

/**
 * forEach - for iteration
 */
public class ForEachDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Murrit", "John", "Peter", "Merek", "Mac"));

        list.stream().forEach(s -> System.out.print(s));

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");

        map.forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });

        map.entrySet().stream().forEach(obj -> System.out.println(obj));


        // internal work
        // void forEach(Consumer<? super T> action);
        Consumer<String> consumer = (t) -> System.out.println(t);
        for (String s : list) {
            consumer.accept(s);
        }


    }
}
