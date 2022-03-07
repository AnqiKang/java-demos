package algorithmWithLeetcode.datastructure;

import java.util.*;

/**
 * LinkedList + HashMap
 * Hash 查找 o(1)
 * LinkedList 存储unique number + 记录插入顺序 O(1) + 删除 O（1）
 */

public class FirstUniqueNumberLT960 {
    private class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // 记录当前的value + 这个value在LinkedList的prev node。 LinkedList remove操作，只有在知道前一个node的时候才是O（1） 删除
    // 否则还需要遍历查找，所以使用map记录
    private  Map<Integer, ListNode> numToPrevNode;
    private Set<Integer> set;
    private ListNode dummy;
    private ListNode tail;

    public FirstUniqueNumberLT960() {
        numToPrevNode= new HashMap<>();
        set = new HashSet<>();
        dummy= new ListNode(Integer.MIN_VALUE);
        tail = dummy;
    }

    public void add(int value) {
        // 已经重复，啥也不做
        if(set.contains(value)){
            return;
        }
        // 不重复，但是map里面也没有，添加在list 尾部
        if(!numToPrevNode.containsKey(value)){
            tail.next = new ListNode(value);
            numToPrevNode.put(value, tail);
            tail = tail.next;
            return;
        }

        // value 第二次出现，添加到set，并从ListList删除
        ListNode prev = numToPrevNode.get(value);
        prev.next = prev.next.next;
        numToPrevNode.remove(value);

        if(prev.next != null){
            numToPrevNode.put(prev.next.val, prev);
        }else{
            tail = prev;
        }

    }

    /**
     * O(1)
     */
    public int showFirstUnique() {
        if(dummy.next == null){
            return -1;
        }
        return dummy.next.val;

    }



    public static void main(String[] args) {
        FirstUniqueNumberLT960 dataStream = new FirstUniqueNumberLT960();
        dataStream.add(1);
        dataStream.add(2);
        System.out.println(dataStream.showFirstUnique());
        dataStream.add(1);
        System.out.println(dataStream.showFirstUnique());


    }

}
