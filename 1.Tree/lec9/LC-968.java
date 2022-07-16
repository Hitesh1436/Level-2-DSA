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
    int count=0;
    final int cam = 1;
    final int mon = 2;
    final int non = 3;
    public int minCameraCover(TreeNode root) {
        int val = getCamera(root);
        if(val == non){
            count++;
        }
            return count;
    }
    private int getCamera(TreeNode node){
        if(node == null) return mon;
        // post order mn krrhe hn 
        int left = getCamera(node.left);
        int right = getCamera(node.right);
        
        if(left == non || right == non){
            count++;
            return cam;
        }else if(left == cam || right == cam){
            return mon;
        }else{
            return non;
        }
    }
}