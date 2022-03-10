package algorithmWithLeetcode.c.stackandqueue;

import java.util.*;

public class ZigzagIteratorIILT541 {

    private static Queue<Iterator<Integer>> queue = new LinkedList<>();

    public ZigzagIteratorIILT541(List<List<Integer>> vecs) {
        for (List<Integer> vec : vecs) {
            if (vec.size() > 0) {
                queue.offer(vec.iterator());
            }
        }
    }

    private int next() {
        // it 是指每一个vec的遍历器， 从queue里拿出的东西就是vec， 利用每一个list的iterator来进行获取下一个
        Iterator<Integer> it = queue.poll();
        int value = it.next();
        if (it.hasNext()) {
            queue.offer(it);
        }
        return value;
    }

    private boolean hasNext() {
        // 判断queue是否还有下一个
        return !queue.isEmpty();
    }


    public static void main(String[] args) {
        List<List<Integer>> vecs = new ArrayList<>();
        vecs.add(Arrays.asList(1, 2, 3));
        vecs.add(Arrays.asList(4, 5, 6, 7));
        vecs.add(Arrays.asList(8, 9));
        System.out.println(vecs);
        ZigzagIteratorIILT541 zigzagIteratorIILT541 = new ZigzagIteratorIILT541(vecs);

        List<Integer> res = new ArrayList<>();

        while (zigzagIteratorIILT541.hasNext()) { // 判断queue里是否还有下一个vec
            res.add(zigzagIteratorIILT541.next());
        }
        System.out.println(res);


    }


}
