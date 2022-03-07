package algorithmWithLeetcode.a.linkedlist;

public class ListNodeExample {

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    private static ListNode head;


    public static void main(String[] args) {
        ListNodeExample myLinkedList = new ListNodeExample();

        myLinkedList.add(0, 1);
        myLinkedList.add(1, 3);
        myLinkedList.add(2, 5);
        myLinkedList.add(3, 7);

        myLinkedList.traverse(head);

        myLinkedList.set(3, 100);
        myLinkedList.traverse(head);

        myLinkedList.remove(2);
        myLinkedList.traverse(head);

        myLinkedList.set(0, 100);
        myLinkedList.traverse(head);

    }

    public ListNode createLikedList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        return node1;
    }

    private void traverse(ListNode node) {
        if (node == null) {
            System.out.println("This is an empty linked list");
        }

        System.out.println("traverse ... ");
        ListNode cur = node;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;

        }
        System.out.println("\n");
    }

    private void add(int location, int val) {
        if (location > 0) {
            ListNode pre = head;
            for (int i = 0; i < location - 1; i++) {
                pre = pre.next;
            }
            ListNode newNode = new ListNode(val);
            newNode.next = pre.next;
            pre.next = newNode;
        } else {
            ListNode newNode = new ListNode(val);
            newNode.next = head;
            head = newNode;
        }

    }

    private int get(int location) {
        ListNode cur = head;
        for (int i = 0; i < location; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    private void set(int location, int newVal) {
        ListNode cur = head;
        for (int i = 0; i < location; i++) {
            cur = cur.next;
        }
        cur.val = newVal;
    }

    private int remove(int location) {
        ListNode res = null;
        if (location > 0) {
            ListNode pre = head;
            for (int i = 0; i < location - 1; i++) {
                pre = pre.next;
            }
            res = pre.next;
            pre.next = pre.next.next;
        } else {
            res = head;
            head = head.next;
        }
        return res.val;

    }


}
