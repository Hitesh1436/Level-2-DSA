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
    
    int xKaLeft;
    int xKaRight;
    
    public int size(TreeNode node , int x){
        if(node == null){
            return 0;
        }
        
        int leftSize  = size(node.left,x);
        int rightSize = size(node.right,x);
        
        if(node.val == x){
            xKaLeft = leftSize;
            xKaRight = rightSize;
        }
        int totalSize = leftSize + rightSize + 1;
        return totalSize;
    }
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        size(root,x);
         
        int otherSide = n -(xKaLeft + xKaRight +1);
        
        int maxOfThree = Math.max(otherSide,Math.max(xKaLeft,xKaRight));
        
        int rest = n - maxOfThree;
        if(maxOfThree > rest){
            return true;
        }
        return false;
    }
}