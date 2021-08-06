

public class LinkedListCycleStart {

    public static ListNode findCycleStart(ListNode head) {
        int len = findLength(head);
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while(len!=0){
            fastPtr = fastPtr.next;
            len--;
        }
        while(slowPtr!=fastPtr){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        return slowPtr;
    }
    public static int findLength(ListNode head){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while(fastPtr!=null && fastPtr.next!=null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr==fastPtr)
                break;
        }
        ListNode temp = slowPtr;
        int len=0;
        do{
            temp = temp.next;
            len++;
        }while(temp!=slowPtr);
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
        //System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        //System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
       // System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
    }
}