// 86. Partition List
// https://leetcode.com/problems/partition-list/

public class PartitionList {
    public static void main(String[] args){
        PartitionList partitionList = new PartitionList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode result = partitionList.partition(head, 3);
    }

    public ListNode partition(ListNode head, int x){
        if(head == null || head.next == null){
            return head;
        }
        ListNode less = new ListNode(0); // pointer 1
        ListNode greater = new ListNode(0); // pointer 2

        ListNode lessHead = less;
        ListNode greaterHead = greater;

        while(head != null){
            if(head.val < x){
                less.next = head;
                less = less.next;
            }else{
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        less.next = greaterHead.next;
        greater.next = null;
        return lessHead.next;
    }
}

public class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}