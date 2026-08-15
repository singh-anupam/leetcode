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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = new ListNode(0);
        ListNode root = head;
    
        for(int i=1;i<left;i++){
            prev = head;
            head=head.next;
        }
        int k = right-left;
        ListNode tmp = head;

        ListNode arr[] = reverse(head,k);
        tmp.next = arr[1];
        prev.next = arr[0];

        return left==1?prev.next:root;



        
    }

    private ListNode[] reverse(ListNode head, int k){
        ListNode prev = null;

        while(k>=0){
            ListNode temp = head.next;
            head.next=prev;
            prev = head;
            head =temp;
            k--;
        }
      
        return new ListNode[]{prev,head};

    }
}