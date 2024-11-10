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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
        return head;
        ListNode root = new ListNode(0);
        ListNode prev = root;
        while(head!=null && head.next!=null){
            ListNode temp = head.next;
            head.next=temp.next;
            temp.next=head;
            prev.next=temp;
            prev=head;
            head=head.next;
        }
        return root.next;
        
    }
}