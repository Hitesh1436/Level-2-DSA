class Solution {
    public ListNode reverseList(ListNode head) {
        left = head;
        helper(head);  
        return head;
    }
    
    boolean work = true;
    ListNode left;
    void helper(ListNode right){
        if(right == null){
            return;
        }
        helper(right.next);
        
        if(work){
            if(left == right || left.next == right){
                work = false;
            } 
            
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
            
            left = left.next;
        }
        
    }   
}