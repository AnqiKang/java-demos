package algorithmWithLeetcode.heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * O(NLogN)
 * 加入一个数是 O（LogN）
 * 取出一个数 会加入3个数 最后取出N个数
 * 所以总时间复杂度接近 O（3NLog3N）
 */

public class UglyNumberII264 {
    public static void main(String[] args) {
        int n = 10;
        int res = UglyNumber(n);
        System.out.println(res);

    }

    private static int UglyNumber(int n) {
        if (n == 0) {
            return -1;
        }


        // 使用PriorityQueue来取出当前最小的数
        Queue<Long> pq = new PriorityQueue<>();
        // set来去重复， 防止相同的数字进入PQ中，PQ只能取出最大/最小数，内部没有顺序，也不能去重复
        Set<Long> set = new HashSet<>();
        int[] factors = {2, 3, 5};

        pq.offer(1L);
        set.add(1L);

        long ugly = 1;
        for (int i = 0; i < n; i++) {
            ugly = pq.poll(); // 弹出当前的最小 ugly number
            for (int f : factors) {
                Long cur = f * ugly;
                if (!set.contains(cur)) {
                    pq.offer(cur);
                    set.add(cur);
                }
            }
        }

        return (int) ugly;

    }
}