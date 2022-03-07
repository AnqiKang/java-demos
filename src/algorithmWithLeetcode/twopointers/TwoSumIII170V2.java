package algorithmWithLeetcode.twopointers;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIII170V2 {
    private static Map<Integer, Integer> nums;

    public static void main(String[] args) {
        nums = new HashMap<>();
        add(0);
        add(0);

        System.out.println(find2(0));

    }

    private static void add(int i) {
        nums.put(i, nums.getOrDefault(nums.get(i), 0) + 1);
    }

    private static boolean find2(int value) {
        for(Integer num : nums.keySet()){
            if(nums.containsKey(value - num) && value - num != num){ // map中找得到value - num，但是他们不能为同一个数。要不然 都为0的情况下，会出错
                return true;
            }
            if((value - num) == num && nums.get(num) > 1){// 如果value - num == num了就要确保该num出现了2次以上
                return true;
            }
        }
        return false;
    }
}
