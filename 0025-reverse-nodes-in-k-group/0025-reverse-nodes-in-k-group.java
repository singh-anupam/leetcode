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
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        int noOfNode = getSize(head);
        ListNode ans = new ListNode(-1);
        ListNode prev =ans;
        while(noOfNode-k>=0)
        {
            ListNode temp = head;
            ListNode pair[]= reverse(head,k);
            prev.next = pair[0];
            prev = temp;
            head = pair[1];
           noOfNode-=k;
        //    System.out.println(noOfNode+" "+k);
        }
        prev.next =head;
        
        return ans.next;
        
        
        
    }
    
    private int getSize(ListNode head)
    {
     
        ListNode slow = head;
        int count =0;;
        while(slow!=null)
        {
            
            slow = slow.next;
            count++;
        }
        return count;
    }
    
    private ListNode[] reverse(ListNode head, int k)
    {
        ListNode p =null;
        ListNode l =head;
        while(k-->0)
        {
            ListNode temp = head.next;
            head.next =p;
            p =head;
            head = temp;
        }
        return new ListNode[]{p,head};
    }
}