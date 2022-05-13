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
    public class pair{
        int sum;
        int count;
        pair(int sum,int count){
            this.sum = sum;
            this.count = count;
        }
    }
    int ans = 0;
    public pair  helper(TreeNode root){
        if(root == null){
            return new pair(0,0);
        }
        pair left = helper(root.left);
        pair right = helper(root.right);
        
        int avg = (int)((left.sum + right.sum + root.val)/(left.count+right.count+1));
        
        if(avg == root.val){
              ans++;
        }
        return new pair(left.sum + right.sum + root.val,left.count+right.count+1);
    }
    public int averageOfSubtree(TreeNode root) {
        pair avg = helper(root);
        return ans;
    }
}