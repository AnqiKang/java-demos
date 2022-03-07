package algorithmWithLeetcode.datastructure;

import java.util.*;

/**
 * 随机获取元素，一定要有index
 */
public class InsertDeleteGetRandom380 {

    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;


    public InsertDeleteGetRandom380() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();

    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);

        // 要删除的数不是list的最后一个数
        if (index < list.size() - 1) {
            int lastNum = list.get(list.size() - 1);
            list.set(index, lastNum);
            map.put(lastNum, index);
        }

        map.remove(val);
        list.remove(list.get(list.size() - 1));
        return true;


    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));

    }

    public static void main(String[] args) {
        InsertDeleteGetRandom380 randomizedSet = new InsertDeleteGetRandom380();
        System.out.println(randomizedSet.insert(1)); // true
        System.out.println(randomizedSet.remove(2)); // false
        System.out.println(randomizedSet.insert(2)); // true
        System.out.println(randomizedSet.getRandom()); // 1 or 2
        System.out.println(randomizedSet.remove(1)); // true
        System.out.println(randomizedSet.insert(2));// false
        System.out.println(randomizedSet.getRandom());// 2
    }
}
