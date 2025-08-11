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
    public ListNode oddEvenList(ListNode head) {

        ListNode root1 = head;
        ListNode root2 = head.next;
        ListNode temp1=root1;
        ListNode temp2 = root2;
        while(temp2!=null && temp2.next!=null){
            temp1.next = temp1.next.next;
            temp2.next=temp2.next.next;
            temp1=temp1.next;
            temp2=temp2.next;
        }

        temp1.next=root2;
        return root1;
        
    }
}