/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       int n = inorder.length;
       return helper(preorder,0,n-1,inorder,0,n-1);
   }
   private TreeNode helper(int[] preorder,int pStart,int pEnd,int[] inorder,int iStart,int iEnd){
       if(iStart> iEnd){
           return null;
       }
       int idx = iStart;
       while(inorder[idx]!= preorder[pStart]){
           idx++;
       }
        int tnol = idx-iStart;
       TreeNode ans = new TreeNode(preorder[pStart]);
     
       ans.left = helper(preorder,pStart+1,pStart+tnol,inorder,iStart,idx-1);
       ans.right = helper(preorder, pStart+tnol+1,pEnd,inorder,idx+1,iEnd);
       return ans;
   }
}