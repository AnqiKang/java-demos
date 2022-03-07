package algorithmWithLeetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin973 {
    public static void main(String[] args) {
        int[][] points = {{3, 3}, {-2, 4}, {5, -1}};
        int k = 2;
        int[][] res = kClosest(points, k);
        for (int[] r : res) {
            System.out.println(Arrays.toString(r));
        }

    }

    private static int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];

        // 求最小值，最接近的值，构建最大堆 maxHeap
        Queue<int[]> pq = new PriorityQueue<>((p1, p2) -> (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1]));

        // 把所有的point丢到pq中，一旦size > k, 就剔除最大的值，最远的值。 最后pq里只有k个值
        for (int[] point : points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int index = 0;
        while (!pq.isEmpty()) {
            res[index++] = pq.poll();
        }
        return res;

    }
}
