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
    ListNode begin;
    int max = 0;
    public int pairSum(ListNode head) {
        begin = head;
        find(head);
        return max;
        
    }

    private void find(ListNode head){
        if(head==null)
        return;
        find(head.next);
        max = Math.max(head.val+begin.val,max);
        begin=begin.next;
    }
}