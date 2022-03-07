package algorithmWithLeetcode.datastructure;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueNumber1429 {
    private static Map<Integer, Integer> map = new LinkedHashMap<>();

    public FirstUniqueNumber1429(int[] nums) {
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    }

    public  int showFirstUnique() {
        for (Map.Entry entry : map.entrySet()) {
            if ((int) entry.getValue() == 1) {
                return (int) entry.getKey();
            }
        }
        return -1;


    }

    public  void add(int value) {
        map.put(value, map.getOrDefault(value, 0) + 1);

    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        FirstUniqueNumber1429 firstUniqueNumber1429 = new FirstUniqueNumber1429(nums);
        System.out.println(firstUniqueNumber1429.showFirstUnique());
        firstUniqueNumber1429.add(2);
        System.out.println(firstUniqueNumber1429.showFirstUnique());

    }

}
