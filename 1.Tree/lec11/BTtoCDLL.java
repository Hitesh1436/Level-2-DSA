// ------ GFG    -->     Binary Tree to Doubly Circular Doubly LinkedList


// Class Approach 

class Solution{
    //Function to convert binary tree into circular doubly linked list.
    Node bTreeToClist(Node root){
        return helper(root);
    }
    Node helper(Node node){
        if(node == null)return null;
        
        Node lhead = helper(node.left);
        Node rhead = helper(node.right);
        
        Node one = node;
        one.left = one.right = one;
        Node s1 = concat(lhead,one);
        Node s2 = concat(s1,rhead);
        return s2;
    }
    Node concat(Node h1,Node h2){
        if(h1 == null){
            return h2;
        }else if(h2 == null){
            return h1;
        }
        Node t1 = h1.left;
        Node t2 = h2.left;
        
        t1.right = h2;
        h2.left = t1;
        
        t2.right = h1;
        h1.left = t2;
        
        return h1;
    }
}



// Other Approach 

class Solution{
    Node prev = null, head;
     Node bTreeToClist(Node root){
            if(root == null){
             return root;
         }
         Node left = bTreeToClist(root.left);
         if(left == null && prev == null){
             head = root;
         }else{
             prev.right = root;
             root.left = prev;
         }
         prev = root;
         Node right = bTreeToClist(root.right);
         if(right == null){
             head.left = prev;
             prev.right = head;
         }
         return head;
     }
    }


    // Third Approach 


    class Solution{
        Node start;
        Node prev;
        private void helper(Node root){
            if(root==null)return;
            helper(root.left);
            if(prev==null){
                start=root;
            }
            else{
                prev.right=root;
                root.left=prev;
            }
            prev=root;
            helper(root.right);
        }
        //Function to convert binary tree into circular doubly linked list.
        Node bTreeToClist(Node root){
      
            helper(root);
            Node last=prev;
            last.right=start;
            start.left=last;
            return start;
        }
    }