public class LowestCommonAncestor {
    static TreeNode lca = null;
 static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public static  TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestor(root,p,q);
        return lca;
    }
        public static  TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //The logic is to recursively do DFS and find either P or Q
        //Try to find P or Q and propagate up.
        //If currentNode is P or Q we return(propagate up) currentNode
        //If we find P and Q from left and right subtrees both, propagate up CurrentNode since currentNode will be LCA.
        //Else propagate up either leftTree or rightSubtree which ever is non null.

        //if root is null
        if(root==null)
            return root;

        //if the current node is p or q return curentnode
        if(root==p || root==q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //if both left and right subtree are non null
        //then the current node is the LCA
        if(left!=null && right!=null) {
            lca = root;
            return root;
        }

        if(left!=null)
            return left;

        if(right!=null)
            return right;

        return null;
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);

        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node2.left = node7;
        node2.right = node4;
        node1.left = node0;
        node1.right = node8;
        System.out.println(LCA(node3, node5, node4));
        System.out.println(LCA(node3, node5, new TreeNode(10)));

    }

}
