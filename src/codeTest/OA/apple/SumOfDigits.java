package codeTest.OA.apple;

import java.util.*;

/**
 *  2021-08-03
 */
public class SumOfDigits {
    public static void main(String[] args) {
        int[] arr = {42, 33, 60};
        Map<Integer, Queue<Integer>> map = sum(arr);
        //System.out.println(map);
        int max = getMaxSum(map);

        System.out.println(max);

    }

    private static int getMaxSum(Map<Integer, Queue<Integer>> map) {
        if (map == null) {
            return -1;
        }
        int res = Integer.MIN_VALUE;

        for (Map.Entry entry : map.entrySet()) {
            Queue<Integer> cur = (Queue<Integer>) entry.getValue();
            if (cur.size() == 1) {
                continue;
            }

            int curSum = cur.stream().mapToInt(x -> x).sum();

            if (curSum > res) {
                res = curSum;
            }
        }
        return res == Integer.MIN_VALUE ? -1 : res;
    }

    private static Map<Integer, Queue<Integer>> sum(int[] arr) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        if (arr == null || arr.length < 2) {
            return map;
        }
        for (int num : arr) {
            int digitSum = getDigitSum(num);
            if (!map.containsKey(digitSum)) {
                map.put(digitSum, new PriorityQueue<>());
            }

            if (map.get(digitSum).size() >= 2) {
                map.get(digitSum).poll();
            }
            map.get(digitSum).add(num);

        }

        return map;
    }

    private static int getDigitSum(int num) {
        int res = 0;
        while (num != 0) {
            res += num % 10;
            num = num / 10;

        }
        return res;

    }

}
