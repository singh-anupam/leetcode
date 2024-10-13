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
    public ListNode middleNode(ListNode head) {
        ListNode root = head;
        
        int size = getSize(head);
        
        int mid = size%2==0?size/2:(size)/2;
        while(mid>0)
        {
            root = root.next;
            mid--;
        }
        
        return root;
        
    }
    
    private int getSize(ListNode node)
    {
        int count =0;
        while(node!=null)
        {
            node =node.next;
            count++;
        }
        return count;
    }
}