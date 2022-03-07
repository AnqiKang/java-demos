package algorithmWithLeetcode.dfs;

public class MinimumSubtreeLT596 {
    private static class Result {
        int curSum;
        int minSum;
        TreeNode minSub;

        public Result(int curSum, int minSum, TreeNode minSub) {
            this.curSum = curSum;
            this.minSum = minSum;
            this.minSub = minSub;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(-5);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(-4);
        TreeNode node7 = new TreeNode(-5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        findSubtree(node1);


    }


    private static TreeNode findSubtree(TreeNode root) {
        if (root == null) {
            return null;
        }
        return findSumOfTree(root).minSub;

    }

    private static Result findSumOfTree(TreeNode node) {
        if (node == null) {
            return new Result(0, 0, null);
        }
        if (node.left == null && node.right == null) {
            return new Result(node.val, node.val, node);
        }

        Result left = findSumOfTree(node.left);
        Result right = findSumOfTree(node.right);

        int curSum = node.val + left.curSum + right.curSum;

        Result curResult = new Result(curSum, curSum, node);

        if (curResult.minSum > left.minSum && left.minSub != null) {
            curResult.minSum = left.minSum;
            curResult.minSub = left.minSub;
        }
        if (curResult.minSum > right.minSum && right.minSub != null) {
            curResult.minSum = right.minSum;
            curResult.minSub = right.minSub;
        }
        return curResult;

    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

}
