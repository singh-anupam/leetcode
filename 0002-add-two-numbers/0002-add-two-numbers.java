/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)
        return l2;
        if(l2==null)
        return l1;
        int carry =0;
        ListNode prev=new ListNode(-1);
        ListNode head= l1;
        while(l1!=null && l2!=null){
            int sum = l1.val+l2.val+carry;
            l1.val=sum%10;
            carry =sum/10;
            prev.next=l1;
            prev=prev.next;
            l1=l1.next;
            l2=l2.next;

        }
        while(l1!=null){
            int sum =l1.val+carry;
            l1.val=sum%10;
            carry =sum/10;
            prev.next=l1;
            prev=prev.next;
            l1=l1.next;
        }

        while(l2!=null){
            int sum =l2.val+carry;
            l2.val=sum%10;
            carry =sum/10;
            prev.next=l2;
            prev=prev.next;
            l2=l2.next;
        }

        if(carry>0)
        prev.next=new ListNode(carry);

        return head;

        
    }
}