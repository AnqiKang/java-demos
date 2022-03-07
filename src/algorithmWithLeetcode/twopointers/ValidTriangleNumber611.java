package algorithmWithLeetcode.twopointers;

import java.util.Arrays;

public class ValidTriangleNumber611 {

    public static void main(String[] args) {
        int[] edges = {4, 4, 4, 4};
        int cnt = buildTriangleCount(edges);
        System.out.println(cnt);

    }

    private static int buildTriangleCount(int[] edges) {
        if (edges == null || edges.length < 3) {
            return 0;
        }

        Arrays.sort(edges);

        int cnt = 0;
        // 固定最大边，所以 i 之前至少有 2 个数
        for (int i = 2; i < edges.length; i++) {
            cnt += getTriCnt(edges, i, edges[i]);
        }
        return cnt;
    }

    /**
     * 和 2Sum的不同之处， 本题只求count，不是求解的集合，所以可以批量求解优化
     * A + B > C 两边之和大于第三遍
     * 批量求解优化：  1  2  2  3  3（最大边）
     *              ｜        ｜
     *              如果 left 和 right 已经大于最大变了，那么left 和 right 中间的所有数也都大于第三边，
     *              right - left 批量求解
     *              如果 left 和 right 小于 最大变， 只需要left++
     *
     */
    private static int getTriCnt(int[] edges, int index, int target) {
        int left = 0;
        int right = index - 1;
        int cnt = 0;
        while (left < right) {
            if (edges[left] + edges[right] > target) {
                cnt += right - left;
                right--;
            } else {
                left++;
            }
        }
        return cnt;
    }


}
