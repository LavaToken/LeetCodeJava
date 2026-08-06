package Leetcode;
// 83. Remove Duplicates from Sorted List
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
import java.util.Arrays;

public class DeleteDuplicates {
    public static void main(String[] args){
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        int[] nums = {1, 1, 2};
        int[] result = deleteDuplicates.deleteDuplicates(nums);
        System.out.println(Arrays.toString(result));
    }
    
    public ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode current = head;
        while(current != null && current.next != null){
            if(current.val == current.next.val){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
        return head;
    }
}

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
        