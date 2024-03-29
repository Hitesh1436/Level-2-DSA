public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sa = getSize(headA);
        int sb = getSize(headB);
        int gap = sa - sb;
        
        if(gap >= 0){
            for(int i = 0; i < gap; i++){
                headA = headA.next;
            }
        } else {
            gap = Math.abs(gap);
            for(int i = 0; i < gap; i++){
                headB = headB.next;
            }
        }
        
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
    
    int getSize(ListNode temp){
        int sz = 0;
        
        while(temp != null){
            sz++;
            temp = temp.next;
        }
        
        return sz;
    }
}