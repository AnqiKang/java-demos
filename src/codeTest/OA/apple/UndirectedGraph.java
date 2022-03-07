package codeTest.OA.apple;

import java.util.*;

/**
 * 2021-08-03 task2
 */
public class UndirectedGraph {
    public static void main(String[] args) {
        int[] A = {2, 2, 1, 2};
        int[] B = {1, 3, 4, 4};

        int N = 5;

        Map<Integer, Integer> map = construct(A, B, N);
        System.out.println(map);

        int res = setAndGetValue(map, N);
        System.out.println(res);


    }

    private static int setAndGetValue(Map<Integer, Integer> map, int N) {
        int res = 0;
        // 利用list给map按照value排序, Collectors.sort(list, comparator)
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<Integer, Integer> entry : list) {
            res += entry.getValue() * N;
            N--;
        }


        return res;
    }


    private static Map<Integer, Integer> construct(int[] A, int[] B, int N) {
        Map<Integer, Integer> map = new HashMap<>();
        // key : each node in Graph, value : times
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            map.put(B[i], map.getOrDefault(B[i], 0) + 1);
        }
        return map;

    }
}
