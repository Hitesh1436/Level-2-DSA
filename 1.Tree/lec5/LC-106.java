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
    
    private TreeNode helper(int[] inorder,int iStart,int iEnd, int[] postorder,int poStart,int poEnd){
        if(iStart > iEnd || poStart> poEnd){
            return null;
        }
        int idx = iStart;
        while(inorder[idx] != postorder[poEnd]){
            idx++;
        }
        // tnol = total number of elements
        int tnol = idx - iStart;
        TreeNode ans = new TreeNode(postorder[poEnd]);
        
        ans.left = helper(inorder,iStart,idx-1,postorder,poStart,poStart+tnol-1);
        ans.right= helper(inorder,idx+1,iEnd,postorder,poStart+tnol,poEnd-1);
        
        return ans;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        return helper(inorder,0,n-1,postorder,0,n-1);
    }
}