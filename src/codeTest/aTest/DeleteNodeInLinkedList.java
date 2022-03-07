package codeTest.aTest;

/**
 * iven a pointer to the nth node in the linked list, how do you delete it in O(1)
 * Example: Create a simple linked list of 5 elements and then delete the 3rd node.
 */
public class DeleteNodeInLinkedList {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        int position = 5;

        Node node = deleteNode(node1, position);
        printLinkedList(node);
    }

    private static void printLinkedList(Node node) {
        while (node.next != null) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println(node.val);
    }

    private static Node deleteNode(Node node, int position) {
        if (node == null) {
            return null;
        }

        int index = 0; // because dummy node is 0

        Node dummy = new Node(Integer.MIN_VALUE);
        dummy.next = node;
        Node curNode = dummy;

        while (curNode.next != null && index != position - 1) {
            curNode = curNode.next;
            index++;
        }
        if (curNode.next.next != null) {
            curNode.next = curNode.next.next;
        } else {
            curNode.next = null;
        }
        return dummy.next;
    }

    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
