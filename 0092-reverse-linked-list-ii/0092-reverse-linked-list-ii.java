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
        
        ListNode root = head;
        
        if(head==null)
            return root;
        int pos=1;
     ListNode prev = new ListNode(-1);
        while(pos<left)
        {
            
            prev = head;
            head=head.next;
        //    System.out.println(prev.val+" "+head.val);
            pos++;
            
        }
        ListNode temp = head;
    //    System.out.println(temp.val);
        ListNode arr[] = reverse(head,right,pos);
        
        prev.next = arr[0];
        temp.next = arr[1];
        
    //    System.out.println(temp.val);
        
        if(1==left)
            return prev.next;
        return root;
        
        
    }
    
    
    private ListNode[] reverse(ListNode head,int right, int pos)
    {
        ListNode prev = null;
        ListNode temp=head.next;
        while(pos<=right)
        {
         //   System.out.println(head.val);
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
          //  System.out.println(prev.val+" "+head.val);
            pos++;
        
            
        }
         
        
         
        
        return new ListNode[]{prev,head};
    }
}