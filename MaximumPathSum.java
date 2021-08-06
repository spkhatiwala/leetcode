public class MaximumPathSum {

    static int maxSum = Integer.MIN_VALUE;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };

    public static int findMaximumPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        recur(root);
        return maxSum;
    }

    public static int recur(TreeNode root){
        if(root == null)
            return 0;

        int left = Math.max(recur(root.left),0);
        int right = Math.max(recur(root.right),0);
        int sum = left + right + root.val;
        maxSum = Math.max(sum, maxSum);
        return Math.max(left,right) ;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    }
}
