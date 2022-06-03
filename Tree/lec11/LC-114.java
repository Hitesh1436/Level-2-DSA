// Approach 1-> Using Pair Class

class Solution {
    class Pair{
        TreeNode head;
        TreeNode tail;
        Pair(){
            
        }
        Pair(TreeNode head,TreeNode tail){
            this.head = head;
            this.tail = tail;
        }
    }
    public void flatten(TreeNode root) {
        if(root != null){
            helper(root);
        }
    }
    private Pair helper(TreeNode node){
        if(node.left != null && node.right != null){ 
            Pair lp = helper(node.left);
            Pair rp = helper(node.right);
            Pair myP = new Pair();
            
            myP.head = node;
            myP.head.left= null;
            myP.head.right = lp.head;
            lp.tail.right = rp.head;
            myP.tail = rp.tail;
            
            return myP;
        }else if(node.left != null){
            Pair lp = helper(node.left);
            Pair myP = new Pair();
            
            myP.head = node;
            myP.head.left= null;
            myP.head.right = lp.head;
            myP.tail = lp.tail;
            
            return myP;
        }else if(node.right != null){
            Pair rp = helper(node.right);
            Pair myP = new Pair();
            
            myP.head = node;
            myP.head.left= null;
            myP.head.right = rp.head;
            myP.tail = rp.tail;
            
            return myP;
        }else{
          Pair myP = new Pair(node,node);
            return myP;
        }
    }
}



// Approach 2 -> Using Reverse Post-Order

class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null)return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}



//Approach 3-> Using Pre-Order Traversal

class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null)return;

        TreeNode ol = root.left;
        TreeNode or = root.right;
        
        if(prev != null){
        prev.left  = null;
        prev.right = root;
    }
        prev = root;

        flatten(ol);
        flatten(or); 
    }
}
