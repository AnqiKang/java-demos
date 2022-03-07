package codeTest.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CombineTwoListOfStrings {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(Arrays.asList("this", "is", "str", "one"));
        List<String> list2 = new ArrayList<>(Arrays.asList("this", "is", "str", "two"));

        List<String> res = Stream.of(list1.stream(), list2.stream()).flatMap(s -> s).collect(Collectors.toList());

        System.out.println(res);
    }
}
