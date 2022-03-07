package algorithmWithLeetcode.bfs;

import java.util.ArrayList;
import java.util.List;

public class BFSTwoQueueDemo {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(25);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        List<List<Integer>> res = levelOrder(node1);
        System.out.println(res);

    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // 这个例子中不存在从头poll元素，arraylist就可以解决问题
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<TreeNode> next_queue = new ArrayList<>();
            res.add(toIntegerList(queue));

            for (TreeNode node : queue) {
                if (node.left != null) {
                    next_queue.add(node.left);
                }
                if (node.right != null) {
                    next_queue.add(node.right);
                }
            }
            queue = next_queue;
        }
        return res;
    }

    private static List<Integer> toIntegerList(List<TreeNode> queue) {
        List<Integer> level = new ArrayList<>();
        for (TreeNode node : queue) {
            level.add(node.val);
        }
        return level;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
