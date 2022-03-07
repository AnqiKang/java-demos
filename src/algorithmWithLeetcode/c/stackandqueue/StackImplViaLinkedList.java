package algorithmWithLeetcode.c.stackandqueue;

import java.util.NoSuchElementException;



public class StackImplViaLinkedList {
     class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
    private ListNode head;

    public static void main(String[] args) {
        StackImplViaLinkedList stack = new StackImplViaLinkedList();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        // 先进后出
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }

    }

    private void push(int val) {
        ListNode newHead = new ListNode(val);
        newHead.next = head;
        head = newHead;
    }

    private int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int ret = head.val;
        head = head.next;
        return ret;
    }

    private int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.val;
    }

    private boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
    }


}
