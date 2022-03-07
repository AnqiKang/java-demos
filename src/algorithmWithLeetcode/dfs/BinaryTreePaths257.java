package algorithmWithLeetcode.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreePaths257 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;

        List<String> res = binaryTreePaths(node1);
        System.out.println(res);

    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> curPath = new ArrayList<>();
        curPath.add(root.val);

        findAllPaths(allPaths, curPath, root);
        for (List<Integer> list : allPaths) {
            res.add(list.stream().map(str -> String.valueOf(str)).collect(Collectors.joining("->")));
        }
        return res;
    }

    private static void findAllPaths(List<List<Integer>> allPaths, List<Integer> curPath, TreeNode node) {
        if (node.left == null && node.right == null) {
            allPaths.add(new ArrayList<>(curPath));
            return;
        }

        if (node.left != null) {
            curPath.add(node.left.val);
            findAllPaths(allPaths, curPath, node.left);
            curPath.remove(curPath.size() - 1);
        }

        if (node.right != null) {
            curPath.add(node.right.val);
            findAllPaths(allPaths, curPath, node.right);
            curPath.remove(curPath.size() - 1);
        }
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
