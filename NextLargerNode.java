import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


public class NextLargerNode {

    public static int[] nextLargerNodes(ListNode node){
        List<Integer> list = new ArrayList<>();
        while(node!=null){
            list.add(node.val);
            node = node.next;
        }

        int [] retArr = new int[list.size()];
        TreeSet<Integer> set = new TreeSet<>();
        for(int i= list.size()-1; i>=0 ; i--){
            if(set.isEmpty()) {
                retArr[i] = 0;
            }else{
                retArr[i] = set.higher(list.get(i)) ==null? 0:set.higher(list.get(i))  ;
            }
            set.add(list.get(i));
        }
        return retArr;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        int arr[]  = nextLargerNodes(node1);
        System.out.println(Arrays.toString(arr));
    }
}
