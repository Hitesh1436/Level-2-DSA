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
    
    private int max(TreeNode node){
        TreeNode curr = node;
        while(curr.right != null){
            curr = curr.right;
        }
        return curr.val;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        
        if(key < root.val){
            root.left = deleteNode(root.left,key);
        }else if(key > root.val){
            root.right = deleteNode(root.right,key);
        }else{
            // equal ho toh
            if(root.left == null || root.right == null){
                return root.left != null ? root.left : root.right;
            }
            // dono child hue toh
            int maxVal = max(root.left);
            root.val = maxVal;
            root.left = deleteNode(root.left,maxVal);
        }
        return root;
    }
}
          