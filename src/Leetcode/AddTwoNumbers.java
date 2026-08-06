public class AddTwoNumbers {
    public static void main(String[] args){
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode res = addTwoNumbers(l1, l2);
        printList(res);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int carry = 0;
        ListNode a = l1;
        ListNode b = l2;
        ListNode answer = new ListNode(0);
        ListNode ans = answer;
        while(a != null || b != null){
            int x = (a != null) ? a.val : 0;
            int y = (b != null) ? b.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            ans.next = new ListNode(sum % 10);
            ans = ans.next;

            if(a != null){
                a = a.next;
            }
            if(b != null){
                b = b.next;
            }

            if(carry > 0){
                ans.next = new ListNode(carry);
            }
        }
        return answer.next;
    }

    public static void printList(ListNode l){
        System.out.print("[");
        while(l != null){
            System.out.print(l.val);
            l = l.next;
            if(l != null){
                System.out.print(", ");
            }
        }
        System.out.print("]\n");
    }
}


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }