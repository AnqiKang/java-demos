package codeTest.OA.apple;

import java.util.HashMap;

/**
 * 2021-08-11 task3
 */
public class NCities {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 3};
        int[] B = {2, 3, 1, 4};
        int N = 4;

        int res = findMaxConnection(A, B, N);
        System.out.println(res);
    }


    private static int findMaxConnection(int[] A, int[] B, int N) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // 其实是在统计每个离city出现的次数，代表可以可以被走到的次数
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            map.put(B[i], map.getOrDefault(B[i], 0) + 1);
        }
        System.out.println(map);

        int maxRank = 0;
        for (int i = 0; i < A.length; i++) {
            // 1- 2 和 2-1一定是一样的，所以要-1。
            int curRank = map.get(A[i]) + map.get(B[i]) - 1;
            if (maxRank < curRank) {
                maxRank = curRank;
            }
        }
        return maxRank;
    }
}
