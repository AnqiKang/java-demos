package codeTest.aTest;

import java.util.*;

public class CollectionOfRandomNums {
    public static void main(String[] args) {
        int sizeOfCollection = 10;
        int maxRandomValue = 10;
        List<Integer> res = generateRandomCollection(sizeOfCollection, maxRandomValue);

        System.out.println(res);
    }

    private static List<Integer>  generateRandomCollection(int sizeOfCollection, int maxRandomValue){

        List<Integer> res = new ArrayList<>();
        Random random = new Random();
        Set<Integer> set = new HashSet<>();

        while(sizeOfCollection > 0){
            int num = random.nextInt(maxRandomValue) + 1;
            if(!set.contains(num)){
                set.add(num);
                res.add(num);
                sizeOfCollection--;
            }

        }
        return res;
    }
}
