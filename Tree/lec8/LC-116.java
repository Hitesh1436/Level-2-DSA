//--------------------------------- Single pointer use krke-----------------

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Node curr = root;
        if(curr.left != null){
            curr.left.next = curr.right;
            if(curr.next != null){
                curr.right.next = curr.next.left;
            }
        }
        if(curr.left != null){
            connect(root.left);
        }
        if(curr.right != null){
            connect(root.right);
        }
        return curr;
    }
}

//------------------------------- Two pointer ---------------------------

// class Solution {
//     public Node connect(Node root) {
//         Node n1 = root;
//         while( n1 != null){
//            Node n2 = n1;
//             while(n2 != null){
//                if(n2.left != null){
//                    n2.left.next = n2.right;
//                } 
//                 if(n2.right != null && n2.next != null){
//                     n2.right.next = n2.next.left;
//                 }
//                 n2 = n2.next;
//             }
//             n1 = n1.left;
//         }
//         return root;
//     }
// }