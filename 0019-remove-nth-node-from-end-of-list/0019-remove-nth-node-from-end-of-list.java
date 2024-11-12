/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode slow = root;
        ListNode fast = root;
       for(int i=1;i<=n+1;i++)
       {
           fast = fast.next;
       }
        while(fast!=null)
        {
            fast = fast.next;
            slow = slow.next;
            
        }
        slow.next = slow.next.next;
        return root.next;
    }
}