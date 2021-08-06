import scala.Int;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CountAllPathSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    };


    public static int countPaths(TreeNode root, int S) {
        List<Integer> list = new ArrayList<>();
        return countPathsRecur(root,list,  S );
    }

    public static int countPathsRecur(TreeNode root, List<Integer> currPath, int S) {
        currPath.add(root.val);
        ListIterator<Integer> listIterator = currPath.listIterator(currPath.size());
        int sum = 0;
        int count = 0;
        while(listIterator.hasPrevious()){
            sum = sum + listIterator.previous();
            if(sum == S){
                count ++;
            }
        }
        if(root.left !=null)
            count = count + countPathsRecur(root.left, currPath, S);
        if(root.right !=null)
            count = count + countPathsRecur(root.right, currPath, S);

        currPath.remove(currPath.size() -1 );
        return count;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
    }
}
