

public class LinkedListCycleLength {

    public static int findCycleLength(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        while(fastNode!=null && fastNode.next!=null){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if(fastNode==slowNode)
                return calculateLength(slowNode);
        }
        return 0;
    }

    private static int calculateLength(ListNode slow) {
        ListNode temp = slow;
        int len=0;
        do{
            temp = temp.next;
            len++;
        }while(temp!=slow);
        return len;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle length: " + LinkedListCycleLength.findCycleLength(head));
    }
}
