/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)
        return null;
        ListNode root1 = headA;
        ListNode root2=headB;
        ListNode prev =headA;
        ListNode temp =headA;

        while(headA!=null){
             prev=headA;
            headA=headA.next;
           

        }
        prev.next = temp;

        ListNode slow = headB;
        ListNode fast = headB;
        while(fast!=null && fast.next!=null){
            
            slow =slow.next;
            fast = fast.next.next;
            if(slow==fast)
            break;
        }
        ListNode ans =null;
        while(headB!=null){
            if(slow==headB)
            {
                ans=slow;
                break;
            }
            headB=headB.next;
            if(slow==null){
                ans =null;
                break;
            }
            slow=slow.next;
        }
        prev.next=null;
        headA=root1;
        headB=root2;
        
        return ans;
    }
}