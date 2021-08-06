public class PathWithGivenSequence {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };
    public static boolean findPath(TreeNode root, int[] sequence) {
        return findPathRecursive(root, sequence, 0);
    }
    public static boolean findPathRecursive(TreeNode root, int[] sequence, int i) {
        if(root.left ==null && root.right ==null && sequence[i] == root.val) {
            return true;
        }else{
            boolean bool = false;
            if(root.left != null) {
                bool= findPathRecursive(root.left, sequence, i + 1);
            }
            if(!bool && root.right!= null ){
                bool= findPathRecursive(root.right, sequence, i + 1);
            }
            return bool;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }
}
