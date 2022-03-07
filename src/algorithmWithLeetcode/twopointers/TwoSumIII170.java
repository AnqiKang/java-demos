package algorithmWithLeetcode.twopointers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumIII170 {
    private static List<Integer> nums;

    public static void main(String[] args) {
        nums = new ArrayList<>();
        add2(2);
        add2(3);
        System.out.println(find2(4));
        System.out.println(find2(5));
        System.out.println(find2(6));
        add2(3);
        System.out.println(find2(6));

    }


    /**
     * method 1 会超时， 利用HashMap 来求解
     * add2 O（1），find2 o（N）
     * 但这里其实效率并不高，因为还使用额外的空间，可以直接存储在map里。
     */
    private static void add2(int number) {
        nums.add(number);
    }

    private static boolean find2(int value) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            if (map.containsKey(value - nums.get(i))) {
                return true;
            }
            map.put(nums.get(i), map.getOrDefault(map.get(i), 0) + 1);
        }
        return false;
    }

    /**
     * 如何在添加数据的时候维持一个有序性呢？-- 插入排序 O（N）
     * 注意： 所有和index做比较的时候，都要限定index的范围不要越界 boundary check
     *
     * @param number
     */
    private static void add(int number) {
        nums.add(number);
        int idx = nums.size() - 1;
        while (idx > 0 && (nums.get(idx - 1) > nums.get(idx))) { // 新数据不断的和它的前一位做比较。如果前一位大于当前的数，就交换。
            int temp = nums.get(idx);
            nums.set(idx, nums.get(idx - 1));
            nums.set(idx - 1, temp);
            idx--;
        }
    }

    /**
     * two pointer   O（N）
     *
     * @param value
     * @return
     */
    private static boolean find(int value) {
        int left = 0;
        int right = nums.size() - 1;
        while (left < right) {  // left <= right 不可以
            int twoSum = nums.get(left) + nums.get(right);
            if (twoSum == value) {
                return true;
            }
            if (twoSum < value) {
                left++;
            } else if (twoSum > value) {
                right--;
            }
        }
        return false;
    }


}
