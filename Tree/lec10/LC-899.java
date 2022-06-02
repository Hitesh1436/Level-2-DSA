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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<postorder.length;i++){
            map.put(postorder[i],i);
        }
        TreeNode root = helper(preorder,postorder,map,0,preorder.length-1,0,postorder.length-1);
        return root;
    }
    private TreeNode helper(int []pre,int[]post,HashMap<Integer,Integer> map,int prelo,int prehi,int postlo,int posthi){
        if(prelo> prehi || postlo > posthi){
            // base case
            return null;
        }
        TreeNode ans = new TreeNode(pre[prelo]);
        if(prelo + 1 <= prehi){
            int searchIdx = map.get(pre[prelo+1]);
            int lhs = searchIdx - postlo +1;
            
            ans.left = helper(pre,post,map,prelo+1,prelo+lhs,postlo,searchIdx);
            ans.right = helper(pre,post,map,prelo+lhs+1,prehi,searchIdx+1,posthi-1);
        }
        return ans;
    }
}