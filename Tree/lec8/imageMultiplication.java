//------------------------------- GFG ------------------------
class Solution {
    long ans = 0;
    long mod = 1000000007;
    
   public long imgMultiply(Node root){
       ans = (root.data*root.data)%mod;
       imgMultiplyHelper(root.left,root.right);
       return ans; 
       
   }
   public void imgMultiplyHelper(Node n1,Node n2){
        if(n1 == null || n2 == null) return;
           ans =(ans + n1.data*n2.data)%mod;
           imgMultiplyHelper(n1.left,n2.right);
           imgMultiplyHelper(n1.right,n2.left);
    }
}