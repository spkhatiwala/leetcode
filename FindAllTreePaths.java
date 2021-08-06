
import scala.Int;

import java.util.ArrayList;
import java.util.List;

public class FindAllTreePaths {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };

    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        findPathsRecur(root, lists, new ArrayList<>(), sum);
        return lists;
    }

    static boolean leafNode(TreeNode node){
        return node.left==null && node.right==null;
    }

    public static void findPathsRecur(TreeNode root, List<List<Integer>> lists, List<Integer> list, int sum){
        list.add(root.val);
        if(leafNode(root)){
            if(root.val==sum)
                lists.add(new ArrayList<>(list));
        }else{
            if(root.left!=null)
                findPathsRecur(root.left, lists, list, sum- root.val);
            if(root.right !=null)
                findPathsRecur(root.right, lists, list, sum-root.val);
        }
        list.remove(list.size()-1);
    }





    public static void main(String[] args) {

        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
