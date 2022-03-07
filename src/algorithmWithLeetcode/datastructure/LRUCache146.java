package algorithmWithLeetcode.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * Hash快速查找
 * Hash记录删除点
 * linkedList 记录位置
 */
public class LRUCache146 {
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    static Map<Integer, Integer> cache;
    static Map<Integer, ListNode> keyToNode;
    static ListNode dummy;
    static ListNode tail;
    static int capacity;

    public LRUCache146(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        keyToNode = new HashMap<>();
        dummy = new ListNode(Integer.MIN_VALUE);
        tail = dummy;

    }

    public static int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        // 更新位置

        return -1;


    }

    // linklist: 最新的数据放在tail，旧数据放在head
    public static void put(int key, int value) {
        // cache 里有这个key： cache更新value； LinkedList更换位置，keyToNode更换value
        if (cache.containsKey(key)) {
            cache.put(key, value);
            ListNode pre = keyToNode.get(key);

            if(pre.next.next != null){
                pre.next = pre.next.next;
            }

            keyToNode.put(pre.next.val, pre);
            tail.next = new ListNode(key);
            keyToNode.put(key, tail);
            tail = tail.next;
        } else {
            // cache 里没有这个key： 检查大小，
            // 1: 小于capacity： cache添加，linkedList添加，keyToNode添加
            // 2: 不小于： keyToNode获取pre node位置，删除linkedList头节点，两个map都删除
            if (cache.size() < capacity) {
                cache.put(key, value);
                tail.next = new ListNode(key);
                keyToNode.put(key, tail);
                tail = tail.next;
            } else {
                //删除head
                int v = dummy.next.val;
                dummy.next = dummy.next.next;
                tail.next = new ListNode(key);
                keyToNode.put(key, tail);
                tail = tail.next;
                cache.remove(v);
                cache.put(key, value);
            }
        }

    }

    public static void main(String[] args) {
        LRUCache146 lru = new LRUCache146(2);
        put(2, 1);
        put(2, 2);

        get(2);
        put(1, 1);
        put(4, 1);

        get(2);


    }

}
