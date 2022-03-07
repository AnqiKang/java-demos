package algorithmWithLeetcode.c.stackandqueue;


import java.util.NoSuchElementException;

public class QueueImplViaLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode head;
    private ListNode tail;

    public static void main(String[] args) {
        QueueImplViaLinkedList queue = new QueueImplViaLinkedList();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);

        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.poll();
        }

    }

    private void offer(int val) {
        if (tail == null) {
            head = tail = new ListNode(val);
        } else {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
    }

    private int poll() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int ret = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return ret;
    }

    private int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = tail = null;
    }


}
