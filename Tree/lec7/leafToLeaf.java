class Solution{
    int max;        // maximum of leaf to leaf dega yeh
    int maxPathSum(Node root){
       max = Integer.MIN_VALUE;
       helper(root);
       return max;
    } 
    
    int helper(Node node){
        if(node.left!=null && node.right!=null){
            int left = helper(node.left);
            int right = helper(node.right);
            
            max = Math.max(max,left + node.data + right);
            
            return Math.max(left,right) + node.data;
        }else if(node.left != null){
             int left = helper(node.left);
            return node.data + left;
        }else if(node.right != null){
            int right = helper(node.right);
            return node.data + right;
        }else{
            return node.data;
        }
    }
}