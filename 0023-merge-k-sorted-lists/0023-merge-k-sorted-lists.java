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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node : lists){
            if(node!=null)
            queue.offer(node);
        }
        ListNode ans = new ListNode(-1);
        ListNode prev = ans;

        while(queue.size()>0)
        {
            ListNode node = queue.poll();
            prev.next = node;
            prev=prev.next;
            if(node.next!=null)
            queue.offer(node.next);
        

        }
        return ans.next;
        
    }
}