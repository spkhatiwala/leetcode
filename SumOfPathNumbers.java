import scala.Int;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumOfPathNumbers {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };

    public static int findSumOfPathNumbers(TreeNode root) {
        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        recur(root, ll, l);
        return ll.stream().flatMap(Collection::stream).mapToInt(Integer::intValue).sum();
    }
    public static void recur(TreeNode root, List<List<Integer>> lists, List<Integer> currPath) {
        currPath.add(root.val);
        if(root.left == null && root.right == null)
            lists.add(new ArrayList<>(currPath));
        else{
            if(root.left !=null)
                recur(root.left, lists, currPath);
            if(root.right !=null)
                recur(root.right, lists, currPath);
        }
        currPath.remove(currPath.size() -1 );
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}
