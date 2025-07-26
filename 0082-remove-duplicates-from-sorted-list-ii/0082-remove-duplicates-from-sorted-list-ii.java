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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
        return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode prev = new ListNode(-101);
        while(head!=null){
            if(stack.size()>0 && head.val==stack.peek().val){
               ListNode node= getNode(head);
               head=node;
            //    if(node!=null)
            //    System.out.println(node.val+" "+head.val);
               stack.pop();
               if(node!=null && stack.size()>0)
               {
                stack.peek().next=node;
                
                }
            }
            if(head!=null)
            {stack.push(head);

            head= head.next;
            }
        }
        stack.peek().next=null;
        while(stack.size()>0){
            prev=stack.pop();
        }
        return prev;

        
    }

    private ListNode getNode(ListNode head){
        ListNode prev = head;
        while(head!=null && head.val==prev.val){
            head=head.next;
        }
        return head;


    }
}