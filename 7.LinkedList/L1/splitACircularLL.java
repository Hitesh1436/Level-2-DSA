// -------------- GFG -> Split a Circular Linked List into two halves

class gfg{
    // Function  to split a circular LinkedList
    void splitList(circular_LinkedList list){
         if(list.head == null){
             return;
         }else if(list.head.next == list.head){
             list.head1 = list.head;
             list.head2 = null;
             return;
         }
    Node fast = list.head;
    Node slow = list.head;
    while(fast.next != list.head && fast.next.next != list.head){
        fast = fast.next.next;
        slow = slow.next;
    }
    list.head1 = list.head;
    list.head2 = slow.next;
    
    slow.next = list.head1;
    if(fast.next == list.head){
        fast.next = list.head2;
    }else{
        fast.next.next = list.head2;
    }
 }
}